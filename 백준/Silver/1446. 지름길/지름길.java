import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;
    
    Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Node n) {
        return weight - n.weight;
    }
}
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int[] dist = new int[D + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[0] = 0;
		List<Node> shortcut = new ArrayList<>();
		for (int i = 0; i < N; i++) {
		    st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    if (e - s <= w || e > D) continue;
		    shortcut.add(new Node(s, e, w));
		}
		Collections.sort(shortcut, (a, b) -> a.start - b.start);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(0, 0, 0));
		while(!pq.isEmpty()) {
		    Node cur = pq.poll();
		    if (dist[cur.end] < cur.weight) continue;
		    for (Node next : shortcut) {
		        if (next.start < cur.end) continue;
		        int interval = next.start - cur.end;
		        if (dist[next.end] > cur.weight + next.weight + interval) {
		            dist[next.end] = cur.weight + next.weight + interval;
		            pq.offer(new Node(cur.end, next.end, dist[next.end]));
		        }
		    }
		    if (cur.end < D) {
		        int diff = D - cur.end;
		        if (dist[D] > cur.weight + diff) {
		            dist[D] = cur.weight + diff;
		            pq.offer(new Node(cur.end, D, dist[D]));
		        }
		    }
		}
		bw.write(String.valueOf(dist[D]));
		bw.flush();
	}
}