package section01_string;


public class Pb_07_palindrome_string {
    /**
     *  주어진 문자열이 앞에서 읽을 때나 뒤에서 읽을 때나 같은 문자열(palindrome,회문 문자열)이면 YES 를 출력, 아니면 NO 를 출력
     *  대소문자를 구분하지 않습니다.
     */
    public String solution1(String s) {
        String answer = "YES";          //문자열 비교후 참일시 반환할 YES

        String value = s.toLowerCase(); //소문자로 컨버팅
        int len = s.length()/2;         //입력된 문자열의 길이 / 2

        for (int i = 0; i < len; i++) { // 문자열 길이의 절반 만큼 돌면서 처음과 마지막 인덱스 부터 비교 후 값이 다르다면 NO 반환
            if (value.charAt(i) != value.charAt(len - i - 1)) return "NO";
        }
        return answer;                  //문자열이 모두 같을 경우 YES 반환
    }

    public String solution2(String s) {
        String value = "";                //주어진 문자열을 마지막 인덱스 부터 저장할 변수 정의

        for (int i = s.toCharArray().length - 1; i >= 0; i--) { // 문자열의 마지막 인덱스 부터 변수에 저장
            value += s.charAt(i);
        }

        return s.equalsIgnoreCase(value) ? "YES" : "NO";  //입력된 문자열과 순서를 바꿔 저장한 변수를 비교 후 YES or NO 반환
    }

    public String solution3(String s) {
        return new StringBuilder(s)   //입력된 문자열을 StringBuilder class 에 reverse()로 순서를 바꿔서 비교 후 YES or NO 반환
                .reverse()
                .toString()
                .equalsIgnoreCase(s)? "YES" : "NO";
    }

    public static void main(String[] args) {
        Pb_07_palindrome_string p = new Pb_07_palindrome_string();

        String input = "Dad";

        System.out.println("input= "+input+", solution1= "+p.solution1(input));
        System.out.println("input= "+input+", solution2= "+p.solution2(input));
        System.out.println("input= "+input+", solution3= "+p.solution3(input));
    }
}
