/*

Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.

Input:
First line of the input contains no of test cases  T,the T test cases follow.
Each test case consist of 2 space separated integers A and B denoting the size of string str1 and str2 respectively
The next two lines contains the 2 string str1 and str2 .


Output:
For each test case print the length of longest  common subsequence of the two strings .


Constraints:
1<=T<=200
1<=size(str1),size(str2)<=100


Example:
Input:
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC

Output:
3
2

Explanation
LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.

LCS of "ABC" and "AC" is "AC" of length 2

*/

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
 {
	public static void main (String[] args)
	 {
	 //code
	    Scanner scanner = new Scanner(System.in);
	    int test = scanner.nextInt();
	    for(int z = 0;z < test;z++){
	        int l1 = scanner.nextInt();
	        int l2 = scanner.nextInt();
	        String st1 = scanner.next();
	        String st2 = scanner.next();
	        int n,m;
	        char a1[] = new char[st1.length()];
	        char a2[] = new char[st2.length()];
	        if(st1.length() >= st2.length()){
	            n = st1.length();
	            m = st2.length();
	            a1 = st1.toCharArray();
	            a2 = st2.toCharArray();
	        }
	        else{
	            n = st2.length();
	            m = st1.length();
	            a1 = st2.toCharArray();
	            a2 = st1.toCharArray();
	        }
	        
	        int array[][] = new int[m+1][n+1];
	        for(int i = 1;i < m+1;i++){
	            for(int j = 1;j < n+1;j++){
	                if(a2[i-1]==a1[j-1]){
	                    array[i][j] = array[i-1][j-1] + 1;
	                }
	                else{
	                    array[i][j] = Math.max(array[i][j-1],array[i-1][j]);
	                }
	            }
	        }
	        System.out.println(array[m][n]);
	    }
	 }
}
