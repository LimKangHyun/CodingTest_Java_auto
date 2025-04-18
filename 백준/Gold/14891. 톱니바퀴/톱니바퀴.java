import java.io.*;
import java.util.*;

public class Main {
    private static int[][] gear;
    private static int[][] attempt;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		gear = new int[4][8];
		for (int i = 0; i < 4; i++) {
		    String input = br.readLine();
		    for (int j = 0; j < 8; j++) {
		        gear[i][j] = input.charAt(j) - '0';
		    } 
		} 
		int k = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(k-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int gearNum = Integer.parseInt(st.nextToken()) - 1;
	        int dir = Integer.parseInt(st.nextToken());
	        gearing(gearNum, dir);
		}
		int answer = 0;
		for (int i = 0; i < 4; i++) {
		    if (gear[i][0] == 1) {
		        answer += Math.pow(2, i);
		    } 
		} 
		bw.write(String.valueOf(answer));
		bw.flush();
	}
	private static void gearing(int gearNum, int dir) {
	    int[] state = new int[4];
	    state[gearNum] = dir;
	    
	    for (int i = gearNum; i < 3; i++) {
	        if (gear[i][2] != gear[i+1][6]) {
                state[i+1] = -state[i];
            } else {
                break;
            }
	    } 
	    for (int i = gearNum; i > 0; i--) {
	        if (gear[i][6] != gear[i-1][2]) {
                state[i-1] = -state[i];
            } else {
                break;
            }
	    }
	    for (int i = 0; i < 4; i++) {
	        if (state[i] != 0) {
	            spin(i, state[i]);
	        } 
	    } 
	}
	private static void spin(int gearNum, int dir) {
	    int temp;
	    if (dir == 1) {
	        temp = gear[gearNum][7];
	        for (int i = 7; i > 0; i--) {
	            gear[gearNum][i] = gear[gearNum][i-1];
	        }
	        gear[gearNum][0] = temp;
	    } else {
	        temp = gear[gearNum][0];
	        for (int i = 0; i < 7; i++) {
	            gear[gearNum][i] = gear[gearNum][i+1];
	        }
	        gear[gearNum][7] = temp;
	    }
	}
}