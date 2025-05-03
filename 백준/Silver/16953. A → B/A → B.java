import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder A = new StringBuilder(st.nextToken());
		StringBuilder B = new StringBuilder(st.nextToken());
		
		int count = 1;
		boolean possible = false;
		while(B.length() >= A.length()) {
		    if (Integer.parseInt(B.toString()) == Integer.parseInt(A.toString())) {
		        possible = true;
		        break;
		    } 
		    if (B.charAt(B.length() - 1) == '1') {
		        B.deleteCharAt(B.length() - 1);
		    } else if (Integer.parseInt(B.toString()) % 2 == 0){
		        int num = Integer.parseInt(B.toString()) / 2;
		        B = new StringBuilder(Integer.toString(num));
		    } else {
		        break;
		    }
		    count++;
		}
		bw.write(possible ? String.valueOf(count) : "-1");
		bw.flush();
	}
}