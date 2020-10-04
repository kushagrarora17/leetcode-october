class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
      if(intervals.length == 1)
        return 1;
      
      Arrays.sort(intervals, (int[] o1, int[] o2) -> o1[0] - o2[0] == 0 ? o2[1] - o1[1] : o1[0] - o2[0]);
      
      System.out.println(Arrays.deepToString(intervals));
      
      int count = intervals.length;
      int i = 0;
      int j = 1;
      
      while(i < intervals.length && j < intervals.length) {
        if(intervals[i][1] >=  intervals[j][1]) {
          count--;
          j++;
        } else {
          i = j++;
        }
      }
      
      return count;
    }
}
