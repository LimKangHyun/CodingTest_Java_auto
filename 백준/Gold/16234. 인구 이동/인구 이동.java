import java.io.*;
import java.util.*;

public class Main {
    private static int N, L, R;
    private static int[][] population;
    private static boolean[][] visit;
    private static int[] dx = {1, -1, 0 , 0};
    private static int[] dy = {0, 0, -1 , 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		L = Integer.parseInt(input[1]);
		R = Integer.parseInt(input[2]);
		population = new int[N][N];
		
		for (int i = 0; i < N; i++) {
		    String[] inputPop = br.readLine().split(" ");
		    for (int j = 0; j < N; j++) {
		        population[i][j] = Integer.parseInt(inputPop[j]);
		    } 
		}
		int day = 0;
		while(true) {
		    visit = new boolean[N][N];
		    boolean moved = false;
		    
		    for (int i = 0; i < N; i++) {
		        for (int j = 0; j < N; j++) {
		            if (!visit[i][j]) {
		                if (bfs(i, j)) moved = true; 
		            } 
		        } 
		    } 
		    if (!moved) break;
		    day++;
		}
		bw.write(String.valueOf(day));
		bw.flush();
	}
	private static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> union = new ArrayList<>();
        queue.offer(new int[] {x, y});
        union.add(new int[] {x, y});
        visit[x][y] = true;
        int sum = population[x][y];
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                int diff = Math.abs(population[cur[0]][cur[1]] - population[nx][ny]);
                if (!visit[nx][ny] && diff >= L && diff <= R) {
                    visit[nx][ny] = true;
                    sum += population[nx][ny];
                    queue.offer(new int[] {nx, ny});
                    union.add(new int[] {nx, ny});
                } 
            } 
        }
        if (union.size() <= 1) {
            return false;
        } 
        int avg = sum / union.size();
        for (int[] pop : union) {
            population[pop[0]][pop[1]] = avg;
        } 
        return true;
	}
}