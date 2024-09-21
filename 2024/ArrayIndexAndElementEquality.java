/*
Given a sorted array arr of distinct integers, write a function indexEqualsValueSearch that returns the lowest index i for which arr[i] == i. Return -1 if there is no such index. Analyze the time and space complexities of your solution and explain its correctness.

Examples:

input: arr = [-8,0,2,5]
output: 2 # since arr[2] == 2

input: arr = [-1,0,3,6]
output: -1 # since no index in arr satisfies arr[i] == i.
Constraints:

[time limit] 5000ms

[input] array.integer arr

1 ≤ arr.length ≤ 100
[output] integer
*/


/*
# Another solution

def index_equals_value_search(arr: List[int]) -> int:
    left, right = 0, len(arr)-1
    res = -1

    while left <= right:
        mid = (left+right)//2

        if arr[mid] >= mid:
            right = mid - 1
            res = mid if arr[mid] == mid else -1
        else:
            left = mid + 1
    
    return res
*/

class Solution {
  // TC: O(logN)
  // SC: O(1)
  static int indexEqualsValueSearch(int[] arr) {
    int N = arr.length;
    int left = 0;
    int right = N-1;
    int ans = Integer.MAX_VALUE;

    while (left <= right) {
        if (arr[left] == left) {
            ans = Math.min(ans, left);
        }
        int mid = left + (right-left)/2;  
        if (arr[mid] == mid) {
            ans = mid;
            right = mid-1;
        } else {
            left = mid+1;
        }
    }
    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  public static void main(String[] args) {
    System.out.println(indexEqualsValueSearch(new int[] {-8,0,2,5}));
    System.out.println(indexEqualsValueSearch(new int[] {-1,0,3,6}));
  }

}