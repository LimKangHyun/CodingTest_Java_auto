import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] nutrit;
    static int[][] land;
    static Deque<Integer>[][] trees;
    static Deque<Integer> newTrees = new ArrayDeque<>();
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nutrit = new int[N+1][N+1];
		land = new int[N+1][N+1];
		trees = new ArrayDeque[N+1][N+1];
		
		for (int i = 1; i <= N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 1; j <= N; j++) {
		        nutrit[i][j] = Integer.parseInt(st.nextToken());
		        land[i][j] = 5;
		        trees[i][j] = new ArrayDeque<>();
		    } 
		} 
		for (int i = 0; i < M; i++) {
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    int z = Integer.parseInt(st.nextToken());
		    trees[x][y].add(z);
		} 
		while(K-- > 0) {
		    springAndSummer();
		    fall();
		    winter();
		}
		int treeCount = 0;
		for (int i = 1; i <= N; i++) {
		    for (int j = 1; j <= N; j++) {
		        treeCount += trees[i][j].size();
		    } 
		} 
		bw.write(String.valueOf(treeCount));
		bw.flush();
	}
	private static void springAndSummer() {
	    for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= N; j++) {
	            if(trees[i][j].isEmpty()) continue;
	            
	            newTrees.clear(); // newTrees 객체 재사용
	            int dead = 0;
	            while(!trees[i][j].isEmpty()) {
	                int age = trees[i][j].pollFirst();
	                if (land[i][j] >= age) {
	                    land[i][j] -= age;
	                    newTrees.addLast(age+1);
	                } else {
	                    dead += age / 2;
	                }
	            }
	            trees[i][j].clear();
	            trees[i][j].addAll(newTrees); // 기존 덱을 유지하고 내용물만 바꾸기
	            land[i][j] += dead;
	        } 
	    } 
	}
	private static void fall() {
	    for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= N; j++) {
	            for (int age : trees[i][j]) {
	                if (age % 5 == 0) {
	                    for (int d = 0; d < 8; d++) {
	                        int ni = i + dx[d];
	                        int nj = j + dy[d];
	                        if (ni < 1 || ni > N || nj < 1 || nj > N) continue; 
	                        trees[ni][nj].addFirst(1);
	                    } 
	                } 
	            } 
	        } 
	    } 
	}
	private static void winter() {
	    for (int i = 1; i <= N; i++) {
	        for (int j = 1; j <= N; j++) {
	            land[i][j] += nutrit[i][j];
	        } 
	    } 
	}
 }