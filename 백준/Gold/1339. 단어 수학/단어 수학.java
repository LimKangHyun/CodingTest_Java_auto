import java.io.*;
import java.util.*;

public class Main {
    private static int[] alpha = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = new String[N];
		for (int i = 0; i < N; i++) {
		    String s = br.readLine();
		    for (int j = 0; j < s.length(); j++) {
		        int spellNum = s.charAt(j) - 'A';
		        alpha[spellNum] += (int) Math.pow(10, (s.length() - j - 1));
		    } 
		}
		Arrays.sort(alpha);
		int num = 9;
		int answer = 0;
		for (int i = 25; i >= 0; i--) {
		    if (alpha[i] != 0) {
		        answer += alpha[i] * num--;
		    } 
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}