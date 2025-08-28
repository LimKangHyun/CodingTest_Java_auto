import java.io.*;
import java.util.*;

public class Main {
    private static List<Integer> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		String input;
		while(true) {
		    st = new StringTokenizer(br.readLine());
		    int N = Integer.parseInt(st.nextToken());
		    if (N == 0) break;
		    list = new ArrayList<>();
		    for (int i = 0; i < N; i++) {
		        list.add(Integer.parseInt(st.nextToken()));
		    } 
		    Collections.sort(list);
		    if (list.get(0) == 0) {
		        int idx = 0;
		        while(list.get(idx) == 0) {
		            idx++;
		        } 
		        int start1 = list.remove(idx);
		        int start2 = list.remove(idx);
		        list.add(0, start2);
		        list.add(0, start1);
		    }  
		    int num1 = 0;
		    int num2 = 0;
		    int idx1 = list.size() / 2 - 1;
		    int idx2 = 0;
		    if (list.size() % 2 != 0) {
		        idx2 = list.size() / 2;
		    } else {
		        idx2 = idx1;
		    }
		    for (int i = 0; i < list.size(); i++) {
		        if (i % 2 == 0) {
		            num1 += list.get(i) * Math.pow(10, idx2--);
		        } else {
		            num2 += list.get(i) * Math.pow(10, idx1--);
		        }
		    } 
		    sb.append(num1 + num2 + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
	}
}