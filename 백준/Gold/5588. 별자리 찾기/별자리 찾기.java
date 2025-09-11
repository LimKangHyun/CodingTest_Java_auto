import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int m = Integer.parseInt(br.readLine());
        int[][] arr = new int[m][2];
        int[][] diff = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i][0] = x;
            arr[i][1] = y;
            if (i > 0) {
                diff[i][0] = arr[i][0] - arr[0][0];
                diff[i][1] = arr[i][1] - arr[0][1];
            } 
        } 
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(x + "," + y);
        } 
        for (String coordinate : set) {
            String[] star = coordinate.split(",");
            int x = Integer.parseInt(star[0]);
            int y = Integer.parseInt(star[1]);
            
            boolean found = true;
            for (int i = 1; i < m; i++) {
                int targetX = x + diff[i][0];
                int targetY = y + diff[i][1];
                if (!set.contains(targetX + "," + targetY)) {
                    found = false;
                    break;
                }
            } 
            if (found) { // found가 true인 경우, 해당 star가 arr[0][0]과 arr[0][1]과 대응되므로
                bw.write((x - arr[0][0]) + " " + (y - arr[0][1]));
                break;
            } 
        } 
        bw.flush();
    }
}