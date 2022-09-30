import java.util.*;

public class Test {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
            else if(target > nums[i]) {
                result = i+1;
            }
        }

        return result;
    }
}