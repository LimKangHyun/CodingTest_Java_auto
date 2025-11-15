import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		long N = Integer.parseInt(br.readLine());
		int[] dice = new int[6];
		int oneNum = 51;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 6; i++) {
		    dice[i] = Integer.parseInt(st.nextToken());
		    oneNum = Math.min(oneNum, dice[i]);
		}
		long result = 0;
		if (N == 1) {
		    Arrays.sort(dice);
		    result = dice[0] + dice[1] + dice[2] + dice[3] + dice[4];
		} else {
		    int twoNum = 101;
		    for (int i = 0; i < 6; i++) {
		        for (int j = i + 1; j < 6; j++) {
		            if (i + j != 5) twoNum = Math.min(twoNum, (dice[i] + dice[j]));
		        }
		    }
		    int threeNum = Math.min(dice[0], dice[5]) + Math.min(dice[1], dice[4]) + Math.min(dice[2], dice[3]);
    		long two = 4 * (N - 1) + 4 * (N - 2);
    		long three = 4;
    		long one = 5 * N * N - (two * 2 + three * 3);
    		result = one * oneNum + two * twoNum + three * threeNum;
		}
		bw.write(String.valueOf(result));
		bw.flush();
	}
}