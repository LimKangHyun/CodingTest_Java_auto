import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static char[][] lobby;
    private static List<int[]> space = new ArrayList<>();
    private static List<int[]> teachers = new ArrayList<>();
    private static final int objCnt = 3;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static boolean found = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		lobby = new char[N][N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        lobby[i][j] = st.nextToken().charAt(0);
		        if (lobby[i][j] == 'X') space.add(new int[] {i, j});
		        if (lobby[i][j] == 'T') teachers.add(new int[] {i, j});
		    }
		}
		comb(0, 0);
		bw.write(found ? "YES" : "NO");
		bw.flush();
	}
	private static void comb(int depth, int start) {
	    if (found) return;
	    if (depth == objCnt) {
	        if (checkStudent()) found = true;
	        return;
	    }
	    for (int i = start; i < space.size(); i++) {
	        int x = space.get(i)[0];
	        int y = space.get(i)[1];
	        lobby[x][y] = 'O';
	        comb(depth + 1, i + 1);
	        if (found) return;
	        lobby[x][y] = 'X';
	    }
	}
	private static boolean checkStudent() {
	    for (int[] teacher : teachers) {
	        for (int d = 0; d < 4; d++) {
	            int nx = teacher[0];
	            int ny = teacher[1];
	            while(true) {
	                nx += dx[d];
	                ny += dy[d];
	                if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
	                if (lobby[nx][ny] == 'O') break;
	                if (lobby[nx][ny] == 'S') return false;
	            }
	        }
	    }
	    return true;
	}
}