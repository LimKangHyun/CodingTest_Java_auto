import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), M = sc.nextInt(), A = sc.nextInt(), B = sc.nextInt();
        
        int lack = Math.max(0, 3 * N - M);
        System.out.println(lack == 0 ? 0 : lack * A + B);
    }
}