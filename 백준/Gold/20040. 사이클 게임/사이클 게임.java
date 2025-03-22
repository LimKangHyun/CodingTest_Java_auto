import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int[] parent;
    static int[] rank;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parent = new int[N];
		rank = new int[N];
		IntStream.range(0, N).forEach(i -> {
		    parent[i] = i;
		    rank[i] = 0;
		});
		int answer = 0;
		
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    if (!unionByRank(s, e)) {
		        continue;
		    } else {
		        answer = i + 1;
		        break;
		    }
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	
	private static boolean unionByRank(int x, int y) {
	    x = find(x);
	    y = find(y);
	    if (x != y) {
	        if (rank[x] > rank[y]) {
	            parent[y] = x;
	        } else if(rank[y] > rank[x]) {
	            parent[x] = y;
	        } else {
	            parent[y] = x;
	            rank[x]++;
	        }
	        return false;
	    }
	    return true;
	}
	
	private static int find(int x) {
	    if(x == parent[x]) return x;
	    return parent[x] = find(parent[x]);
	}
}