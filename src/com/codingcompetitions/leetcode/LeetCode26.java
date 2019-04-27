/**
 * URL: https://leetcode.com/problems/remove-duplicates-from-sorted-array/
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:

Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
Example 2:

Given nums = [0,0,1,1,1,2,2,3,3,4],

Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.

It doesn't matter what values are set beyond the returned length.
 */

package com.codingcompetitions.leetcode;

import java.io.IOException;

public class LeetCode26
{
	public static void main( String args[] ) throws NumberFormatException, IOException
	{
		System.out.println( new Solution26().removeDuplicates( new int[] {1,1,2} ) );
		System.out.println( new Solution26().removeDuplicates( new int[] {0,0,1,1,1,2,2,3,3,4} ) );
	}
}

class Solution26 
{
	// Optimal solution: As long as we are looking at the same numbers at the pointers i and j, we keep moving right.
	// Once we reach a different value, we simply increment i, copy the value at pointer j to pointer i and increment j and repeat the whole step again.
    public int removeDuplicates(int[] a)
    {
        int i = 0;
        int j = i + 1;
        
        while( j <= a.length - 1 )
        {
        	if( a[i] == a[j] )
        	{
        		j++;
        	}
        	else
        	{
        		i++;
        		a[i] = a[j];
        		j++;
        	}
        }
        return i+1;
    }
}
