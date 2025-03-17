import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> list = new ArrayList<>();
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
	    int R = Integer.parseInt(st.nextToken());
	    int Q = Integer.parseInt(st.nextToken());
	    StringBuilder sb = new StringBuilder();
	    int[] qArray = new int[Q];
	    boolean[] visit = new boolean[N+1];
	    int[] children = new int[N+1];
	    
	    for (int i = 0; i <= N; i++) {
	        list.add(new ArrayList<>());
	    } 
	    for (int i = 0; i < N - 1; i++) {
	        st = new StringTokenizer(br.readLine());
	        int start = Integer.parseInt(st.nextToken());
	        int end = Integer.parseInt(st.nextToken());
	        list.get(start).add(end);
	        list.get(end).add(start);
	    } 
	    for (int i = 0; i < Q; i++) {
	        qArray[i] = Integer.parseInt(br.readLine());
	    } 
	    dfs(R, visit, children);
        for (int i = 0; i < qArray.length; i++) {
            sb.append(children[qArray[i]]).append("\n");
        } 
		bw.write(sb.toString());
		bw.flush();
	}
	
	private static void dfs(int r, boolean[] visit, int[] children) {
	    visit[r] = true;
	    children[r]++;
	    for (int i = 0; i < list.get(r).size(); i++) {
	        int current = list.get(r).get(i);
	        if (!visit[current]) {
	            dfs(current, visit, children);
	            children[r] += children[current];
	        }
	    } 
	}
}