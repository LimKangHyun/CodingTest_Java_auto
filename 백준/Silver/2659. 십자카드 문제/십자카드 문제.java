import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < 4; i++) {
		    sb.append(st.nextToken());
		}
		int clockNum = findClockNum(sb.toString());
		int count = 0;
		for (int i = 1111; i <= clockNum; i++) {
		    if(zeroCheck(i)) continue;
		    if (findClockNum(String.valueOf(i)) == i) count++;
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
	private static boolean zeroCheck(int num) {
	    while (num > 0) {
	        if (num % 10 == 0) return true;
	        num /= 10;
	    }
	    return false;
	}
	private static int findClockNum(String s) {
	    int min = Integer.MAX_VALUE;
	    String temp = s;
	    
	    for (int i = 0; i < 4; i++) {
	        int result = Integer.parseInt(temp);
	        min = Math.min(min, result);
	        temp = temp.substring(1) + temp.charAt(0);
	    }
	    return min;
	}
}