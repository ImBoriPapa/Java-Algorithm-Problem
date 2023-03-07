package section01_string;


public class Pb_11_string_compression {

    public static String solution(String target) {
        String result = "";

        String temp = target + " ";

        int cnt = 1;

        for (int i = 0; i < temp.length() - 1; i++) {

            if (temp.charAt(i) == temp.charAt(i + 1)) {
                cnt++;
            } else {
                result += temp.charAt(i);

                if (cnt > 1) {
                    result += String.valueOf(cnt);
                }

                cnt = 1;
            }
        }

        return result;
    }
    
    public static void main(String[] args) {
        System.out.println(solution("KKHSSSSSSSE"));

    }
}
