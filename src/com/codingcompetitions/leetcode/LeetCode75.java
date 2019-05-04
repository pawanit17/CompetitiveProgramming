/**
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note: You are not suppose to use the library's sort function for this problem.

Example:

Input: [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Follow up:

A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?

*/

package com.codingcompetitions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class LeetCode75 
{
	public static void main( String args[] ) throws NumberFormatException, IOException
	{
//		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
//		
//		String intArrayAsString = br.readLine();
//		
//		StringTokenizer st = new StringTokenizer( intArrayAsString, " " );
//		
//		List<Integer> numberList = new ArrayList<Integer>();
//		
//		while( st.hasMoreTokens() )
//		{
//			numberList.add( Integer.parseInt( st.nextToken() ) );
//		}
//		
//		int[] numberArray = new int[numberList.size()];
//		for( int inx = 0; inx < numberList.size(); ++inx )
//		{
//			numberArray[inx] = numberList.get(inx);
//		}
//
		Solution75 solution = new Solution75();
		// System.out.println( solution.maxArea( numberArray ) );
		solution.sortColors( new int[] { 2,0,2,1,1,0 }  );		
	}	
}

class Solution75
{
    public void sortColors(int[] nums)
    {
        int indexOf0 = 0;
        int indexOf1 = 0;
        int indexOf2 = nums.length-1;
		int temp = 0;
		
        while( indexOf1 <= indexOf2 )
        {
        	switch( nums[indexOf1])
        	{
        		case 0: temp = nums[indexOf1];
        				nums[indexOf1] = nums[indexOf0]; 
        				nums[indexOf0] = temp;
        				indexOf0++;
        				indexOf1++;
        				break;

        		case 1: indexOf1++;
        				break;

        		default: temp = nums[indexOf1];
        				 nums[indexOf1] = nums[indexOf2];
        				 nums[indexOf2] = temp;
        				 indexOf2--;
        	}
        }
    }
}

