/**
 * URL: https://leetcode.com/problems/search-insert-position/
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
 */

package com.codingcompetitions.leetcode;

import java.io.IOException;

public class LeetCode35
{
	public static void main( String args[] ) throws NumberFormatException, IOException
	{
		System.out.println( new Solution35().searchInsert( new int[] {1,3,5,6}, 5 ) );
		System.out.println( new Solution35().searchInsert( new int[] {1,3,5,6}, 2 ) );
		System.out.println( new Solution35().searchInsert( new int[] {1,3,5,6}, 7 ) );
		System.out.println( new Solution35().searchInsert( new int[] {1,3,5,6}, 0 ) );
		
		
	}
	
}

class Solution35
{
    public int searchInsert(int[] nums, int target) 
    {
        int iFrontPtr = 0;
        int iRearPtr = nums.length - 1;
        
        while( iFrontPtr <= iRearPtr )
        {
        	int mid = (iFrontPtr + iRearPtr)/2;
        	if( nums[mid] == target )
        	{
        		return mid;
        	}
        	else if( nums[mid] < target )
        	{
        		iFrontPtr = mid + 1;
        	}
        	else
        	{
        		iRearPtr = mid - 1;
        	}
        }
        return iFrontPtr;
    }
}
