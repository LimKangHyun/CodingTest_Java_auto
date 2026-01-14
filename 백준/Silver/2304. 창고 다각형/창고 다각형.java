import java.io.*;
import java.util.*;

public class Main {
    static int maxH = 0;
    static int minL = Integer.MAX_VALUE;
    static int maxL = 0;
    static int maxHPos = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int H = Integer.parseInt(st.nextToken());
            map.put(L, H);
            if (maxH < H) {
                maxH = H;
                maxHPos = L;
            }
            minL = Math.min(minL, L);
            maxL = Math.max(maxL, L);
        }
		int[] col = new int[maxL + 1];
		int curH = map.get(minL);
		for (int i = minL; i < maxHPos; i++) {
		    if (map.get(i) == null) {
		        col[i] = curH;
		    } else {
		        if (curH < map.get(i)) {
		            curH = map.get(i);
		        }
		        col[i] = curH;
		    }
		}
		curH = map.get(maxL);
		for (int i = maxL; i >= maxHPos; i--) {
		    if (map.get(i) == null) {
		        col[i] = curH;
		    } else {
		        if (curH < map.get(i)) {
		            curH = map.get(i);
		        }
		        col[i] = curH;
		    }
		}
		int count = 0;
		for (int i = minL; i <= maxL; i++) {
		    count += col[i];
		}
		bw.write(String.valueOf(count));
		bw.flush();
	}
}