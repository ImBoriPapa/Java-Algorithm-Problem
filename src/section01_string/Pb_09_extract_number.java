package section01_string;

/**
 * 문자와 숫자가 섞여있는 문자열이 주어지며ㅓㄴ 그 중 숫자만 추출해서 순서대로 자연수를 만들어 반환
 */
public class Pb_09_extract_number {

    public Integer solution1(String data) {
        Integer result = 0;                                         //결과 값

        for (char c : data.toCharArray()) {                         //문자열 data 순회
            if (c >= 48 && c <= 57) result = result * 10 + (c - 48);//ascii 코드로 숫자 검증 후 숫자면 결과에 합
        }

        return result;                                              //결과 반환
    }

    public Integer solution2(String data) {
        String result = "";                                   //결과 값

        for (char c : data.toCharArray()) {                   //문자열 data 순회
            result = addIfDataIsNumber(result, c);            // 숫자일시 결과갑에 더히기
        }

        return Integer.parseInt(result);                       //integer 로 변경
    }

    private static String addIfDataIsNumber(String result, char c) { //Character.isDigit()로 숫자 검증
        if (Character.isDigit(c)) result = result += c;
        return result;
    }

    public static void main(String[] args) {
        Pb_09_extract_number extractNumber = new Pb_09_extract_number();
        Integer solution = extractNumber.solution2("g0en2T0s8eSoft");
        System.out.println(solution);

    }

}
