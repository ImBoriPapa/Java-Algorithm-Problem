package section01_string;


public class Problem_03_find_long {
    /**
     * 1.한 개의 문장에서 가장 긴 단어를 반환
     * 2.가장 긴 단어가 여러개일 경우 문장속에서 가장 앞쪽에 위치한 단어를 반환
     * 3.문장속 단어는 공백으로 구분
     */
    public String solution1(String str) {// 문장 입력

        String result = ""; // 결과를 저장할 변수
        String tmp = "";    // 결과를 임시 저장할 변수

        for (String s : str.split(" ")) { // 문장을 공백을 기준으로 단어를 나누어(split(" ")) for 문으로 돌리고

            if (s.length() > tmp.length()) {// 분기문으로 단어의 길이를 비교 후 길이가 가장 긴 단어를 결과에 저장
                tmp = s;
                result = tmp;
            } else if (s.length() == tmp.length()) { // 단어의 길이가 같을 경우 결과에 저장된 값을 변경하지 않고
                result = tmp;
            }
        }
        return result; // 반환
    }

    public String solution2(String str) { //solution1 과 같이 문장을 입력 받고 최종 결과와 임시 저장할 변수를 생성
        String result = "";
        String tmp = "";
        for (String s : str.split(" ")) { // 문장을 공백을 기준으로 단어를 나누어(split(" ")) for 문으로 돌리고

            result = s.length() > tmp.length() ? tmp = s : tmp; // 삼항 연산자를 사용해 길이가 긴 단어를 결과에 저장
            result = s.length() == tmp.length() ? tmp : result; // 삼항 연산자를 사용해 길이가 같을 경우 결과에 저장하지 않는다.
        }
        return result;
    }

    public static void main(String[] args) {
        Problem_03_find_long p = new Problem_03_find_long();

        String s = "A AA AAA AAAA AAAA ";

        System.out.println(p.solution1(s));
        System.out.println(p.solution2(s));

    }
}
