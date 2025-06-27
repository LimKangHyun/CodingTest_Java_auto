import java.util.*;

class Solution {
    static class Job implements Comparable<Job> {
        int start;
        int dur;
        int idx;

        public Job(int start, int dur, int idx) {
            this.start = start;
            this.dur = dur;
            this.idx = idx;
        }
        @Override
        public int compareTo(Job j) {
            // 작업시간이 적은 순으로 정렬
            int diff = Integer.compare(this.dur, j.dur);
            if (diff != 0) return diff;
            
            diff = Integer.compare(this.start, j.start);
            if (diff != 0) return diff;

            return Integer.compare(this.idx, j.idx);
        }
    }
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
        
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int totalWait = 0;
        int currentTime = 0;
        int index = 0;
        int count = jobs.length;
        
        while(count > 0) {
            // 현재 시간까지 도착한 작업들을 대기큐에 넣음
            while (index < jobs.length && jobs[index][0] <= currentTime) {
                pq.offer(new Job(jobs[index][0], jobs[index][1], index));
                index++;
            }
            // 들어온 작업이 없다면, 다음 작업의 도착시간으로 현재시간을 이동
            if (pq.isEmpty()) {
                currentTime = jobs[index][0];
            } else {
                // 우선순위 큐에서 가장 우선순위가 높은 작업을 꺼내서 실행
                Job job = pq.poll();
                // 현재시간은 기존시간 + 작업의 소요시간
                currentTime += job.dur;
                // 해당 작업의 총 대기시간은 작업을 마친 현재시간 - 작업의 도착시간
                totalWait += currentTime - job.start;
                count--;
            }
        }
        return totalWait / jobs.length;
    }
}