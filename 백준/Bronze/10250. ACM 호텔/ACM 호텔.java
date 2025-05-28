import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		while(t-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int h = Integer.parseInt(st.nextToken());
		    int w = Integer.parseInt(st.nextToken());
		    int n = Integer.parseInt(st.nextToken());
		    int floor = n % h;
		    int room = n / h + 1;
		    if (floor == 0) {
		        floor = h;
		        room--;
		    } 
		    sb.append(String.format("%d%02d\n", floor, room));
		}
		
		bw.write(sb.toString());
		bw.flush();
	}
}