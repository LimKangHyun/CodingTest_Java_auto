import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] seq = new int[K];
		Set<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			seq[i] = Integer.parseInt(st.nextToken());
		}
		int answer = 0;

		for (int i = 0; i < K; i++) {
			int current = seq[i];
			if (set.contains(current)) continue;
			if (set.size() < N) {
				set.add(current);
			} else {
				int lastUseIndex = -1;
				int removal = -1;
				for (int plugged : set) {
					int nextUse = Integer.MAX_VALUE;

					for (int j = i + 1; j < K; j++) {
						if (seq[j] == plugged) {
							nextUse = j;
							break;
						}
					}
					if (nextUse > lastUseIndex) {
						lastUseIndex = nextUse;
						removal = plugged;
					}
				}
				set.remove(removal);
				set.add(current);
				answer++;
			}
		}
		bw.write(String.valueOf(answer));
		bw.flush();
	}
}