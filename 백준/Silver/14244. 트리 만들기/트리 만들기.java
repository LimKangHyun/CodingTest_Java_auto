import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String[] input = br.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		
		if (m == 2) {
		    for (int i = 0; i < n - 1; i++) {
		        sb.append(i + " " + (i + 1)).append("\n");
		    } 
		} else {
		    for (int i = 1; i <= m; i++) { // m개 가지 뻗기
    		    sb.append(0 + " " + i).append("\n");
    		} 
    		for (int i = m + 1; i < n; i++) { // 가지에 붙이기
    		    sb.append((i - 1) + " " + i).append("\n");
    		} 
		}
		bw.write(sb.toString());
		bw.flush();
	}
}