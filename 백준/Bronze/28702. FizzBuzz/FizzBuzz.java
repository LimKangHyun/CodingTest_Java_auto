import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		
		int answer = 0;
		if (isNumber(a)) answer = Integer.parseInt(a) + 3;
		else if (isNumber(b)) answer = Integer.parseInt(b) + 2;
		else answer = Integer.parseInt(c) + 1;
		bw.write(String.valueOf(getFizzBuzz(answer)));
		bw.flush();
	}
	private static boolean isNumber(String str) {
 	    if (str.equals("Fizz") || str.equals("Buzz") || str.equals("FizzBuzz")) return false; 
	    return true;
	}
	private static String getFizzBuzz(int n) {
	    if (n % 15 == 0) return "FizzBuzz";
	    if (n % 3 == 0) return "Fizz";
	    if (n % 5 == 0) return "Buzz";
	    return String.valueOf(n);
	}
}