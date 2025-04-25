import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int max = -1;
		int row = 0, col = 0;
		for (int i = 0; i < 9; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for (int j = 0; j < 9; j++) {
		        int n = Integer.parseInt(st.nextToken());
		        if (n > max) {
		            max = n;
		            row = i + 1;
		            col = j + 1;
		        }
		    } 
		} 
		bw.write(max + "\n" + row + " " + col);
		bw.flush();
	}
}