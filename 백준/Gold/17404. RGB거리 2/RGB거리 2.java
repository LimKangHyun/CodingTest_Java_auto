import java.io.*;
import java.util.*;
    
public class Main {
    // 첫집에 칠한 색을 R,G,B 세 가지로 나누어 3가지의 sum배열을 만든다.
    // ex) 첫집에 R을 칠해 만든 sum 배열의 마지막 집의 sum[N][1]과 sum[N][2]을 비교
    // 이렇게 세 가지 경우의 최소값이 나오면 세 값중 가장 작은 값이 최소 비용
    private static int N;
    private static int[][] arr;
    private static int[][] sum;
    private static int[] paint;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][3];
		sum = new int[N+1][3];
		paint = new int[3];
		
		for (int i = 1; i <= N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < 3; j++) {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		
		bw.write(String.valueOf(findMinCost()));
		bw.flush();
	}
	
	private static int findMinCost() {
	    for (int i = 0; i < 3; i++) {
	        for (int j = 0; j < 3; j++) {
	            if (i == j) {
	                sum[1][j] = arr[1][j];
	            } else {
	                sum[1][j] = 1001;
	            }
	        }
	        
	        for (int j = 2; j <= N; j++) {
	            sum[j][0] = arr[j][0] + Math.min(sum[j-1][1], sum[j-1][2]);
	            sum[j][1] = arr[j][1] + Math.min(sum[j-1][0], sum[j-1][2]);
	            sum[j][2] = arr[j][2] + Math.min(sum[j-1][0], sum[j-1][1]);
	            
	            if (j == N) {
	                if (i == 0) {
	                    paint[0] = Math.min(sum[N][1], sum[N][2]);
	                }
	                if (i == 1) {
	                    paint[1] = Math.min(sum[N][0], sum[N][2]);
	                }
	                if (i == 2) {
	                    paint[2] = Math.min(sum[N][0], sum[N][1]);
	                }
	            }
	        }
	    }
	    return Arrays.stream(paint).min().orElseThrow();
	}
}