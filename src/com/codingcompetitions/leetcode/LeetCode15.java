package com.codingcompetitions.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
	}
	
}

class Solution15
{
    public List<List<Integer>> threeSum(int[] nums) 
    {
    	Set<List<Integer>> setIntegerLists = new HashSet<List<Integer>>();
    	List<List<Integer>> integerLists = new ArrayList<List<Integer>>();
    	int len = nums.length;
    	for( int inx = 0; inx < len-2; ++inx )
    	{
    		for( int jnx = inx+1; jnx < len-1; ++jnx )
    		{
    			for( int knx = jnx+1; knx < len; ++knx )
    			{
    				if( nums[inx] + nums[jnx] + nums[knx] == 0 )
    				{
    			    	List<Integer> integers =  new ArrayList<Integer>();
    					integers.add( nums[inx] );
    					integers.add( nums[jnx] );
    					integers.add( nums[knx] );
    					
    					integerLists.add( integers );
    				}
    			}
    		}
    	}
    	return integerLists;
    }
}
