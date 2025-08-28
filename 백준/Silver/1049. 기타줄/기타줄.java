import java.io.*;
import java.util.*;

public class Main {
    private static int minSinglePrice = Integer.MAX_VALUE;
    private static int minPackPrice = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    minPackPrice = Math.min(minPackPrice, Integer.parseInt(st.nextToken()));
		    minSinglePrice = Math.min(minSinglePrice, Integer.parseInt(st.nextToken()));
		} 
		bw.write(String.valueOf(findMinPrice(N)));
		bw.flush();
	}
	private static int findMinPrice(int N) {
	    if (6 * minSinglePrice < minPackPrice) {
	        return minSinglePrice * N;
	    } else { // single * 6보다 패키지 하나가 더 싸다면
	        // 전체 package로 구매 vs 나머지는 single로 구매
	        int allPackPrice = N % 6 == 0 ? (N / 6) * minPackPrice : (N / 6 + 1) * minPackPrice;
	        int splitPrice = (N / 6) * minPackPrice + (N % 6) * minSinglePrice;
	        return Math.min(allPackPrice, splitPrice);
	    }
	}
}