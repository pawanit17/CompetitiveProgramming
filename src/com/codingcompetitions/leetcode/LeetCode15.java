/**
 * URL: https://leetcode.com/problems/3sum/
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
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

public class LeetCode15 
{
	public static void main( String args[] ) throws NumberFormatException, IOException
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ));
		
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

		Solution15 solution = new Solution15();
		solution.threeSum( numberArray );
		solution.threeSum( new int[] { -1,0,1,2,-1,-4} );
	}
	
}

class Solution15
{
	// This is the optimal solution. Took 187 micro seconds on Leetcode.
	// Fix inx at beginning of the array, incrementing by 1 for each iteration.
	// 	Fix jnx to inx + 1 and knx to array length - 1 so that we go forward and backward for each inx pivot.
	// Finally, collect the results into a SET so that the duplicates can be removed.
	public List<List<Integer>> threeSum(int[] nums) 
    {
        Arrays.sort( nums );
        Set<List<Integer>> numberListSet = new HashSet<List<Integer>>();

    	int jnx = 1;
    	int knx = nums.length - 1;
    	
        for( int inx = 0; inx < nums.length - 1 ; inx ++ )
        {
        	jnx = inx + 1;
        	knx = nums.length - 1;
        	
        	while( jnx < knx )
        	{
        		if( nums[inx] + nums[jnx] + nums[knx] == 0 )
        		{
        			List<Integer> numberList = new ArrayList<Integer>();
					numberList.add( nums[inx] );
					numberList.add( nums[jnx] );
					numberList.add( nums[knx] );
					
			    	numberListSet.add( numberList );
			    	
			    	jnx++;
			    	knx--;
        		}
        		else if( nums[inx] + nums[jnx] + nums[knx] < 0 )
        		{
        			jnx++;
        		}
        		else
        		{
        			knx--;
        		}
        	}
        }
        
    	List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
    	listOfLists.addAll( numberListSet );
    	return listOfLists;
    }
	
	public List<List<Integer>> threeSumVersion1(int[] nums) 
    {
        Arrays.sort( nums );
    	Set<List<Integer>> numberListSet = new HashSet<List<Integer>>();
    	int len = nums.length;
    	for( int inx = 0; inx < len-2; ++inx )
    	{
    		for( int jnx = inx+1; jnx < len-1; ++jnx )
    		{
    			for( int knx = jnx+1; knx < len; ++knx )
    			{
    				if( nums[inx] + nums[jnx] + nums[knx] == 0 )
    				{
    					List<Integer> numberList = new ArrayList<Integer>();
    					numberList.add( nums[inx] );
    					numberList.add( nums[jnx] );
    					numberList.add( nums[knx] );
    					
    			    	numberListSet.add( numberList );
    				}
    			}
    		}
    	}
    	
    	List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
    	listOfLists.addAll( numberListSet );
    	return listOfLists;
    }
}
