class Solution {
    int[][] signals;
    public int solution(int[][] _signals) {
        signals = _signals;
        int n = signals.length;
        int[] cycle = new int[n];
        int MAX_TIME = calcTime(n, cycle);
        for (int t = 1; t <= MAX_TIME; t++) {
            boolean allYellow = true;
            for (int i = 0; i < n; i++) {
                int mod = t % cycle[i];
                int green = signals[i][0];
                int yellow = signals[i][1];
                if (mod <= green || mod > green + yellow) {
                    allYellow = false;
                    break;
                }
            }
            if (allYellow) return t;
        }
        return -1;
    }
    private int calcTime(int n, int[] cycle) {
        int result =  1;
        for (int i = 0; i < n; i++) {
            cycle[i] = signals[i][0] + signals[i][1] + signals[i][2];
            result = lcm(result, cycle[i]);
        }
        return result;
    }
    private int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}