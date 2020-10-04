class Solution {
  public int findPairs(int[] nums, int k) {
    if(nums.length == 1)
      return 0;

    Arrays.sort(nums);

    int i = 0;
    int j;

    int count = 0;

    while(i < nums.length - 1) {
      j = i + 1;
      
      while(j < nums.length && nums[j] - nums[i] < k) {
        j++;
      }

      if(j < nums.length && nums[j] - nums[i] == k)
        count++;
      
      do{i++;}
      while(i < nums.length && nums[i] == nums[i-1]);
    }
    
    return count;
  }
}
