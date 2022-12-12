package section01_string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Pb_04_reverse_word {
    /**
     * N개의 단어가 주어지면 각 단어를 뒤집어서 출력
     */
    public List<String> solution1(String... words) {//가변인자로 String 배열을 입력
        ArrayList<String> result = new ArrayList<>(); // 결과를 저장할 ArrayList 생성

        for (String s : words) { // 문자 배열을 for 문으로 돌면서
            //배열의 문자를 StringBuilder 의 reverse()를 사용해 문자를 뒤집어준다.
            StringBuilder builder = new StringBuilder(s);
            builder.reverse();

//            StringBuffer 또한 같은 기능을 제공한다.
//            StringBuffer stringBuffer = new StringBuffer(s);

            /**
             * String       : 불변(immutable),thread-safe
             * StringBuilder: 가변(mutable),단일 쓰레드에서의 성능은 StringBuffer 보다 우수
             * StringBuffer : 가변(mutable),thread-safe
             */

            result.add(builder.toString());// 결과 저장
        }
        return result;//결과 반환
    }

    public List<String> solution2(String... words) {//solution1 과 같이 문장 배열을 받고
        ArrayList<String> result = new ArrayList<>();

        for (String s : words) {
            char[] chars = s.toCharArray(); // 배열의 문장을 문자 배열로 변경
            int start = 0;                  // 문자 배열의 첫번째 인덱스를 가르킬 변수
            int last = s.length() - 1;      // 문자 배열의 마지막 변수를 가르킬 변수 ex) s.length() = 5 라고 가정하면 s 배열의 마지막 인덱스는 s[4]
            while (start < last) {          // 반복문을 돌면서 start+1 ,last-1 하여 두 숫자가 같아 질때까지 반복
                char tmp = chars[start];    // 인덱스 0(start=0)부터 시작해서 변수에 값을 변경
                chars[start] = chars[last];
                chars[last] = tmp;
                start++;
                last--;
            }
            /**
             * // ex) chars.length()=5 일 경우
             * 1. tmp =  chars[0] -> chars[0] = chars[5] -> chars[5] = tmp
             * 2. tmp =  chars[1] -> chars[1] = chars[4] -> chars[4] = tmp
             * 3. tmp =  chars[2] -> chars[2] = chars[3] -> chars[3] = tmp
             * 4. chars[start] = 3 !< chars[last]=3 이므로 while 문 종료
             */
            result.add(String.valueOf(chars));// String.valueOf()로 문자 배열을 문장으로 변경해서 반환
        }
        return result;
    }

    public List solution3(String... words) {
        ArrayList<String> result = new ArrayList<>();
        /**
         * 문장을 뒤집어서 문자 배열로 반환하는 로직을 메서드로 추출 후 stream 에 최종 연산 foreach 로 결과 저장 후 반환
         */
        Arrays.stream(words).forEach(m -> result.add(String.valueOf(getChars(m))));
        return result;
    }

    private char[] getChars(String s) {
        char[] chars = s.toCharArray();
        int start = 0;
        int last = s.length() - 1;
        while (start < last) {
            char tmp = chars[start];
            chars[start] = chars[last];
            chars[last] = tmp;
            start++;
            last--;
        }
        return chars;
    }

    public static void main(String[] args) {
        Pb_04_reverse_word p = new Pb_04_reverse_word();

        String s1 = "Pizza";
        String s2 = "Chicken";
        String s3 = "Food or Die";

        p.solution1(s1, s2, s3).stream().forEach(System.out::println);
        p.solution2(s1, s2, s3).stream().forEach(System.out::println);
        p.solution3(s1, s2, s3).stream().forEach(System.out::println);

    }
}
