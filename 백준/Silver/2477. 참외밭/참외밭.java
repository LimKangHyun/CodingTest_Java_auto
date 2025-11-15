import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int K = Integer.parseInt(br.readLine());
		int[] dir = new int[6];
		int[] dis = new int[6];
		int[] dirCount = new int[5];

		for (int i = 0; i < 6; i++)  {
		    st = new StringTokenizer(br.readLine());
		    dir[i] = Integer.parseInt(st.nextToken());
		    dis[i] = Integer.parseInt(st.nextToken());
		    dirCount[dir[i]]++;
		}
		int entire = 1;
		int substraction = 1;
		for (int i = 0; i < 6; i++) {
		    if (dirCount[dir[i]] == 1) entire *= dis[i];
		    if (i == 0) {
		        if (dirCount[dir[5]] != 2 || dirCount[dir[i + 1]] != 2) continue;
		        substraction *= dis[i];
		    } else if (i == 5) {
		        if (dirCount[dir[i - 1]] != 2 || dirCount[dir[0]] != 2) continue;
		        substraction *= dis[i];
		    } else {
		        if (dirCount[dir[i - 1]] != 2 || dirCount[dir[i + 1]] != 2) continue;
		        substraction *= dis[i];
		    }
		}
		bw.write(String.valueOf((entire - substraction) * K));
		bw.flush();
	}
}