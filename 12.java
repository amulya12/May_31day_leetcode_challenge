// You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

// Example 1:
// Input: [1,1,2,3,3,4,4,8,8]
// Output: 2

// Example 2:
// Input: [3,3,7,7,10,11,11]
// Output: 10
 
// Note: Your solution should run in O(log n) time and O(1) space.

class Solution {
    public int singleNonDuplicate(int[] nums) {
      int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            // if mid is even, then it's pair should be after that position or if mid is odd, then it's pair should be before that position.
            if ((mid & 1) == 0) {
                // mid+1 should be the partner
                if (nums[mid] != nums[mid+1]) {
                    right = mid;
                } else {
                    left = mid + 2;
                }
            } else { // middle is odd
                // mid-1 should be the partner
                if (nums[mid] != nums[mid-1]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        // left == right
        return nums[left];  
    }
}