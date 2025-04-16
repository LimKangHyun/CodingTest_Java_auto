import java.io.*;
import java.util.*;

public class Main {
    private static int[][] map;
    private static HashMap<Integer, Character> dirMap = new HashMap<>();
    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		int K = Integer.parseInt(br.readLine());
		for (int i = 0; i < K; i++) {
		    String[] input = br.readLine().split(" ");
		    int x = Integer.parseInt(input[0]) - 1;
		    int y = Integer.parseInt(input[1]) - 1;
		    map[x][y] = 1;
		} 
		int L = Integer.parseInt(br.readLine());
		for (int i = 0; i < L; i++) {
		    String[] input = br.readLine().split(" ");
		    int x = Integer.parseInt(input[0]);
		    char y = input[1].charAt(0);
		    dirMap.put(x, y);
		}
		bw.write(String.valueOf(whenDie(N)));
		bw.flush();
	}
	private static int whenDie(int N) {
	    int time = 0;
	    int direction = 0;
	    Deque<int[]> snake = new ArrayDeque<>();
	    snake.offer(new int[]{0, 0});
	    map[0][0] = 2;
	    
	    while(true) {
	        time++;
	        int[] head = snake.peekLast();
	        int nx = head[0] + dx[direction];
	        int ny = head[1] + dy[direction];
	        
	        if (nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 2) {
	            break;
	        }
	        if (map[nx][ny] == 0) {
	            // deque에 들어온 원소가 머리이므로, pollLast가 머리, pollFirst가 꼬리
	            int[] tail = snake.pollFirst();
	            map[tail[0]][tail[1]] = 0;
	        }
	        map[nx][ny] = 2;
	        snake.offer(new int[]{nx, ny});
	        
	        if (dirMap.containsKey(time)) {
	            char c = dirMap.get(time);
	            if (c == 'L') {
	                direction = (direction + 3) % 4;
	            } else {
	                direction = (direction + 1) % 4;
	            }
	        } 
	    }
	    return time;
	}
}