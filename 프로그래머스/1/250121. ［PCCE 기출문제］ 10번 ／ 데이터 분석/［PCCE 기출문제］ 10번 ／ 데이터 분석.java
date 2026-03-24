import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<int[]> list = new ArrayList<>();
        int n = checkNum(ext);
        for (int i = 0; i < data.length; i++) {
            if (data[i][n] < val_ext) {
                list.add(data[i]);
            }
        }
        int sortN = checkNum(sort_by);
        Collections.sort(list, (a, b) -> a[sortN] - b[sortN]);
        return list.toArray(new int[list.size()][]);
    }
    private int checkNum(String ext) {
        if (ext.equals("code")) return 0;
        else if (ext.equals("date")) return 1;
        else if (ext.equals("maximum")) return 2;
        else if (ext.equals("remain")) return 3;
        return -1;
    }
}