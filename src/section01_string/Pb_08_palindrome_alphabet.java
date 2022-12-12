package section01_string;


/**
 * 문자열이 입력 되었을 때 문자열이 palindrome 이면 "일치" 아니면 "불일치" 를 반환 합니다.
 * 검사 조건은 알파벳만 , 대소문자 구분 x 하여 알파벳 이외 문자는 무시합니다.
 */
public class Pb_08_palindrome_alphabet {
    public String solution(String s) {
        //문자열을 대문자로 바꾸고 replaceAll()로 정규식을 사용하요 대문자가 아닐경우 공백 처리
        String replaced = s.toUpperCase().replaceAll("[^A-Z]", "");
        //알파벳만 남은 문자열을 뒤집고
        String target = new StringBuilder(replaced).reverse().toString();
        //palindrome 이면 "일치: 아니면 "불일치" 반환
        return replaced.equals(target) ? "일치" : "불일치";
    }

    public static void main(String[] args) {
        Pb_08_palindrome_alphabet p = new Pb_08_palindrome_alphabet();

        String s1 = "test12 is non si tset!#";
        String s2 = "Dream come true";
        System.out.println("input1 ="+s1);
        System.out.println("result1= "+p.solution(s1));
        System.out.println("input2 ="+s2);
        System.out.println("result2= "+p.solution(s2));
    }
}
