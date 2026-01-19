import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		String input = br.readLine();
		for (int i = 0; i < input.length(); i++) {
		    char c = input.charAt(i);
		    if (Character.isUpperCase(c)) {
		        sb.append(Character.toLowerCase(c));
		    } else sb.append(Character.toUpperCase(c));
		}
		bw.write(sb.toString());
		bw.flush();
	}
}