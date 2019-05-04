package com.codingcompetitions.leetcode;

import java.util.Arrays;

public class LeetCode16 
{
	public static void main( String args[] )
	{
		System.out.println( new Solution16().threeSumClosest( new int[] { -1, 2, 1, -4 }, 1 ) );
		System.out.println( new Solution16().threeSumClosest( new int[] { 1, 1, 1, 0 }, -100 ) );
	}
}

class Solution16 
{
	public int threeSumClosest(int[] nums, int target) 
    {
        Arrays.sort( nums );
    	int len = nums.length;
    	int overallRename = Integer.MAX_VALUE;
    	int overallClosestSum = 0;
    	for( int inx = 0; inx < len-2; ++inx )
    	{
    		for( int jnx = inx+1; jnx < len-1; ++jnx )
    		{
    			for( int knx = jnx+1; knx < len; ++knx )
    			{
   	        		int currentSum = nums[inx] + nums[jnx] + nums[knx];
   	        		if( Math.abs( currentSum - target ) < Math.abs( overallRename ) )
   	        		{
   	        			overallRename = currentSum - target;
   	        			overallClosestSum = currentSum;
   	        		}
    			}
    		}
    	}
		return overallClosestSum;
    }
	
    public int threeSumClosest2(int[] nums, int target) 
    {
        Arrays.sort( nums );
    	int jnx = 1;
    	int knx = nums.length - 1;
    	int currentMinimum = Integer.MAX_VALUE;
        	
        for( int inx = 0; inx < nums.length - 1 ; inx ++ )
        {
        	jnx = inx + 1;
        	knx = nums.length - 1;
        	
        	while( jnx < knx )
        	{
        		int currentSum = nums[inx] + nums[jnx] + nums[knx];
        		if( currentSum - target < currentMinimum )
        		{
        			currentMinimum = currentSum - target;
        		}
        		
        		if( nums[inx] + nums[jnx] + nums[knx] == 0 )
        		{

			    	
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
            
        	return 0;
        }
}
