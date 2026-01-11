import java.io.*;
import java.util.*;

public class Main {
    static String[] arr;
    static String str;
    static int[] alphabet = new int[26];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];
		for (int i = 0; i < N; i++) {
		    arr[i] = br.readLine();
		    if (i == 0) str = arr[i];
		}
		for (int i = 0; i < str.length(); i++) {
		    alphabet[str.charAt(i) - 'A']++;
		}
		int similarCnt = 0;
		for (int i = 1; i < arr.length; i++) {
	        if (arr[i].length() < str.length() -1 || arr[i].length() > str.length() + 1) continue;
	        if (isSimilarWord(i)) {
	            similarCnt++;
	        }
	    }
		bw.write(String.valueOf(similarCnt));
		bw.flush();
	}
	private static boolean isSimilarWord(int n) {
	    int diff = 0;
        int[] temp = alphabet.clone();
        for (int i = 0; i < arr[n].length(); i++) {
            if (temp[arr[n].charAt(i) - 'A'] == 0) diff++;
            else temp[arr[n].charAt(i) - 'A']--;
        }
        for (int t : temp) {
            diff += t;
        }
        int lenDiff = Math.abs(str.length() - arr[n].length());
        if (lenDiff == 0) return diff <= 2;
        else if (lenDiff == 1) return diff <= 1;
        return false;
	}
}