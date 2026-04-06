import java.util.*;

class FileInfo {
    String original;
    String head;
    int number;
    int index;
    
    FileInfo(String original, String head, int number, int index) {
        this.original = original;
        this.head = head;
        this.number = number;
        this.index = index;
    }
}

class Solution {
    public String[] solution(String[] files) {
        int n = files.length;
        FileInfo[] arr = new FileInfo[n];
        for (int i = 0; i < n; i++) {
            String file = files[i];
            
            int idx = 0;
            while (idx < file.length() && !Character.isDigit(file.charAt(idx))) {
                idx++;
            }
            
            String head = file.substring(0, idx).toLowerCase();
            
            int numStart = idx;
            while (idx < file.length() && Character.isDigit(file.charAt(idx))) {
                idx++;
            }
            int number = Integer.parseInt(file.substring(numStart, idx));
            
            arr[i] = new FileInfo(file, head, number, i);
        }
        
        Arrays.sort(arr, (a, b) -> {
            int headCompare = a.head.compareTo(b.head);
            if (headCompare != 0) return headCompare;
            
            int numCompare = Integer.compare(a.number, b.number);
            if (numCompare != 0) return numCompare;
            return Integer.compare(a.index, b.index);
        });
        
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            answer[i] = arr[i].original;
        }
        return answer;
    }
}