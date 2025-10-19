import java.io.*;
import java.util.*;

public class Main {
    private static int N, K, S, X, Y;
    private static String[] input;
    private static int[][] arr;
    private static List<int[]>[] list;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		arr = new int[N][N];
		list = new ArrayList[K + 1];
		for (int i = 0; i <= K; i++) {
		    list[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
		    input = br.readLine().split(" ");
		    for (int j = 0; j < N; j++) {
		        int num = Integer.parseInt(input[j]);
		        arr[i][j] = num;
		        list[num].add(new int[] {i, j});
		    }
		}
		input = br.readLine().split(" ");
		S = Integer.parseInt(input[0]);
		X = Integer.parseInt(input[1]) - 1;
		Y = Integer.parseInt(input[2]) - 1;
		fillArr();
		bw.write(String.valueOf(arr[X][Y]));
		bw.flush();
	}
	private static void fillArr() {
	    while(S-- > 0) {
	        List<int[]>[] nextList = new ArrayList[K + 1];
	        for (int i = 0; i <= K; i++) {
	            nextList[i] = new ArrayList<>();
	        }
	        for (int i = 1; i <= K; i++) {
	            for (int[] pos : list[i]) {
	                int x = pos[0];
	                int y = pos[1];
	                for (int d = 0; d < 4; d++) {
	                    int nx = x + dx[d];
	                    int ny = y + dy[d];
	                    if (nx < 0 || ny < 0|| nx >= N || ny >= N) continue;
	                    if (arr[nx][ny] != 0) continue;
	                    arr[nx][ny] = i;
	                    nextList[i].add(new int[] {nx, ny});
	                }
	            }
	        }
	        list = nextList;
	    }
	}
}