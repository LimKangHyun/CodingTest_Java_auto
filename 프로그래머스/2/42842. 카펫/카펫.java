class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
//        int widthHeightSum = (brown / 2) + 2;
//        int yellowWHSum = widthHeightSum - 4;
        int yellowWHSum = (brown / 2) - 2;

        for(int i = 1; i <= Math.sqrt(yellow); i++) {
            if((i * (yellowWHSum - i)) == yellow) {
                answer[0] = yellowWHSum - i + 2;
                answer[1] = i + 2;
            }
        }
        return answer;
    }
}