import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
		    String input = br.readLine();
		    if (input.equals("-1")) break;
		    int n = Integer.parseInt(input);
		    List<Integer> list = new ArrayList<>();
		    int result = 0;
		    for (int i = 1; i * i <= n; i++) {
		        if (n % i == 0) {
		            list.add(i);
		            result += i;
		            if (i != n / i) {
		                if (n/i != n) {
		                    list.add(n/i);
    		                result += (n/i);   
		                }
    		        }
		        }
		    } 
		    if (result != n) {
		        sb.append(n + " is NOT perfect. \n");
		    } else {
		        sb.append(n + " = ");
		        Collections.sort(list);
		        for (int i = 0; i < list.size() - 1; i++) {
		            sb.append(list.get(i) + " + ");
		        } 
		        sb.append(list.get(list.size() - 1) + "\n");
		    }
		}
		bw.write(sb.toString());
		bw.flush();
	}
}