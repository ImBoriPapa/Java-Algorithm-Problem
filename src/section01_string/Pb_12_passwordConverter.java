package section01_string;


import java.util.Locale;

public class Pb_12_passwordConverter {

    /**
     * 1. 메시지는 대문자로 구성
     * 2. 암호는 한 글자당 # 또는 * 으로 7개로 구성(암호)
     * 3. 암호를 이진수로 변환 # = 이진수 1, * = 이진수 0
     * 4. 2진수를 10진수로 변경 -> 아스키 문자로 변경
     * <p>
     * 예시
     * 입력: #****###**#####**#####**##**
     * 결과: COOL
     */
    public static String convertToMessage(String password) {                                    //복호화

        if (password.length() % 7 != 0) {                                                       //유효성 검사: 문자열이 7개의 배수가 아니면 exception
            throw new IllegalArgumentException("암호는 한 글자당 7개로 이루어져야 합니다.");
        }

        int numberOfCharacters = password.length() / 7;                                        //암호를 7개 단위로 잘라서 메시지 단어의 숫자 확인

        StringBuilder result = new StringBuilder();


        for (int i = 0; i < numberOfCharacters; i++) {                                         //단어의 숫자 만큼 루프를 돌며 result 에 결과를 append
            int start = i * 7;                                                                 //문자열의 0번 인덱스 부터 다음 암호의 인덱스까지 7을 곱하여 인덱스 지정
            int end = start + 7;

            String binaryString = password.substring(start, end).replace("#", "1").replace("*", "0"); //replace()으로 '#'->"1","*"->"0" 변경 하여 이진수로 변경

            int asciiCode = Integer.parseInt(binaryString, 2);                                                                     //이진수가된 암호를 Integer.parseInt() 로 ascii 코드로 변경

            result.append((char) asciiCode);                                                                                             //ascii 코드를 char 로 타입 캐스팅해서 result 에 append
        }

        return result.toString();
    }

    public static String convertToPassword(String message) {                                                            //암호화

        char[] chars = message.toUpperCase(Locale.ROOT).toCharArray();                                                  //메시지를 대문자로 변경 후 char 배열로 글자 수를 나눔
        StringBuilder result = new StringBuilder();

        for (char character : chars) {                                                                                  //배열을 루프를 돌며 결과 생성
            String binaryString = Integer.toString(character, 2);                                                 //문자의 ascii 코드를 이진수로 변경

            result.append(binaryString.replace("1", "#").replace("0", "*"));         //결과에 이진수를 암호화하여 append

        }
        return result.toString();
    }

    public static void main(String[] args) {
        String test = "#****###**#####**#####**##**";
        String message = "COOL";
        System.out.println(convertToMessage(test));
        System.out.println(convertToPassword(message));
        System.out.println(convertToPassword(message).equals(test));
    }
}
