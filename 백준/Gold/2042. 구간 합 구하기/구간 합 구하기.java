import java.io.*;
import java.util.*;

public class Main {
    private static long[] arr;
    private static long[] tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); 
		int M = Integer.parseInt(st.nextToken()); // 변경
		int K = Integer.parseInt(st.nextToken()); // 구간 합
		
	    arr = new long[N];
	    tree = new long[getTreeSize(N)]; // 세그먼트 트리
		for (int i = 0; i < N; i++) {
		    arr[i] = Long.parseLong(br.readLine());
		} 
		initTree(1, 0, N - 1);
		int T = M + K;
		while(T-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int a = Integer.parseInt(st.nextToken());
		    int b = Integer.parseInt(st.nextToken());
		    long c = Long.parseLong(st.nextToken());
		    
		    if (a == 1) {
		        update(1, 0, N - 1, b - 1, c);
		    } else if (a == 2) {
		        sb.append(query(1, 0, N - 1, b - 1, c - 1) + "\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
	private static int getTreeSize(int N) {
	    int H = (int) Math.ceil(Math.log(N) / Math.log(2));
	    return (int) Math.pow(2, H + 1);
	}
	private static long initTree(int node, int start, int end) {
	    if (start == end) return tree[node] = arr[start];
	    int mid = (start + end) / 2;
	    long leftSum = initTree(node * 2, start, mid);
	    long rightSum = initTree(node * 2 + 1, mid + 1, end);
	    return tree[node] = leftSum + rightSum;
	}
	private static void update(int node, int start, int end, int idx, long num) {
	    if (idx < start || idx > end) return;
	    if (start == end){ // 원본 배열 변경 및 리프 노드 변경
	        arr[idx] = num;
	        tree[node] = num;
	        return;
	    } 
	    int mid = (start + end) / 2;
	    update(node * 2, start, mid, idx, num);
	    update(node * 2 + 1, mid + 1, end, idx, num);
	    tree[node] = tree[node * 2] + tree[node * 2 + 1];
	}
	private static long query(int node, int start, int end, int left, long right) {
	    if (right < start || end < left) return 0;
	    if (left <= start && end <= right) {
	        return tree[node];
	    } 
	    int mid = (start + end) / 2;
	    long leftSum = query(node * 2, start, mid, left, right);
	    long rightSum = query(node * 2 + 1, mid + 1, end, left, right);
	    return leftSum + rightSum;
	}
}