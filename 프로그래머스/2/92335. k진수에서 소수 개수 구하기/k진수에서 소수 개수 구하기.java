import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String str;
        if (k != 10) str = changeNum(n, k);
        else str = String.valueOf(n);
        String[] numbers = str.split("0");
        for (String number : numbers) {
            if (number.isEmpty()) continue;
            long num = Long.parseLong(number);
            if (num <= 1) continue;
            if (isPrime(num)) answer++;
        }
        return answer;
    }
    private static String changeNum(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n >= k) {
            int quot = n / k;
            int remain = n % k;
            sb.insert(0, remain);
            n = quot;
        }
        sb.insert(0, n);
        return sb.toString();
    }
    private static boolean isPrime(long num) {
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}