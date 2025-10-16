import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] eggs;
    private static boolean[] isBroken;
    private static int max = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		if (N == 1) bw.write(String.valueOf(0));
		else {
		    eggs = new int[N][2];
		    for (int i = 0; i < N; i++) {
    		    String[] input = br.readLine().split(" ");
    		    eggs[i][0] = Integer.parseInt(input[0]);
    		    eggs[i][1] = Integer.parseInt(input[1]);
    		}
    		countMaxBrokenEggs(0, 0);
    		bw.write(String.valueOf(max));
		}
		bw.flush();
	}
	private static void countMaxBrokenEggs(int cur, int brokenEggsCnt) {
	    if (cur == N) {
	        max = Math.max(max, brokenEggsCnt);
	        return;
	    }
	    if (eggs[cur][0] <= 0) {
	        countMaxBrokenEggs(cur + 1, brokenEggsCnt);
	        return;
	    }
	    boolean canHit = false;
	    for (int i = 0; i < N; i++) {
	        if (i == cur || eggs[i][0] <= 0) continue;
	        canHit = true;
            eggs[i][0] -= eggs[cur][1];
            eggs[cur][0] -= eggs[i][1];
            int count = brokenEggsCnt;
            if (eggs[i][0] <= 0) count++;
            if (eggs[cur][0] <= 0) count++;
	        countMaxBrokenEggs(cur + 1, count);
	        eggs[i][0] += eggs[cur][1];
            eggs[cur][0] += eggs[i][1];
	    }
	    if (!canHit) {
	        max = Math.max(max, brokenEggsCnt);
	        return;
	    }
	}
}