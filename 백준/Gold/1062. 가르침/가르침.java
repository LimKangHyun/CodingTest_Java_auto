import java.io.*;

public class Main {
    static int N, K;
    static int max = 0;
    static String[] words;
    static boolean[] learned = new boolean[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		if (K < 5) {
		    bw.write(String.valueOf(0));
		} else if (K == 26) {
		    bw.write(String.valueOf(N));
		} else {
		    words = new String[N];
		    learned['a' - 'a'] = true;
		    learned['n' - 'a'] = true;
		    learned['t' - 'a'] = true;
		    learned['i' - 'a'] = true;
		    learned['c' - 'a'] = true;
		    for (int i = 0; i < N; i++) {
		        String s = br.readLine();
		        s = s.replace("anta", "").replace("tica", "");
		        words[i] = s;
		    }
		    dfs(0, 0);
		    bw.write(String.valueOf(max));
		}
		bw.flush();
	}
	private static void dfs(int idx, int count) {
	    if (count == K - 5) {
	        max = Math.max(max, canReadable());
	        return;
	    }
	    for (int i = idx; i < 26; i++) {
	        if (learned[i]) continue;
	        learned[i] = true;
	        dfs(i + 1, count + 1);
	        learned[i] = false;
	    }
	}
	private static int canReadable() {
	    int count = 0;
	    for (String word : words) {
	        boolean canRead = true;
	        for (int i = 0; i < word.length(); i++) {
	            if (learned[word.charAt(i) - 'a']) continue;
	            canRead = false;
	            break;
	        }
	        if (canRead) count++;
	    }
	    return count;
	}
}