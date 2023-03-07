package section01_string;

import java.util.Arrays;

public class Pb_10_distance {

    public int[] solution(String str, char t) {

        int[] answer = new int[str.length()];
        int p = 1000;

        for (int i = 0; i < str.length(); i++) {
            Boolean c = str.charAt(i) == t ? setZero(answer,p,i) : setPlus(answer, p, i);
        }

        p = 1000;
        for (int i = str.length() - 1; i >= 0; i--) {
            Boolean c = str.charAt(i) == t ? setZero(answer,p,i) : setMin(answer, p, i);
        }

        return answer;
    }

    private boolean setZero(int[] answer,int p, int i) {
        p = 0;
        answer[i] = p;
        return true;
     }
    private boolean setPlus(int[] answer, int p, int i) {
        p++;
        answer[i] = p;
        return true;
    }
    private boolean setMin(int[] answer, int p, int i) {
        p++;
        answer[i] = Math.min(answer[i],p);
        return true;
    }


    public static void main(String[] args) {
        Pb_10_distance distance = new Pb_10_distance();

        int[] solution = distance.solution("teachermode", 'e');
        for (int i : solution) {
            System.out.print(i);
        }

    }
}
