import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int[] parent;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		IntStream.range(0, N).forEach(i -> parent[i] = i);
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    if (!isSameParent(s, e)) {
		        union(s, e);
		    } else {
		        answer = i + 1;
		        break;
		    }
		    answer = 0;
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	
	private static boolean isSameParent(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x == y) return true;
	    return false;
	}
	
	private static void union(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x != y) {
	        parent[y] = x;
	    }
	}
	
	private static int find(int x) {
	    if(x == parent[x]) return x;
	    return parent[x] = find(parent[x]);
	}
}