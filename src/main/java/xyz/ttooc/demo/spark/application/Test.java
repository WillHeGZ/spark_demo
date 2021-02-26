package xyz.ttooc.demo.spark.application;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 4};
        int target = 6;
        int[] twoSum = twoSum(nums, target);
        if (twoSum != null) {
            for (int i : twoSum) {
                System.out.println(i);
            }
        }


        int[] nums1 = new int[]{3, 0, 1};
        int missingNumber = missingNumber(nums1);
        System.out.println(missingNumber);

    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int tmp = target - nums[i];
            if (map.containsKey(tmp)) {
                return new int[]{map.get(tmp), i};
            } else {
                map.put(nums[i], i);
            }
        }

        return null;
    }

    public static int missingNumber(int[] nums) {
        int[] num = nums;
        List<int[]> ints = Arrays.asList(num);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int tmp = nums[i] - 1;
                if (!list.contains(tmp)) {
                    return tmp;
                }
            }
        }

        list.for

        return 0;
    }
}
