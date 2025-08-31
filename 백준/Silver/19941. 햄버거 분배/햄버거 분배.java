import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		String input = br.readLine();
		char[] arr = new char[N];
		for (int i = 0; i < N; i++) {
		    arr[i] = input.charAt(i);
		} 
		int count = 0;
		boolean[] visit = new boolean[N];
		for (int i = 0; i < N; i++) {
		    if (arr[i] == 'P') {
		        for (int j = i - K; j <= i + K; j++) {
		            if (j >= 0 && j < N) {
		                if (visit[j]) continue;
		                if (arr[j] == 'H') {
		                    visit[j] = true;
    	                    count++;
    	                    break;
		                } 
		            } 
		        }
		    } 
		} 
		bw.write(String.valueOf(count));
		bw.flush();
	}
}