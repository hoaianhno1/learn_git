package day1;

import java.util.HashMap;

public class MajorityElement {
    public static int majorityElement(int []nums){
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int x: nums){
            int freq = map.getOrDefault(x, 0) + 1;
            if(freq > n/2) return x;
            map.put(x, freq);
        }

        throw new IllegalArgumentException("Majority is not found");
    }

    static void main(String[] args) {
        int[] nums = {1, 3, 2, 1, 2, 1, 1, 3, 2, 1, 1, 1};
        int[] other_nums = {1, 2, 3, 2, 2, 2, 2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement(other_nums));
    }
}
