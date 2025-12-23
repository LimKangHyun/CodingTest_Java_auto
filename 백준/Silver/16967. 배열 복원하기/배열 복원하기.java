import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int[][] arr = new int[H + X][W + Y];
		int[][] answer = new int[H][W];
		for (int i = 0; i < H + X; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < W + Y; j++) {
		        arr[i][j] = Integer.parseInt(st.nextToken());
		        if (i < H && j < W) answer[i][j] = arr[i][j];
		    }
		}
		for (int i = X; i < H; i++) {
		    for (int j = Y; j < W; j++) {
		        answer[i][j] -= answer[i - X][j - Y];
		    }
		}
		for (int i = 0; i < H; i++) {
		    for (int j = 0; j < W; j++) {
		        sb.append(answer[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}