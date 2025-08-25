import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
		    st = new StringTokenizer(br.readLine());
		    int H = Integer.parseInt(st.nextToken());
		    int W = Integer.parseInt(st.nextToken());
		    int N = Integer.parseInt(st.nextToken());
		    
		    int floor = N % H * 100;
		    int roomNumber = N / H + 1;
		    if (floor == 0) {
		        floor = H * 100;
		        roomNumber--;
		    }
		    sb.append(floor + roomNumber + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}