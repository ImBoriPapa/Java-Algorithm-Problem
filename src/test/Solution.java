package test;

public class Solution {

    private static final String[] KEYS = {"aya", "ye", "woo", "ma"};

    public int solution(String[] babblings) {
        int validCount = 0;

        for (String babbling : babblings) {
            if (containsOnlyKeys(babbling)) {
                validCount++;
            }
        }

        return validCount;
    }

    private boolean containsOnlyKeys(String babbling) {
        for (String key : KEYS) {
            babbling = babbling.replace(key, "");
        }
        return babbling.isEmpty();
    }

    public static void main(String[] args) {
        String[] babblings1 = {"aya", "ye", "u", "maa", "wyeoo"};
        String[] babblings2 = {"ayaye", "uuuma", "ye", "yemawoo", "ayaa"};

        Solution solution = new Solution();

        System.out.println(solution.solution(babblings1));
        System.out.println(solution.solution(babblings2));
    }
}
