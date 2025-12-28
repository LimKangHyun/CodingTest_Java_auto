import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    arr[i][0] = Integer.parseInt(st.nextToken());
		    arr[i][1] = Integer.parseInt(st.nextToken());
		}
		bw.write(String.valueOf(calcTotalDist() - findMaxSaved()));
		bw.flush();
	}
	private static int findMaxSaved() {
	    int max = 0;
	    for (int i = 1; i < N - 1; i++) {
	        // A to B + B to C - A to C 하면 아낀 거리 
	        max = Math.max(max, calcDist(i - 1, i) + calcDist(i, i + 1) - calcDist(i - 1, i + 1));
	    }
	    return max;
	}
	private static int calcTotalDist() {
	    int totalDist = 0;
	    for (int i = 0; i < N - 1; i++) {
	        totalDist += calcDist(i, i + 1);
	    }
	    return totalDist;
	}
	private static int calcDist(int a, int b) {
	    return Math.abs(arr[a][0] - arr[b][0]) + Math.abs(arr[a][1] - arr[b][1]);
	}
}