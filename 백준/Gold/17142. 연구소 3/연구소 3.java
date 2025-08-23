import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static List<int[]> virus;
    static List<int[]> selectedV;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int minDist = Integer.MAX_VALUE;
    static int zeroCount = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		virus = new ArrayList<>();
		selectedV = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        lab[i][j] = Integer.parseInt(st.nextToken());
		        if (lab[i][j] == 2) virus.add(new int[] {i, j});
                if (lab[i][j] == 0) zeroCount++;
		    } 
		} 
		combinationVirus(0, 0);
		bw.write(minDist != Integer.MAX_VALUE ? String.valueOf(minDist) : "-1");
		bw.flush();
	}
	private static void combinationVirus(int start, int depth) {
	    if (depth == M) {
	        int time = bfs();
	        if (time != -1) minDist = Math.min(minDist, time);
	        return;
	    }
	    int size = virus.size();
	    for (int i = start; i < size; i++) {
	        selectedV.add(virus.get(i));
	        combinationVirus(i+1, depth+1);
	        selectedV.remove(selectedV.size() - 1);
	    } 
	}
	private static int bfs() {
	    int lastTime = 0;
	    if (zeroCount == 0) return 0;
	    int empty = zeroCount;
	    boolean[][] visited = new boolean[N][N];
	    ArrayDeque<int[]> deque = new ArrayDeque<>();
	    for (int[] v : selectedV) {
	        deque.offer(new int[] {v[0], v[1], 0}); // 참조형이므로 하나씩 직접 꺼내주기
	        visited[v[0]][v[1]] = true;
	    } 
	    while(!deque.isEmpty()) {
	        int[] current = deque.poll();
	        int x = current[0];
	        int y = current[1];
	        int dist = current[2];
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (visited[nx][ny] || lab[nx][ny] == 1) continue; //이제 비활성 바이러스와 빈칸만 구분
                visited[nx][ny] = true;
                if (lab[nx][ny] == 0) {
                    empty--;
                    lastTime = dist + 1;
                    if (empty == 0) return lastTime;
                }
                deque.offer(new int[] {nx, ny, dist + 1});
	        } 
	    }
	    return -1;
	}
}