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
		        if (lab[i][j] == 2) virus.add(new int[] {i, j, 0}); 
		    } 
		} 
		combinationVirus(0, 0);
		bw.write(minDist != Integer.MAX_VALUE ? String.valueOf(minDist) : "-1");
		bw.flush();
	}
	private static void combinationVirus(int start, int depth) {
	    if (depth == M) {
	        int[][] labCopy = new int[N][N];
	        for (int i = 0; i < N; i++) {
	            labCopy[i] = lab[i].clone();
	        } 
	        int dist = bfs(labCopy);
	        minDist = Math.min(minDist, dist);
	    }
	    int size = virus.size();
	    for (int i = start; i < size; i++) {
	        selectedV.add(virus.get(i));
	        combinationVirus(i+1, depth+1);
	        selectedV.remove(selectedV.size() - 1);
	    } 
	}
	private static int bfs(int[][] labCopy) {
	    int maxCount = 0;
	    boolean[][] visited = new boolean[N][N];
	    Queue<int[]> queue = new LinkedList<>();
	    for (int[] v : selectedV) {
	        queue.offer(new int[] {v[0], v[1], v[2]}); // 참조형이므로 하나씩 직접 꺼내주기
	        visited[v[0]][v[1]] = true;
	    } 
	    while(!queue.isEmpty()) {
	        int[] current = queue.poll();
	        int x = current[0];
	        int y = current[1];
	        int dist = current[2];
	        for (int i = 0; i < 4; i++) {
	            int nx = x + dx[i];
	            int ny = y + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (!visited[nx][ny] && labCopy[nx][ny] != 1) { //이제 비활성 바이러스와 빈칸만 구분
	                visited[nx][ny] = true;
	                queue.offer(new int[] {nx, ny, dist + 1});
	                if (labCopy[nx][ny] == 0) {
	                    labCopy[nx][ny] = dist + 1;
	                    maxCount = Math.max(maxCount, dist + 1);
	                }
	            }
	        } 
	    }
	    boolean isFilled = true;
	    for (int i = 0; i < N; i++) {
	        for (int j = 0; j < N; j++) {
	            if (labCopy[i][j] == 0) {
	                isFilled = false;
	                break;
	            }
	        } 
	    } 
	    return isFilled ? maxCount : Integer.MAX_VALUE;
	}
}