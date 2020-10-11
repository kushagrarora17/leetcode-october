class Solution {
    public int findMinArrowShots(int[][] points) {
      int count = points.length;
      
      if(count == 0)
        return 0;
      
      Arrays.sort(points, (o1, o2) -> o1[1] - o2[1]);
      
      // System.out.println(Arrays.deepToString(points));
      
      int current = points[0][1];
      int j = 1;
      
      while(j < points.length) {
        // System.out.println(current + "     " + j);
        if(points[j][0] <= current && points[j][1] >= current){
          count--;
        } else {
          current = points[j][1];
        }
        j++;
      }
      
      return count;
    }
}
