import java.io.*;
import java.util.*;

public class Main {
    private static int[] arr;
    private static List<Integer>[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		int length = (int) Math.pow(2, K) - 1;
		arr = new int[length];
		tree = new ArrayList[K];
		for (int i = 0; i < K; i++) {
		    tree[i] = new ArrayList<>();
		} 
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < length; i++) {
		    arr[i] = Integer.parseInt(st.nextToken());
		} 
		buildTree(0, length - 1, 0);
		for (int i = 0; i < K; i++) {
		    for (int num : tree[i]) {
		        sb.append(num).append(" ");
		    } 
		    sb.append("\n");
		} 
		bw.write(sb.toString());
		bw.flush();
	}
	private static void buildTree(int start, int end, int depth) {
	    if (start > end) return;
	    int mid = (start + end) / 2;
	    tree[depth].add(arr[mid]);
	    buildTree(start, mid - 1, depth + 1);
	    buildTree(mid + 1, end, depth + 1);
	}
}