/*

Longest Palindrome in a String

Given a string S, find the longest palindromic substring in S.

Substring of string S:

S[ i . . . . j ] where 0 ≤ i ≤ j < len(S)

Palindrome string:

A string which reads the same backwards. More formally, S is palindrome if reverse(S) = S.

Incase of conflict, return the substring which occurs first ( with the least starting index ).

NOTE: Required Time Complexity O(n2).

Input:

The first line of input consists number of the test cases. The following T lines consist of a string each.


Output:

In each separate line print the longest palindrome of the string given in the respective test case.


Constraints:

1 ≤T≤ 100
1 ≤ Str Length≤ 104

Example:

Input:
1
aaaabbaa

Output:

aabbaa

*/


import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		for(int an = 0;an < test;an++){
		    String string = scanner.next();
		    int n = string.length();
        	//char ar[] = new char[n];
            //	ar = string.toCharArray();
		    if(string.length()==1){
		        System.out.println(string);
		    }else if(string.length()==2){
		        if(string.charAt(0)==string.charAt(1)){
		            System.out.println(string);
		        }else{
		            System.out.println(string.charAt(0));
		        }
		    }else{
    		    int array[][] = new int[n][n];
    		    //for length 1 palindrome
    		    for(int i = 0;i < n;i++){
    		        array[i][i] = 1;
    		    }
    		    int max_length = 0;
    		    int start = 0;
    		    int stop = 0; 
    		    
    		    //for length 2 palindrome
    		    for(int i = 0;i < n - 1;i++){
    		        if(string.charAt(i)==string.charAt(i + 1)){
    		            array[i][i+1] = 1;
    		            if(max_length < 2){
    		                max_length = 2;
    		                start = i;
    		                stop = i + 1;
    		            }
    		        }
    		    }
    		    
    		    //for length 3 and more
    		    for(int k = 3;k <= n;k++){
    		        for(int i = 0;i < n - k + 1;i++){
    		            int j = i + k - 1;
    		            if(array[i + 1][j - 1] == 1 && string.charAt(i)==string.charAt(j)){
    		                array[i][j] = 1;
    		                if(j - i + 1 > max_length){
    		                    start = i;
    		                    stop = j;
    		                    max_length = j - i + 1;
    		                }
    		            }
    		        }
    		    }
    		    String temp = "";
    		    for(int i = start;i <= stop;i++)
    		        temp = temp + string.charAt(i);
    		    System.out.println(temp);

		    }
		}
	}
}
