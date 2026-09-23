class Solution {
    public int minOperations(int[] nums, int x) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }
        
        int target = totalSum - x;
        
        // Edge cases
        if (target == 0) return nums.length;
        if (target < 0) return -1;
        
        int maxLen = -1;
        int currentSum = 0;
        int left = 0;
        
        // Sliding window
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];
            
            // Shrink the window from the left if the sum exceeds target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }
            
            // Check if we found a valid subarray
            if (currentSum == target) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        
        // If maxLen remains -1, no valid subarray was found
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }
}
