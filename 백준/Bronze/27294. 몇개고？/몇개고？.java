import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int t = scanner.nextInt();
        int s = scanner.nextInt();
        
        if (s == 1) {
            System.out.println("280");
        } else if (t >= 12 && t <= 16) {
            System.out.println("320");
        } else System.out.println("280");
    }
}