package day1;

import java.util.Arrays;

public class ArrayUltils {
    public static int max(int[] nums) throws IllegalArgumentException {
        if (nums == null){
            throw new IllegalArgumentException("Tham so khong hop le");
        };
        int max = nums[0];
        for(int x : nums){
            if(x > max) max = x;
        }
        return max;
    }

    public static int secondMax(int[] nums) throws IllegalArgumentException{
        if(nums == null || nums.length < 2){
            throw new IllegalArgumentException("Invalid int array");
        }
        int max = Integer.MIN_VALUE;
        Integer second = null;
        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(x > max){
                second = max;
                max = nums[i];
            }
            else if(x < max){
                if(second != null || x > second){
                    second = nums[i];
                }
            }
        }
        if(second == null){
            throw new IllegalArgumentException("Error");
        }
        return second;
    }

    public static int removeDuplicatesSorted(int[] nums) throws IllegalArgumentException{
        if(nums == null) throw new IllegalArgumentException("Invalid nums");
        if(nums.length == 0) return 0;
        int k = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[k-1]){
                nums[k++] = nums[i];
            }
        }
        return k;
    }


    static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 6, 3, 8, 9, 2};
        System.out.print("Nums: ");
        for(int x: nums){
            System.out.print(x + " ");
        }
        System.out.println("");
        System.out.println("Max = " + max(nums));
        System.out.println("Second max = " + secondMax(nums));
        Arrays.sort(nums);
        System.out.println("So phan tu khac nhau trong nums la: " + removeDuplicatesSorted(nums));
    }
}
