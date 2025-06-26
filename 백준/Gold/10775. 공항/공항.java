import java.io.*;
import java.util.*;

public class Main {
    private static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		parent = new int[g + 1];
		for (int i = 1; i <= g; i++) {
		    parent[i] = i;
		} 
		int answer = 0;
		for (int i = 0; i < p; i++) {
		    int gate = Integer.parseInt(br.readLine());
		    // 가장 큰 번호의 게이트에 우선 도킹하려고 시도
		    // 이후 게이트번호를 1씩 줄여가면서 도킹 시도
		    // 도킹할 게이트가 0이 된다면, 도킹 불가능 즉, 탐색 종료
		    int dockingGate = find(gate);
		    
		    if (dockingGate == 0) break;
		    union(dockingGate, dockingGate - 1);
		    answer++;
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	private static int find(int x) {
	    if (x != parent[x]) return parent[x] = find(parent[x]);
	    return x;
	}
	private static void union(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x != y) parent[x] = y; 
	}
}