import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] tang = new int[N];
		int[] count = new int[10];
		Set<Integer> set = new HashSet<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
		    tang[i] = Integer.parseInt(st.nextToken());;
		}
		int left = 0;
		int right = 0;
		int max = 0;
		while (right < N) {
		    count[tang[right]]++;
		    set.add(tang[right]);
		    while (set.size() > 2) {
		        count[tang[left]]--;
		        if (count[tang[left]] == 0) set.remove(tang[left]);
		        left++;
		    }
		    max = Math.max(max, right - left + 1);
		    right++;
		}
		System.out.println(max);
	}
}