import java.io.*;
import java.util.*;

public class Main {
    static String input1;
    static String input2;
    static int[][] dp;
    static boolean[] visit;
    static List<Character> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input1 = br.readLine();
		input2 = br.readLine();
		dp = new int[input1.length()+1][input2.length()+1];
		visit = new boolean[input1.length()+1];
		
		lcs2();
		int i = input1.length();
		int j = input2.length();
		while (i > 0 && j > 0) {
		    if (input1.charAt(i-1) == input2.charAt(j-1)) {
		        sb.append(input1.charAt(i-1));
		        i--;
		        j--;
		    } else if (dp[i-1][j] > dp[i][j-1]) {
		        i--;
		    } else {
		        j--;
		    }
		}
		bw.write(String.valueOf(dp[input1.length()][input2.length()]));
		bw.newLine();
		bw.write(sb.reverse().toString());
		bw.flush();
	}
	
	private static void lcs2() {
	    for (int i = 1; i <= input1.length(); i++) {
	        for (int j = 1; j <= input2.length(); j++) {
	            if (input1.charAt(i-1) == input2.charAt(j-1)) {
	                dp[i][j] = dp[i-1][j-1] + 1;
	            } else {
	                dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	            }
	        } 
	    } 
	}
}