package section01_string;

import java.util.Scanner;

public class Problem_05_reverse_specific_word {
    /**
     * 영어 알파벳과 특수 문자로 구성된 문자열이 주어지면 알파벳만 뒤집고 특수문자는 자기 자리에 그대로 있는 문자열을 반환
     */
    public String solution1(String s) {//문자열 입력

        char[] chars = s.toCharArray(); // 문자열을 문자 배열로 변환

        int start = 0;             //문자 배열의 첫 인덱스를 가르킬 변수
        int last = s.length() - 1; //문자 배열의 마지막 인덱스를 가르킬 변수

        while (start < last) {     //순환하면서 시작 인덱스는 값이 1씩 증가하고  마지막 인덱스는 값이 1씩 감소하면서 값이 같아 지면 순환 종료

            if (!Character.isAlphabetic(chars[start])) {  //순환시 첫 인덱스 부터 가르키는 값이 알파벳(isAlphabetic())이 아닐경우는 값을 변경하지 않고 인덱스 증가
                start++;
            } else if (!Character.isAlphabetic(chars[last])) {//순환시 마지막 인덱스 부터 가르키는 값이 알파벳(isAlphabetic())이 아닐경우는 값을 변경하지 않고 인덱스 감소
                last--;
            } else {  //인덱스가 가르키는 값이 알파벳일 경우 자리 변경
                char tmp = chars[start];
                chars[start] = chars[last];
                chars[last] = tmp;
                start++;
                last--;
            }
        }
        return String.valueOf(chars); // String 으로 변경된 값 반환
    }

    /**
     * Character.isAlphabetic() 메서드는 영문자(한글 자음, 모음 포함) 확인을 한다.
     * 그러므로 한글 자음,모음도 자리를 변경하지 않고 영문자만 자리를 변경하기 위해 Ascii 코드를 사용한 검증 로직을 사용
     *
     */
    public  String solution2(String s){

        char[] chars = s.toCharArray(); // 문자열을 문자 배열로 변환

        int start = 0;             //문자 배열의 첫 인덱스를 가르킬 변수
        int last = s.length() - 1; //문자 배열의 마지막 인덱스를 가르킬 변수

        while (start < last) {     //순환하면서 시작 인덱스는 값이 1씩 증가하고  마지막 인덱스는 값이 1씩 감소하면서 값이 같아 지면 순환 종료

            if (customIsAlphabetic(chars[start])) {  //순환시 첫 인덱스 부터 가르키는 값이 Ascii code 97~122 or 65~90이 아닐경우 start + 1
                start++;
            } else if (customIsAlphabetic(chars[last])) {//순환시 첫 인덱스 부터 가르키는 값이 Ascii code 97~122 or 65~90이 아닐경우 last - 1
                last--;
            } else {  //인덱스가 가르키는 값이 알파벳일 경우 자리 변경
                char tmp = chars[start];
                chars[start] = chars[last];
                chars[last] = tmp;
                start++;
                last--;
            }
        }
        return String.valueOf(chars); // String 으로 변경된 값 반환
    }

    private  boolean customIsAlphabetic(char chars) { //순환시 첫 인덱스 부터 가르키는 값이 Ascii code 97~122 or 65~90이 아닐경우 false
        return !(97 <= (int) chars && (int) chars <= 122 || 65 <= (int) chars && (int) chars <= 90);
    }


    public static void main(String[] args) {
        Problem_05_reverse_specific_word p = new Problem_05_reverse_specific_word();
        Scanner sc = new Scanner(System.in);
        System.out.println(p.solution1(sc.next()));
        String word1 = "A@FBfdf2#2C@!D";
        String word2 = "AV@#!ㄴㄹㅎㅎㅂㅋSFF@$";

        System.out.println("solution1 input = "+word1+" convert result= "+p.solution1(word1));
        System.out.println("solution1 input = "+word2+" convert result= "+p.solution1(word2));
        System.out.println("solution2 input = "+word1+" convert result= "+p.solution2(word1));
        System.out.println("solution2 input = "+word2+" convert result= "+p.solution2(word2));
    }
}
