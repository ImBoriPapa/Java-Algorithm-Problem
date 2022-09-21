package section01;

import java.util.Scanner;

public class Section_01_01 {

    /**
     * 문자 찾기
     * 문자열에서 같은 문자 개수 찾기
     * 대소 문자 구분 x
     *
     * @return 같은 문자 개수
     */
    public static int solution(String s, char c) {// 문자열 s, 문자 c

        //문자열 s를 소문자로 변환(toLowerCase)
        String target = s.toLowerCase();
        //문자 c를 소문자로 변환
        c = Character.toLowerCase(c);
        //같은 문자의 개수를 저장할 변수
        int count = 0;

        //문자열을 s를 문자 배열로 변경(toCharArray()) 후 for 문을 사용
        for (char ch : target.toCharArray()) {
            //삼항 연산자를 사용해 문자 배열로 변경된 문자열 s에 문자 c를 비교하여 같으면
            //변수 count + 1 같지 않다면 count + 0
            count = (ch == c) ? count + 1 : count + 0;
        }
        // 변수를 반환
        return count;
    }

    public static void main(String[] args) {

        String s = "Java is OOP Language";
        char c = 'a';


        System.out.println("result =" + solution(s, c));

    }
}
