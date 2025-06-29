import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		
		if((x + y) % 2 != 0 || x < y) {
			bw.write(String.valueOf(-1));
		}else {
		    bw.write(((x + y) / 2) + " " + (((x + y) / 2) - y));
		}
		bw.flush();
	}
}