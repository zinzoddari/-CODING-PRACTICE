public class searchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 1;
        System.out.println(searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        int result = 0;

        int middle = nums[nums.length / 2];

        int index = 0;
        int length = nums.length / 2;

        if( target >  middle ) {
            index = nums.length / 2;
            length = nums.length;
        }
        for (int i = index; i < length; i++) {
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