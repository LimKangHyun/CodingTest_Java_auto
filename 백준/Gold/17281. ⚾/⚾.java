import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] order = new int[9];
    private static int[][] players;
    private static boolean[] visited = new boolean[9];
    private static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		players = new int[N][9];
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < 9; j++) {
		        players[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		order[3] = 0;
		visited[0] = true;
		dfs(0);
		bw.write(String.valueOf(max));
		bw.flush();
	}
	private static void dfs(int depth) {
	    if (depth == 9) {
	        max = Math.max(max, simulate());
	        return;
	    }
	    if (depth == 3) {
	        dfs(depth + 1);
	        return;
	    }
	    for (int i = 1; i < 9; i++) {
	        if (visited[i]) continue;
	        visited[i] = true;
	        order[depth] = i;
	        dfs(depth + 1);
	        visited[i] = false;
	    }
	}
	private static int simulate() {
	    int score = 0;
	    int idx = 0;
	    for (int i = 0; i < N; i++) {
	        int outCount = 0;
	        boolean[] bases = new boolean[3];
	        while (outCount < 3) {
	            int result = players[i][order[idx]];
                switch (result) {
                    case 0:
                        outCount++;
                        break;
                    case 1:
                        if (bases[2]) {
                            score++;
                            bases[2] = false;
                        }
                        if (bases[1]) {
                            bases[2] = true;
                            bases[1] = false;
                        }
                        if (bases[0]) {
                            bases[1] = true;
                            bases[0] = false;
                        }
                        bases[0] = true;
                        break;
                    case 2:
                        if (bases[2]) {
                            score++;
                            bases[2] = false;
                        } 
                        if (bases[1]) {
                            score++;
                            bases[1] = false;
                        }
                        if (bases[0]) {
                            bases[2] = true;
                            bases[0] = false;
                        }
                        bases[1] = true;
                        break;
                    case 3:
                        for (int j = 0; j < 3; j++) {
                            if (bases[j]) {
                                score++;
                                bases[j] = false;    
                            }
                        }
                        bases[2] = true;
                        break;
                    case 4:
                        for (int b = 0; b < 3; b++) {
                            if (bases[b]) {
                                score++;
                                bases[b] = false;
                            }
                        }
                        score++;
                        break;
	                
	            }
	            idx = (idx + 1) % 9;
	        }
	    }
	    return score;
	}
}