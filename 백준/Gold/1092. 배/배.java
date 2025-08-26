import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> limits;
    private static List<Integer> boxWeights;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		limits = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    limits.add(Integer.parseInt(st.nextToken()));
		} 
		Collections.sort(limits, Collections.reverseOrder());
		int M = Integer.parseInt(br.readLine());
		boxWeights = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
		    boxWeights.add(Integer.parseInt(st.nextToken()));
		} 
		Collections.sort(boxWeights, Collections.reverseOrder());
		limits.removeIf(x -> x < boxWeights.get(M - 1));
		
		bw.write(String.valueOf(findMinTime()));
		bw.flush();
	}
	private static int findMinTime() {
        if (limits.isEmpty()) return -1;
	    if (boxWeights.get(0) > limits.get(0)) return -1;
	    int time = 0;
	    int craneSize = limits.size();
		while(!boxWeights.isEmpty()) {
		    int boxIdx = 0;
		    int craneIdx = 0;
		    while(craneIdx < craneSize) {
		        if (boxIdx == boxWeights.size()) break; 
		        if (limits.get(craneIdx) >= boxWeights.get(boxIdx)) {
		            boxWeights.remove(boxIdx);
		            craneIdx++; // 해당 craneIdx는 박스를 실음
		        } else boxIdx++; // 실을 수 없다면 다음 boxIdx로
		    }
		    time++;
		}
	    return time;
	}
}