package section01_string;


public class Pb_06_remove_duplication {
    /**
     * 중복 문자 제거
     * 소문자로 이루어진 한개의 문자열에서 중복된 문자를 제거하고 출력
     * 중복이 제거된 문자열의 각 문자는 원래 문자열의 순서를 유지
     */
    public String solution1(String s) {
        StringBuilder result = new StringBuilder();                        //결과를 받을 변수 선언

        for (int i = 0; i < s.length(); i++) {     //문자열의 인덱스로 for 문을 돌면서
            String c = String.valueOf(s.charAt(i));//입력된 문자열의 각 인덱스에 문자가
            if (!result.toString().contains(c)) {             //result 에 포함하지 않는 다면 문자열 더하기
                result.append(c);
            }
        }
        return result.toString();                              //중복이 제거된 결과 반환
    }

    /**
     * solution1 과 같은 원리입니다.
     */
    public String solution2(String s) {
        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == i) {
                result += s.charAt(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Pb_06_remove_duplication p = new Pb_06_remove_duplication();
        String s = "aacdzvssgg";
        System.out.println("input= "+s+", distinct result="+p.solution1(s));
        System.out.println("input= "+s+", distinct result="+p.solution2(s));
    }
}