import java.io.*;
import java.util.*;

public class Main {
    private static PriorityQueue<Integer> pq = new PriorityQueue<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[][] lecture = new int[N][2];
		
		for (int i = 0; i < N; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    lecture[i][0] = Integer.parseInt(st.nextToken());
		    lecture[i][1] = Integer.parseInt(st.nextToken());
		} 
// 		Arrays.sort(lecture, (a, b) -> a[0] - b[0]);
		Arrays.sort(lecture, Comparator.comparingInt(a -> a[0]));
		bw.write(String.valueOf(minClass(lecture)));
		bw.flush();
	}
	private static int minClass(int[][] lecture) {
	    int count = 0;
	    pq.offer(lecture[0][1]);
	    for (int i = 1; i < lecture.length; i++) {
            if (lecture[i][0] >= pq.peek()) {
                pq.poll();
            }
            pq.offer(lecture[i][1]);
        } 
        return pq.size();
	}
}