import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] spell;
    static char[] temp;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		spell = new char[C];
		temp = new char[L];
		visited = new boolean[C];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
		    spell[i] = st.nextToken().charAt(0);
		}
		Arrays.sort(spell);
		comb(0, 0, 0, 0);
		bw.write(sb.toString());
		bw.flush();
	}
	private static void comb(int depth, int start, int vowelCount, int consonantCount) {
	    if (depth == L) {
	        if (vowelCount > 0 && consonantCount > 1) {
	            for (char c : temp) {
    	            sb.append(c);
    	        }
    	        sb.append("\n");
	        }
	        return;
	    }
	    for (int i = start; i < C; i++) {
	        if (!visited[i]) {
	            temp[depth] = spell[i];
	            visited[i] = true;
	            if (isVowel(spell[i])) {
    	            comb(depth + 1, i + 1, vowelCount + 1, consonantCount);
    	        } else comb(depth + 1, i + 1, vowelCount, consonantCount + 1);
    	        visited[i] = false;
	        }
	    }
	}
	private static boolean isVowel(char c) {
	    if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
	    return false;
	}
}