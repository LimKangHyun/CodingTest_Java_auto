import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(gcd(a, b) + "\n" + lcm(a, b));
		bw.flush();
	}
	private static int gcd(int a, int b) {
	    while(b != 0) {
	        int temp = a % b;
	        a = b;
	        b = temp;
	    }
	    return a;
	}
	private static int lcm(int a, int b) {
	    return a * b / gcd(a, b);
	}
}