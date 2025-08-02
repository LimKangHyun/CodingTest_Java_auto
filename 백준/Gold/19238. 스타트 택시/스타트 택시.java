import java.io.*;
import java.util.*;

public class Main {
    static class position implements Comparable<position> {
        int x, y, value; // 목적지 좌표, 현재 택시와의 거리
        public position(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
        public int compareTo(position o) {
            if(this.value == o.value) {
                if (this.x == o.x) {
                    return this.y - o.y;
                } else {
                    return this.x - o.x;
                }
            }
            return this.value - o.value;
        }
    }
    static ArrayList<position> humans = new ArrayList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int curX, curY, curC; // 현재 위치, 현재 고객
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int G = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < N; j++) {
		        map[i][j] = Integer.parseInt(st.nextToken());
		    } 
		} 
		st = new StringTokenizer(br.readLine());
		curX = Integer.parseInt(st.nextToken()) - 1;
		curY = Integer.parseInt(st.nextToken()) - 1;
		
		for (int i = 2; i < 2 + M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int sx = Integer.parseInt(st.nextToken()) - 1;
		    int sy = Integer.parseInt(st.nextToken()) - 1;
		    int ex = Integer.parseInt(st.nextToken()) - 1;
		    int ey = Integer.parseInt(st.nextToken()) - 1;
		    map[sx][sy] = i;
		    humans.add(new position(ex, ey, 0)); // i번 손님의 목적지 저장
		} 
		int count = 0;
		while(count < M) {
		    int temp1 = searchCustomer(N, map);
		    if (G - temp1 <= 0 || temp1 == -1) break; // 연료 - 고객까지의 거리 || 태울 손님이 없는 경우
		    int temp2 = searchGoal(N, map);
		    if (G - (temp1 + temp2) < 0 || temp2 == -1) break;
		    else G += temp2 - temp1;
		    count++;
		}
		if (count == M) bw.write(String.valueOf(G));
		else bw.write("-1");
		bw.flush();
	}
	private static int searchCustomer(int N, int[][] map) {
	    PriorityQueue<position> pq = new PriorityQueue<>();
	    boolean[][] visit = new boolean[N][N];
	    pq.offer(new position(curX, curY, 0));
	    visit[curX][curY] = true;
	    while(!pq.isEmpty()) {
	        position cur = pq.poll();
	        if (map[cur.x][cur.y] > 1) {
	            curC = map[cur.x][cur.y]; // humans에서 저장한 고객의 도착지를 찾기위해 필요
	            curX = cur.x;
	            curY = cur.y;
	            map[curX][curY] = 0;
	            return cur.value;
	        } 
	        for (int i = 0; i < 4; i++) {
	            int nx = cur.x + dx[i];
	            int ny = cur.y + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if(!visit[nx][ny] && map[nx][ny] != 1) {
	                visit[nx][ny] = true;
	                pq.add(new position(nx, ny, cur.value+1));
	            }
	            
	        } 
	    }
	    return -1;
	}
	private static int searchGoal(int N, int[][] map) {
	    PriorityQueue<position> pq = new PriorityQueue<>();
	    boolean[][] visit = new boolean[N][N];
	    pq.offer(new position(curX, curY, 0));
	    visit[curX][curY] = true;
	    
	    int gx = humans.get(curC - 2).x;
	    int gy = humans.get(curC - 2).y;
	    while(!pq.isEmpty()) {
	        position cur = pq.poll();
	        if (cur.x == gx && cur.y == gy) {
	            curX = gx;
	            curY = gy;
	            return cur.value;
	        }
	        for (int i = 0; i < 4; i++) {
	            int nx = cur.x + dx[i];
	            int ny = cur.y + dy[i];
	            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
	            if (!visit[nx][ny] && map[nx][ny] != 1) {
	                visit[nx][ny] = true;
	                pq.add(new position(nx, ny, cur.value+1));
	            } 
	        } 
	    }
	    return -1;
	}
}