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
	    // 8, 80, 800, 8000 대 인 경우 최소 1개씩은 있으니까 자리수를 확인해서 8이 들어가는지 확인해서
	    for (int i = L.length() - 1; i >= 0; i--) {
	        int div = (int) Math.pow(10, i);
	        if (numL / div == numR / div) {
	            if (numL / div == 8) {
	                numL %= div;
                    numR %= div;
                    count++;
	            } else {
	                numL %= div;
                    numR %= div;
	            }
	        } else break;
	    } 
	    return count;
	}
}