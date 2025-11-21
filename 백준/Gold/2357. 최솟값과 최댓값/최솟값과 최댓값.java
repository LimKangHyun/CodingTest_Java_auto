import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		minTree = new int[4 * N];
		maxTree = new int[4 * N];
		for (int i = 0; i < N; i++) {
		    arr[i] = Integer.parseInt(br.readLine());
		}
		buildMinTree(1, 0, N - 1);
		buildMaxTree(1, 0, N - 1);
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int left = Integer.parseInt(st.nextToken()) - 1;
		    int right = Integer.parseInt(st.nextToken()) - 1;
		    sb.append(queryMin(1, 0, N - 1, left, right)).append(" ").append(queryMax(1, 0, N - 1, left, right)).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int buildMinTree(int node, int start, int end) {
	    if (start == end) return minTree[node] = arr[start];
	    int mid = (start + end) / 2;
	    return minTree[node] = Math.min(
	        buildMinTree(node * 2, start, mid),
	        buildMinTree(node * 2 + 1, mid + 1, end)
        );
	}
	private static int buildMaxTree(int node, int start, int end) {
	    if (start == end) return maxTree[node] = arr[start];
	    int mid = (start + end) / 2;
	    return maxTree[node] = Math.max(
	        buildMaxTree(node * 2, start, mid),
	        buildMaxTree(node * 2 + 1, mid + 1, end)
        );
	}
	private static int queryMin(int node, int start, int end, int left, int right) {
	    if (right < start || end < left) return Integer.MAX_VALUE;
	    if (left <= start && end <= right) return minTree[node];
	    int mid = (start + end) / 2;
	    return Math.min(
	        queryMin(node * 2, start, mid, left, right),
	        queryMin(node * 2 + 1, mid + 1, end, left, right)
        );
	}
	private static int queryMax(int node, int start, int end, int left, int right) {
	    if (right < start || end < left) return Integer.MIN_VALUE;
	    if (left <= start && end <= right) return maxTree[node];
	    int mid = (start + end) / 2;
	    return Math.max(
	        queryMax(node * 2, start, mid, left, right),
	        queryMax(node * 2 + 1, mid + 1, end, left, right)
	    );
	}
}