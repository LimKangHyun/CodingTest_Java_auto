import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static List<Integer> pos, neg;
    private static boolean posMax;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		pos = new ArrayList<>();
		neg = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    int num = Integer.parseInt(st.nextToken());
		    if (num > 0) {
		        pos.add(num);
		    } else {
		        neg.add(Math.abs(num));
		    }
		} 
		pos.sort(Comparator.reverseOrder());
		neg.sort(Comparator.reverseOrder());
		int answer = findMin();
		int maxDist = 0;
		if (!pos.isEmpty() && (neg.isEmpty() || pos.get(0) >= neg.get(0))) {
            maxDist = pos.get(0);
        } else if (!neg.isEmpty()) {
            maxDist = neg.get(0);
        }
        bw.write(String.valueOf(answer - maxDist));
		bw.flush();
	}
	private static int findMin() {
	    int result = 0;
	    int size = M;
	    for (int i = 0; i < pos.size(); i+=size) {
	        int end = Math.min(i+size, pos.size());
	        List<Integer> pTemp = pos.subList(i, end);
	        int max = Collections.max(pTemp);
	        result += max * 2;
	    } 
	    for (int i = 0; i < neg.size(); i+=size) {
	        int end = Math.min(i+size, neg.size());
	        List<Integer> nTemp = neg.subList(i, end);
	        int max = Collections.max(nTemp);
            result += max * 2;
	    } 
	    return result;
	}
}