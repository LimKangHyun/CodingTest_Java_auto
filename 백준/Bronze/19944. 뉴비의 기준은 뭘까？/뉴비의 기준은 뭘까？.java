import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 올드비는 N학년 이하이자 뉴비가 아닌 학생
		int M = sc.nextInt(); // 학년
		sc.close();

		if (M == 1 || M == 2) {
			System.out.println("NEWBIE!");
		} else if (M <= N) {
			System.out.println("OLDBIE!");
		} else {
			System.out.println("TLE!");
		}
	}

}