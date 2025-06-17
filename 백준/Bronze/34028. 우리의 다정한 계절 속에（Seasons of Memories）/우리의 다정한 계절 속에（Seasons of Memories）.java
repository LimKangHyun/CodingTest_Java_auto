import java.io.*;
import java.util.*;

public class Main {
    static class Date implements Comparable<Date> {
        int year, month, day;
        public Date(int year, int month, int day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }
        @Override
        public int compareTo(Date o) {
            if (this.year != o.year) return this.year - o.year;
            if (this.month != o.month) return this.month - o.month;
            return this.day - o.day;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        Date endDate = new Date(year, month, day);
        List<Date> seasons = new ArrayList<>();
        seasons.add(new Date(2015, 1, 16)); // 데뷔 겨울

        int startYear = 2015;
        int startMonth = 3;

        while (true) {
            Date cur = new Date(startYear, startMonth, 1);
            if (cur.compareTo(endDate) > 0) break;
            seasons.add(cur);

            startMonth += 3;
            if (startMonth > 12) {
                startMonth -= 12; // → 3, 6, 9, 12 유지
                startYear += 1;
            }
        }
        bw.write(String.valueOf(seasons.size()));
        bw.flush();
    }
}