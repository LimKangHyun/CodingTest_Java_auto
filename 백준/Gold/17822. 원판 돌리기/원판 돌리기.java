import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Integer>[] disks;
    private static int total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		disks = new ArrayList[N+1];
		for (int i = 0; i <= N; i++) {
		    disks[i] = new ArrayList<>();
		} 
		for (int i = 1; i <= N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < M; j++) {
		        disks[i].add(Integer.parseInt(st.nextToken()));
		    } 
		} 
		int x, d, k;
		for (int i = 0; i < T; i++) {
		    st = new StringTokenizer(br.readLine());
		    x = Integer.parseInt(st.nextToken());
		    d = Integer.parseInt(st.nextToken());
		    k = Integer.parseInt(st.nextToken());
		    rotation(x, d, k);
		    if (!removeAdjacent()) updateAverage();
		} 
		for (int i = 1; i <= N; i++) {
		    for (int j = 0; j < M; j++) {
		        total += disks[i].get(j);
		    } 
		} 
		bw.write(String.valueOf(total));
		bw.flush();
	}
	private static void rotation(int x, int d, int k) {
	    for (int i = x; i <= N; i += x) {
	        for (int j = 0; j < k; j++) {
	            if (d == 0) {
	                int last = disks[i].remove(M - 1);
	                disks[i].add(0, last);
	            } else {
	                int first = disks[i].remove(0);
	                disks[i].add(first);
	            }
	        } 
	    } 
	}
	private static boolean removeAdjacent() {
	    int[] dx = {1, 0};
        int[] dy = {0, 1};
	    boolean[][] remove = new boolean[N+1][M];
	    boolean hasRemoved = false;
	    for (int i = 1; i <= N; i++) {
	        for (int j = 0; j < M; j++) {
	            int currNum = disks[i].get(j);
	            if (currNum == 0) continue;
	            // 바깥 디스크에서 안쪽 디스크를 또 검사하는 경우를 제외하기 위해 오른쪽과 아래만 검사
	            for (int dir = 0; dir < 2; dir++) { 
	                int ni = i + dx[dir];
	                int nj = (j + dy[dir]) % M;
	                if (ni < 1 || ni > N) continue;
	                if (disks[ni].get(nj) == currNum) {
	                    remove[i][j] = true;
	                    remove[ni][nj] = true;
	                    hasRemoved = true;
	                }
	            } 
	        } 
	    } 
	    if (hasRemoved) {
	        for (int i = 1; i <= N; i++) {
	            for (int j = 0; j < M; j++) {
	                if (remove[i][j]) disks[i].set(j, 0); 
	            } 
	        } 
	    } 
	    return hasRemoved;
	}
	private static void updateAverage() {
	    int sum = 0;
	    int count = 0;
	    for (int i = 1; i <= N; i++) {
	        for (int j = 0; j < M; j++) {
	            int num = disks[i].get(j);
	            if (num != 0) {
	                sum += num;
	                count++;
	            } 
	        } 
	    } 
	    if (count == 0) return; 
	    double avg = (double) sum / count;
	    for (int i = 1; i <= N; i++) {
	        for (int j = 0; j < M; j++) {
	            int num = disks[i].get(j);
	            if (num != 0) {
	                if (num < avg) disks[i].set(j, num+1);
	                else if(num > avg) disks[i].set(j, num-1);
	            }
	        } 
	    } 
	}
}