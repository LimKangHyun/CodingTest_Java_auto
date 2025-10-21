import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		int N = Integer.parseInt(input[0]); // 접시 개수
		int d = Integer.parseInt(input[1]); // 가짓 수
		int k = Integer.parseInt(input[2]); // 연속으로 먹을 접시
		int c = Integer.parseInt(input[3]); // 쿠폰 번호
		
		int[] dish = new int[N];
		int[] sushi = new int[d + 1];
		for (int i = 0; i < N; i++) {
		    dish[i] = Integer.parseInt(br.readLine());
		}
		int sort = 0;
		for (int i = 0; i < k; i++) {
	        if (sushi[dish[i]] == 0) sort++;
	        sushi[dish[i]]++;
	    }
	    int max = sort;
	    if (sushi[c] == 0) max++;
		for (int i = 1; i < N; i++) {
		    sushi[dish[i - 1]]--;
		    if (sushi[dish[i - 1]] == 0) sort--;
		    int num = (i + k - 1) % N;
		    if (sushi[dish[num]] == 0) sort++;
		    sushi[dish[num]]++;
		    int result = sort;
		    if (sushi[c] == 0) result++;
		    max = Math.max(max, sort + (sushi[c] == 0 ? 1 : 0));
		}
		bw.write(String.valueOf(max));
		bw.flush();
	}
}