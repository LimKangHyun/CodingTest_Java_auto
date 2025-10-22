import java.io.*;
import java.util.*;

public class Main {
    private static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
		    str = br.readLine();
		    if (str.charAt(0) == '#') break;
		    int count = 0;
		    for (int i = 2; i < str.length(); i++) {
		        if (str.charAt(0) == str.charAt(i) || str.charAt(0) == str.charAt(i) + 32) count++;
		    }
		    sb.append(str.charAt(0)).append(" ").append(count).append("\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}