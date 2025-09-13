import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(st.nextToken());
        } 
        st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()) {
            set.remove(st.nextToken());
        }
        bw.write(set.iterator().next());
        bw.flush();
    }
}