import java.util.*;
class Solution {
    public int solution(int[] picks, String[] minerals) {
        
        List<int[]> groups = new ArrayList<>();
        int totalPicks = picks[0] + picks[1] + picks[2];
        
        for (int i = 0; i < minerals.length; i += 5) {
            int diamond = 0, iron = 0, stone = 0;
            for (int j = i; j < i + 5 && j < minerals.length; j++) {
                if (minerals[j].equals("diamond")) diamond++;
                else if (minerals[j].equals("iron")) iron++;
                else stone++;
            }
            int score = diamond * 25 + iron * 5 + stone;
            groups.add(new int[]{score, diamond, iron, stone});
        }
        // 정렬 전 Math.min(곡괭이 개수, 그룹 개수)만큼 자르기
        List<int[]> trimmed = groups.subList(0, Math.min(totalPicks, groups.size()));
        trimmed.sort((a, b) -> b[0] - a[0]);
        
        int fatigue = 0;
        for (int i = 0; i < trimmed.size(); i++) {
            int[] group = trimmed.get(i);
            if (picks[0] > 0) {
                fatigue += group[1] + group[2] + group[3];
                picks[0]--;
            } else if (picks[1] > 0) {
                fatigue += group[1] * 5 + group[2] + group[3];
                picks[1]--;
            } else if (picks[2] > 0) {
                fatigue += group[1] * 25 + group[2] * 5 + group[3];
                picks[2]--;
            }
        }
        return fatigue;
    }
}