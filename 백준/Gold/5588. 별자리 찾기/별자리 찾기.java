import java.io.*;
import java.util.*;

public class Main {
    static class Star {
        int x;
        int y;
        
        Star(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Star other = (Star) obj;
            return this.x == other.x && this.y == other.y;
        }
        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        
        int m = Integer.parseInt(br.readLine());
        Star[] arr = new Star[m];
        int[][] diff = new int[m][2];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr[i] = new Star(x, y);
            if (i > 0) {
                diff[i][0] = arr[i].x - arr[0].x;
                diff[i][1] = arr[i].y - arr[0].y;
            } 
        } 
        int n = Integer.parseInt(br.readLine());
        Set<Star> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            set.add(new Star(x, y));
        } 
        for (Star coordinate : set) {
            boolean found = true;
            for (int i = 1; i < m; i++) {
                Star target = new Star(coordinate.x + diff[i][0], coordinate.y + diff[i][1]);
                if (!set.contains(target)) {
                    found = false;
                    break;
                }
            } 
            if (found) { // found가 true인 경우, 해당 star가 arr[0][0]과 arr[0][1]과 대응되므로
                bw.write((coordinate.x - arr[0].x) + " " + (coordinate.y - arr[0].y));
                break;
            } 
        } 
        bw.flush();
    }
}