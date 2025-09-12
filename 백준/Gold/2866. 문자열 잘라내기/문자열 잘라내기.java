import java.io.*;
import java.util.*;

public class Main {
    static int R, C;
    static char[][] arr;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		R = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
	    arr = new char[R][C];
		
		for (int i = 0; i < R; i++) {
		    String str = br.readLine();
		    for (int j = 0; j < C; j++) {
		        arr[i][j] = str.charAt(j);
		    } 
		} 
		int start = 0;
		int end = R - 1;
		while(start <= end) {
		    int mid = (start + end) / 2;
		    if (checkRedundancy(mid)) { // 겹치는게 없으면 아래줄로 이동
		        start = mid + 1;
		    } else { // mid 아래로 겹치므로, 안겹치게 위줄로 이동
		        end = mid - 1;
		    }
		}
		bw.write(String.valueOf(start));
		bw.flush();
	}
	private static boolean checkRedundancy(int mid) {
	    Set<String> set = new HashSet<>();
	    for (int i = 0; i < C; i++) {
	        sb.setLength(0);
	        for (int j = mid + 1; j < R; j++) {
	            sb.append(arr[j][i]);
	        } 
	        if (set.contains(sb.toString())) return false;
	        set.add(sb.toString());
	    } 
	    return true;
	}
}