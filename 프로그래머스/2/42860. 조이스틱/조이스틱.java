class Solution {
    public int solution(String name) {
        int answer = 0;
        // 시작점부터 오른쪽으로 갈때, 조이스틱 조작카운트
        int baseMove = name.length() - 1;
        int idx;
        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A'));
            
            idx = i + 1;
            while(idx < name.length() && name.charAt(idx) == 'A') {
                idx++;
            }
            // 오른쪽으로 돌다가 뒤돌아갈경우
            baseMove = Math.min(baseMove, i * 2 + name.length() - idx);
            // 왼쪽으로 돌다가 뒤돌아갈경우
            baseMove = Math.min(baseMove, (name.length() - idx) * 2 + i);
        }
        return answer + baseMove;
    }
}