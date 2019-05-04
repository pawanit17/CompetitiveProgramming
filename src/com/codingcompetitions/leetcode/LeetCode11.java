/**
 * URL: https://leetcode.com/problems/container-with-most-water/
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.

Example:

Input: [1,8,6,2,5,4,8,3,7]
Output: 49

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

public class LeetCode11 
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
		Solution11 solution = new Solution11();
		// System.out.println( solution.maxArea( numberArray ) );
		System.out.println( solution.maxArea( new int[] { 1,8,6,2,5,4,8,3,7 }  ) );		
	}	
}

class Solution11 
{
    public int maxArea(int[] heights ) 
    {
        // The max ares would be a rectangle ( a square too, is a rectangle ).
    	// The area of that rectangle would length * breadth.
    	// Length would be the minimum of the values at two indices.
    	// The breadth would be the difference between the two indices.
    	int breadth = 0;
    	int length = 0;
    	int maxRectangle = 0;
    	
    	for( int inx = 0; inx < heights.length - 1; ++inx )
    	{
    		for( int jnx = inx + 1; jnx < heights.length; ++jnx )
    		{
    			breadth = jnx - inx;
    			
    			length = ( heights[inx] < heights[jnx] ) ? heights[inx]:heights[jnx];

    			int currentArea = length * breadth;
    			maxRectangle = ( currentArea > maxRectangle ) ? currentArea:  maxRectangle; 
    		}
    	}
    	return maxRectangle;
    }
}












