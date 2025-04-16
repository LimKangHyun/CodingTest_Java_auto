class Solution {
    private static String vowel = "AEIOU";
    private static int cnt = 0;
    private static int answer = 0;
    
    public int solution(String word) {
        StringBuilder sb = new StringBuilder();
        dfs(word, sb);
        return answer;
    }
    private static void dfs(String word, StringBuilder sb) {
        if (word.contentEquals(sb)) {
            answer = cnt;
            return;
        }
        if (sb.length() == vowel.length()) {
            return;
        } 
        for (char c : vowel.toCharArray()) {
                sb.append(c);
                cnt++;
                dfs(word, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
    }
}