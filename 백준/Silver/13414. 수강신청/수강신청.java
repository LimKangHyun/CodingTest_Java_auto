import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        String[] arr = new String[L];
        
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            map.put(br.readLine(), i);
        }
        for (String s : map.keySet()) {
            arr[map.get(s)] = s;
        }
        int idx = 0;
        while(K > 0 && idx < L) {
            if (arr[idx] != null) { // map의 크기가 K보다 작은 경우가 존재하므로
                sb.append(arr[idx] + "\n");
                K--;
            } 
            idx++;
        }
        bw.write(sb.toString());
        bw.flush();
    }
}