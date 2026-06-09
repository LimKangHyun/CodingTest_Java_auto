class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int aGcd = getGcd(arrayA);
        int bGcd = getGcd(arrayB);
        
        boolean aValid = true;
        for (int b : arrayB) {
            if (b % aGcd == 0) {
                aValid = false;
                break;
            }
        }
        
        boolean bValid = true;
        for (int a : arrayA) {
            if (a % bGcd == 0) {
                bValid = false;
                break;
            }
        }
        
        if (aValid) answer = Math.max(answer, aGcd);
        if (bValid) answer = Math.max(answer, bGcd);
        return answer;
    }
    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
    private int getGcd(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }
}