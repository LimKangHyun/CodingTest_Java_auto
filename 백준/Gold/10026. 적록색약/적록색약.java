import java.io.*;

public class Main {
    private static int N;
    private static char[][] map;
    private static char[][] rgMap;
    private static boolean[][] visit;
    private static boolean[][] rgVisit;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int area;
    private static int rgArea;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		rgMap = new char[N][N];
		visit = new boolean[N][N];
		rgVisit = new boolean[N][N];
		for (int i = 0; i < N; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < N; j++) {
		        map[i][j] = input.charAt(j);
		        if (map[i][j] == 'G') {
		            rgMap[i][j] = 'R';
		        } else {
		            rgMap[i][j] = map[i][j];
		        }
		    } 
		} 
		for (int i = 0; i < N; i++) {
		    for (int j = 0; j < N; j++) {
		        if (!visit[i][j]) {
		            if (counting(map, visit, i, j)) {
		                area++;
		            }
		        } 
		        if (!rgVisit[i][j]) {
		            if (counting(rgMap, rgVisit, i, j)) {
		                rgArea++;
		            }
		        } 
		    } 
		} 
		bw.write(area + " " + rgArea);
		bw.flush();
	}
	private static boolean counting(char[][] arr, boolean[][] visit, int x, int y) {
	    int count = 0;
	    count++;
	    for (int i = 0; i < 4; i++) {
	        int nx = x + dx[i];
	        int ny = y + dy[i];
	        if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
	            if (!visit[nx][ny] && arr[nx][ny] == arr[x][y]) {
	                visit[nx][ny] = true;
	                counting(arr, visit, nx, ny);
	            } 
	        }
	    } 
	    if (count > 0) {
	        return true;
	    } 
	    return false;
	}
}