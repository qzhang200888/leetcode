public class Solution {
    
    void bubblesort(int[] nums) {
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3 - i; ++j) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
    }
    
    int findNext(int[] nums, int val) {
        int i = 0;
        while (i < 4 && nums[i] <= val)
            ++i;
            
        if (i <= 3) {
            return nums[i];
        }
        
        return nums[0];
    }
    /**
     * @param time: the given time
     * @return: the next closest time
     */
    public String nextClosestTime(String time) {
        int[] nums = new int[] {time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
        
        bubblesort(nums);
        int newSecond = findNext(nums, time.charAt(4) - '0');
        if (newSecond > nums[0])
            return time.substring(0, 4) + newSecond;
            
        int newSecondTen = findNext(nums, time.charAt(3) - '0');
        if (newSecondTen > nums[0] && newSecondTen < 6)
            return time.substring(0, 3) + newSecondTen + "" + newSecond;
            
        newSecondTen = nums[0];
        
        int newHour = findNext(nums, time.charAt(1) - '0');
        if (newHour > nums[0] && (time.charAt(0) - '0' < 2 || newHour < 5))
            return time.substring(0, 1) + newHour + ":" +newSecondTen + "" + newSecond;
            
        newHour = nums[0];
        int newHourTen = findNext(nums, time.charAt(0) - '0');
        if (newHourTen > 2)
            newHourTen = nums[0];
            
        return "" + newHourTen+ "" + newHour + ":" + newSecondTen + "" + newSecond;
    }
}
