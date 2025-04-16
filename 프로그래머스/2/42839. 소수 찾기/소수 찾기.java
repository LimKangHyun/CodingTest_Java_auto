import java.util.*;

class Solution {

    List<String> permNums = new ArrayList<>();

    public int solution(String numbers) {
        int answer = 0;

        String[] nums = numbers.split("");

        for(int i =0; i<nums.length; i++){
            permNums.add(nums[i]);
        }

        for(int i = 2; i <= nums.length; i++){
            permutation(nums, 0, nums.length, i);
        }

        List<String> uniquePermNums = new ArrayList<>(new HashSet<>(permNums));

        List<Integer> permNumsInteger = isPrimeNumber(uniquePermNums);

        List<Integer> uniqueInteger = new ArrayList<>(new HashSet<>(permNumsInteger));

        answer = uniqueInteger.size();

        return answer;
    }

    public void permutation(String[] nums, int depth, int n, int r) {
        if(depth == r){
            permNums.add(String.join("", nums).substring(0,r));
            return;
        }

        for (int i = depth; i < n; i++) {
            swap(nums, depth, i);
            permutation(nums, depth + 1, n, r);
            swap(nums, depth, i);
        }
    }
    public void swap(String[] nums, int depth, int i) {
        String temp = nums[depth];
        nums[depth] = nums[i];
        nums[i] = temp;
    }
    public List<Integer> isPrimeNumber(List<String> uniquePermNums) {
        List<Integer> nums = new ArrayList<>();

        for (String uniqueNum : uniquePermNums) {
            int i = 2;
            int num = Integer.parseInt(uniqueNum);
            if (num <= 1) continue;

            boolean isPrime = true;
            for(; i * i <= num; i++){
                if(num % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) {
                nums.add(num);
            }
        }
        return nums;
    }
}