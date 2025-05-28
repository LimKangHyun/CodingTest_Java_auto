import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
		if (isASC(input)) {
		    bw.write("ascending");
		} else if (isDESC(input)) {
		    bw.write("descending");
		} else {
		    bw.write("mixed");
		}
		bw.flush();
	}
	private static boolean isASC(int[] input) {
	    for (int i = 0; i < input.length - 1; i++) {
	        if (input[i] != input[i+1] - 1) return false;
	    }
	    return true;
	}
	private static boolean isDESC(int[] input) {
	    for (int i = 0; i < input.length - 1; i++) {
	        if (input[i] != input[i+1] + 1) return false;
	    }
	    return true;
	}
}