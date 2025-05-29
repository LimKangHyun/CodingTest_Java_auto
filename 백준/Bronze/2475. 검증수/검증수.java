import java.io.*;
import java.util.*;

public class Main {
    private static int VALIDNUMBER = 10;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		while(st.hasMoreTokens()) {
		    sum += Math.pow(Integer.parseInt(st.nextToken()), 2);
		}
		bw.write(String.valueOf(sum % 10));
		bw.flush();
	}
}