import java.io.*;
import java.util.*;

public class Main {
    static class Interval {
        int home;
        int office;
        
        Interval(int a, int b) {
            this.home = Math.min(a, b);
            this.office = Math.max(a, b);
        }
    }
    private static int maxNum = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(br.readLine());
		List<Interval> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
		    String[] input = br.readLine().split(" ");
		    int home = Integer.parseInt(input[0]);
		    int office = Integer.parseInt(input[1]);
		    list.add(new Interval(home, office));
		} 
		int d = Integer.parseInt(br.readLine());
		// office가 가까운 순으로 정렬 office의 위치가 같다면 home이 가까운 순 정렬
		list.sort((a, b) -> {
		    if (a.office != b.office) return a.office - b.office;
		    return a.home - b.home;
		});
		int max = 0;
		// home가 작은 원소부터
		PriorityQueue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt(i -> i.home));
		for (Interval cur : list) {
		    int rangeStart = cur.office - d;
		    // pq에 들어있는 구간들 중 현재 구간의 범위 시작점보다 home이 작은 구간들은 범위 밖이므로 제거
		    while(!pq.isEmpty() && pq.peek().home < rangeStart) {
		        pq.poll();
		    }
		    // d의 길이가 현재 home과 office의 거리를 커버한다면 pq에 추가
		    if (cur.home >= rangeStart) {
		        pq.offer(cur);
		    }
		    max = Math.max(max, pq.size());
		} 
		bw.write(String.valueOf(max));
		bw.flush();
	}
}