import java.io.*;
import java.util.*;

public class Main {
    private static int N, K, S, X, Y;
    private static String[] input;
    private static int[][] arr;
    private static List<int[]> viruses = new ArrayList<>();
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
		    input = br.readLine().split(" ");
		    for (int j = 0; j < N; j++) {
		        arr[i][j] = Integer.parseInt(input[j]);
		        if (arr[i][j] != 0) viruses.add(new int[] {i, j, arr[i][j]});
		    }
		}
		viruses.sort((a, b) -> a[2] - b[2]);
		input = br.readLine().split(" ");
		S = Integer.parseInt(input[0]);
		X = Integer.parseInt(input[1]) - 1;
		Y = Integer.parseInt(input[2]) - 1;
		fillArr();
		bw.write(String.valueOf(arr[X][Y]));
		bw.flush();
	}
	private static void fillArr() {
	    Queue<int[]> queue = new ArrayDeque<>(viruses);
	    while(!queue.isEmpty() && S-- > 0) {
	        int size = queue.size();
	        for (int i = 0; i < size; i++) {
	            int[] cur = queue.poll();
                for (int d = 0; d < 4; d++) {
                    int nx = cur[0] + dx[d];
                    int ny = cur[1] + dy[d];
                    if (nx < 0 || ny < 0|| nx >= N || ny >= N) continue;
                    if (arr[nx][ny] != 0) continue;
                    arr[nx][ny] = cur[2];
                    queue.offer(new int[] {nx, ny, cur[2]});
                }
	        }
	    }
	}
}