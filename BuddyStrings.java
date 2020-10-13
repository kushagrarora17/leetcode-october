/*
https://leetcode.com/explore/challenge/card/october-leetcoding-challenge/560/week-2-october-8th-october-14th/3492/

Given two strings A and B of lowercase letters, return true if you can swap two letters in A so the result is equal to B, otherwise, return false.

Swapping letters is defined as taking two indices i and j (0-indexed) such that i != j and swapping the characters at A[i] and A[j]. For example, swapping at indices 0 and 2 in "abcd" results in "cbad".

 

Example 1:

Input: A = "ab", B = "ba"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'b' to get "ba", which is equal to B.
Example 2:

Input: A = "ab", B = "ab"
Output: false
Explanation: The only letters you can swap are A[0] = 'a' and A[1] = 'b', which results in "ba" != B.
Example 3:

Input: A = "aa", B = "aa"
Output: true
Explanation: You can swap A[0] = 'a' and A[1] = 'a' to get "aa", which is equal to B.
Example 4:

Input: A = "aaaaaaabc", B = "aaaaaaacb"
Output: true
Example 5:

Input: A = "", B = "aa"
Output: false
 

Constraints:

0 <= A.length <= 20000
0 <= B.length <= 20000
A and B consist of lowercase letters.
*/

class Solution {
  public boolean buddyStrings(String A, String B) {
    
    if(A.length() != B.length())
      return false;
    
    if(A.equals(B)) {
      char[] arr = A.toCharArray();
      Arrays.sort(arr);
      for(int i = 0; i < arr.length - 1; i++){
        if(arr[i] == arr[i+1])
          return true;
      }
    } else {
      char[] arr = A.toCharArray();
      char[] brr = B.toCharArray();
      
      List<Integer> index = new ArrayList<Integer>();
      
      for(int i = 0; i < arr.length; i++) {
        if(arr[i] != brr[i])
          index.add(i);
      }
      
      if(index.size() != 2)
        return false;
      
      char a1 = arr[index.get(0)];
      char b1 = brr[index.get(0)];
      char a2 = arr[index.get(1)];
      char b2 = brr[index.get(1)];
      
      if(a1 == b2 && a2 == b1)
        return true;
    }
    
    return false;
  }
}
