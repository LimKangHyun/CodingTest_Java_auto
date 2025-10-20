import java.util.*;
import java.io.*;

public class Main {
    private static int N;
    private static String[] input;
    private static int[][] room;
    private static Map<Integer, Set<Integer>> prefer = new HashMap<>();
    private static int[] order;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int total = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		room = new int[N][N];
		order = new int[N * N];
		for (int i = 0; i < N * N; i++) {
		    input = br.readLine().split(" ");
		    Set<Integer> set = new HashSet<>();
		    for (int j = 1; j < 5; j++) {
		        set.add(Integer.parseInt(input[j]));
		    }
		    order[i] = Integer.parseInt(input[0]);
		    prefer.put(Integer.parseInt(input[0]), set);
		}
		for (int stud : order) {
		    fillRoom(stud);
		}
		for (int i = 0; i < N ; i++) {
		    for (int j = 0; j < N; j++) {
		        int count = 0;
		        for (int d = 0; d < 4; d++) {
		            int nx = i + dx[d];
		            int ny = j + dy[d];
		            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
		            if (prefer.get(room[i][j]).contains(room[nx][ny])) count++;
		        }
		        if (count == 0) continue;
		        total += Math.pow(10, count - 1);
		    }
		}
		bw.write(String.valueOf(total));
		bw.flush();
	}
	private static void fillRoom(int stud) {
	    int[] max = new int[4];
	    Arrays.fill(max, -1);
	    for (int i = 0; i < N ; i++) {
	        for (int j = 0; j < N; j++) {
	            int count = 0;
	            int blank = 0;
	            if (room[i][j] != 0) continue;
	            for (int d = 0; d < 4; d++) {
	                int nx = i + dx[d];
	                int ny = j + dy[d];
	                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	                if (checkStud(stud, nx, ny) == 1) count++;
	                if (room[nx][ny] == 0) blank++;
	            }
	            if (max[0] < count || 
	            (max[0] == count && max[1] < blank) || 
	            (max[0] == count && max[1] == blank && max[2] > i) || 
	            (max[0] == count && max[1] == blank && max[2] == i && max[3] > j)) {
	                max[0] = count;
	                max[1] = blank;
	                max[2] = i;
	                max[3] = j;
	            }
	        }
	    }
	    room[max[2]][max[3]] = stud;
	}
	private static int checkStud(int stud, int nx, int ny) {
	    if (room[nx][ny] == 0) return 0;
	    return prefer.get(stud).contains(room[nx][ny]) ? 1 : 0;
	}
}