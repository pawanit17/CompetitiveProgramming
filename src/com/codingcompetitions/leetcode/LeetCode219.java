/** 
URL: https://leetcode.com/problems/contains-duplicate-ii/

Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.

Example 1:

Input: nums = [1,2,3,1], k = 3
Output: true
Example 2:

Input: nums = [1,0,1,1], k = 1
Output: true
Example 3:

Input: nums = [1,2,3,1,2,3], k = 2
Output: false
*/

package com.codingcompetitions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class LeetCode219 
{
	public static void main( String args[] ) throws NumberFormatException, IOException
	{
		Solution solution = new Solution();
		
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		
		int difference = Integer.parseInt( br.readLine() );
		
		String intArrayAsString = br.readLine();
		
		StringTokenizer st = new StringTokenizer( intArrayAsString, " " );
		
		List<Integer> numberList = new ArrayList<Integer>();
		
		while( st.hasMoreTokens() )
		{
			numberList.add( Integer.parseInt( st.nextToken() ) );
		}
		
		int[] numberArray = new int[numberList.size()];
		for( int inx = 0; inx < numberList.size(); ++inx )
		{
			numberArray[inx] = numberList.get(inx);
		}

		solution.containsNearbyDuplicate_version1( numberArray, difference );
		solution.containsNearbyDuplicate_version2( numberArray, difference );
		solution.containsNearbyDuplicate( new int[] { 1,2,3,1,2,3 }, 2 );
	}
	
}

class Solution 
{
    public boolean containsNearbyDuplicate_version2(int[] nums, int k) 
    {
    	int inx = 0;
    	int count = 0;
    	
    	while( inx < nums.length )
    	{
    		count = 1;
    		
    		while( count <= k && inx + count < nums.length )
    		{
    			if( nums[inx] == nums[inx+count] )
    			{
    				return true;
    			}
    			count++;
    		}
    		inx++;
    	}
    	return false;
    }

	public boolean containsNearbyDuplicate_version1(int[] nums, int k) 
    {
        int arrayLength = nums.length;
        for( int inx = 0; inx < arrayLength-1 ; ++inx )
        {
        	for( int jnx = inx+1; jnx < arrayLength ; ++jnx )
        	{
        		if( nums[inx] == nums[jnx] && jnx - inx <= k )
        		{
        			return true;
        		}
        	}
        }
        return false;
    }
	
	// On LeetCode, this was the optimal solution, with O(N) space and time complexities.
    public boolean containsNearbyDuplicate(int[] numberArray, int difference ) 
    {
		Map<Integer, Integer> numberMap = new HashMap<Integer, Integer>();
		
		for( int inx = 0; inx < numberArray.length; ++inx )
		{
			if( numberMap.containsKey( numberArray[inx] ) )
			{
				int previousIndex = numberMap.get( numberArray[inx] );
				if( inx - previousIndex <= difference )
				{
					return true;
				}
			}
			// Map has to be updated either when we are trying to insert a new array entry, or 
			// if we encounter another instance of the same number and the difference is not atmost 'K'.
			numberMap.put(numberArray[inx], inx);
		}
		return false;
	}	
}

