/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/561/week-3-october-15th-october-21st/3497/

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
 

Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
Output: false
Example 3:

Input: matrix = [], target = 0
Output: false
 

Constraints:

m == matrix.length
n == matrix[i].length
0 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/


class Solution {
  public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    if(m == 0)
      return false;
    
    int n = matrix[0].length;
    if(n == 0)
      return false;
    
    int row = findRow(matrix, target, 0, m-1);
    
    // System.out.println(row);
    
    if(row == -1)
      return false;
    
    int column = findColumn(matrix[row], target, 0, n-1);
    // System.out.println(column);
    
    return (column != -1);
  }
  
  public int findRow(int[][] matrix, int target, int start, int end) {
    // System.out.println(start +"   "+ end);
    if(start > end)
      return -1;
    
    int mid = (start + end)/2;
    
    if(matrix[mid][0] <= target && (mid + 1 == matrix.length || matrix[mid+1][0] > target))
      return mid;
    
    if(matrix[mid][0] > target)
      return findRow(matrix, target, start, mid - 1);
    
    return findRow(matrix, target, mid+1, end);
  }
  
  public int findColumn(int[] arr, int target, int start, int end) {
    if(start > end)
      return -1;
    
    int mid = (start+end)/2;
    
    if(arr[mid] == target)
      return mid;
    
    if(arr[mid] < target)
      return findColumn(arr, target, mid+1, end);
    
    return findColumn(arr, target, start, mid-1);
  }
}
