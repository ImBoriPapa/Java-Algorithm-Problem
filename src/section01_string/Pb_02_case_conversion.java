package section01_string;


public class Pb_02_case_conversion {
    /**
     * 대문자와 소문자가 같이 존재하는 문자열을 입력받아 대소문자는 소문자로 소문자는 대문자로 변환
     */
    public String solution1(String s) {//문자열 입력

        String result = ""; // 결과를 받을 문자열 생성
        for (char c : s.toCharArray()) { // 문자열을 문자배열로 변환하고(toCharArray()) for 문을 돌리고
            //Character.isLowerCase()로 문자가 소문자인지 확인 후 참이면 toUpperCase()로 대문자로 변경
            // 거짓이면 소문자로 변경
            char value = Character.isLowerCase(c) ? Character.toUpperCase(c) : Character.toLowerCase(c);
            //결과를 비어있는 문자열에 담아서 반환
            result += value;
        }

        return result;
    }

    //USE ASCII
    //Lower Case 97~122 , UpperCase 65 ~ 90
    //ASCII Code 에 소문자 범위는 97~122, 대문자의 범위는 65 ~ 90
    //소문자 - 32 -> 대문자,  대문자 +32는 소문자로 변경된다.
    public String solution2(String s) {

        String result = "";
        for (char c : s.toCharArray()) {
            //solution1과 같이 정보를 for 문을 돌면서
            // 문자열에 문자가 97보다 크거나 같다면 대문자로 변환 아니라면 소문자로 변환
            char value = c >= 97 ? (char) (c - 32) : (char) (c + 32);

            result += value;
        }

        return result;
    }

    public static void main(String[] args) {
        Pb_02_case_conversion p = new Pb_02_case_conversion();
        String str = "AAAAAccccc";
        System.out.println(p.solution1(str));
        System.out.println(p.solution2(str));

    }
}

