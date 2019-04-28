/**
 * URL: https://leetcode.com/problems/merge-sorted-array/
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]

In place merge.
 */

package com.codingcompetitions.leetcode;

public class LeetCode88 {

	public static void main(String args[])
	{
		new Solution88().merge( new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3 );
		new Solution88().merge( new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3 );
		new Solution88().merge( new int[]{1}, 1, new int[]{}, 0 );
	}
}


class Solution88 
{
    public void merge(int[] firstArray, int m, int[] secondArray, int n) 
    {
    	int iArray1Ptr = m-1;
    	int iArray2Ptr = n-1;
    	int iReverseIndex = m+n-1;
    	
    	if( secondArray.length == 0 )
    	{
    		return;
    	}
    	
    	while( iArray2Ptr >= 0 )
    	{
    		if( iArray1Ptr < 0 )
    		{
    			// This means that there are elemens in the second array, but not in the first array, we just do a copy over of them.
    			while( iReverseIndex >= 0 )
    			{
    				firstArray[iReverseIndex] = secondArray[iArray2Ptr];
    				--iReverseIndex;
    				--iArray2Ptr;
    			}
    			break;
    		}
    		
    		if( firstArray[iArray1Ptr] <= secondArray[iArray2Ptr] )
    		{
    			firstArray[iReverseIndex] = secondArray[iArray2Ptr];
    			--iReverseIndex;
    			--iArray2Ptr;
    		}
    		else
    		{
    			firstArray[iReverseIndex] = firstArray[iArray1Ptr];
    			--iReverseIndex;
    			--iArray1Ptr;
    			
    		}
    	}
    	System.out.println( firstArray );
    }
}