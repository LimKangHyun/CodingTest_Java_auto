import java.io.*;
import java.util.*;

public class Main {
    private static int N, max, min;
    private static int[] arithmetic;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		arithmetic = new int[4];// + - * / 순
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    num[i] = Integer.parseInt(st.nextToken());
		} 
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
		    arithmetic[i] = Integer.parseInt(st.nextToken());
		} 
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		int result = num[0];
		dfs(num, result, 1);
		bw.write(max + "\n" + min);
		bw.flush();
	}
	private static void dfs(int[] num, int result, int depth) {
	    if (depth == N) {
	        max = Math.max(max, result);
	        min = Math.min(min, result);
	        return;
	    } 
	    for (int i = 0; i < 4; i++) {
	        if (arithmetic[i] > 0) {
	            arithmetic[i]--;
	            switch(i) {
	                case 0: dfs(num, result + num[depth], depth + 1);
	                    break;
	                case 1: dfs(num, result - num[depth], depth + 1);
	                    break;
	                case 2: dfs(num, result * num[depth], depth + 1);
	                    break;
	                case 3: dfs(num, result / num[depth], depth + 1);
	                    break;
	            }
	            arithmetic[i]++; // 같은 depth의 다음 연산자 사용을 위해
	        }
	    } 
	}
}