import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static int[][] sumArr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		sumArr = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 1; j <= n; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		makeSumArr(map);
		for (int i = 0; i < m; i++) {
		    st = new StringTokenizer(br.readLine());
		    int x1 = Integer.parseInt(st.nextToken());
		    int y1 = Integer.parseInt(st.nextToken());
		    int x2 = Integer.parseInt(st.nextToken());
		    int y2 = Integer.parseInt(st.nextToken());
		    sb.append(getSum(x1, y1, x2, y2) + "\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
	private static void makeSumArr(int[][] map) {
	    for (int i = 1; i <= map.length - 1; i++) {
	        for (int j = 1; j <= map.length - 1; j++) {
	            // sum[i-1][j-1]이 두 번 겹치므로 한 번 빼주기
	            sumArr[i][j] = map[i][j] + sumArr[i-1][j] + sumArr[i][j-1] - sumArr[i-1][j-1];
	        } 
	    }
	}
	private static int getSum(int x1, int y1, int x2, int y2) {
	    // sumArr[x1-1][y1-1]를 두 번 빼게 되므로 한 번 더해주기
	    return sumArr[x2][y2] - sumArr[x2][y1-1] - sumArr[x1-1][y2] + sumArr[x1-1][y1-1];
	}
}