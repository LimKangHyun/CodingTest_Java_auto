import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String L = st.nextToken();
		String R = st.nextToken();
		bw.write(String.valueOf(findMinEightCount(L, R)));
		bw.flush();
	}
	private static int findMinEightCount(String L, String R) {
	    if (L.length() != R.length()) {
	        return 0;
	    }
	    int numL = Integer.parseInt(L);
	    int numR = Integer.parseInt(R);
	    int count = 0;
	    for (int i = L.length() - 1; i >= 0; i--) {
	        int div = (int) Math.pow(10, i);
	        if (numL / div == numR / div) {
	            if (numL / div == 8) count++;
	            numL %= div;
                numR %= div;
	        } else break;
	    } 
	    return count;
	}
}