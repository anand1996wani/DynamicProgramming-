/*

Given a value N, find the number of ways to make change for N cents, if we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins. The order of coins doesn’t matter. For example, for N = 4 and S = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S = {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. So the output should be 5.

Input:

The first line contains an integer 'T' denoting the total number of test cases. In each test cases, the first line contains an integer 'M' denoting the size of array. The second line contains M space-separated integers A1, A2, ..., AN denoting the elements of the array. The third line contains an integer 'N' denoting the cents.

Output:

Print number of possible ways to make change for N cents.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 300
1 1 ≤ A[i] ≤ 300

Example:

Input:

2
3
1 2 3
4
4
2 5 3 6
10

Output:

4
5

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
		    int n = scanner.nextInt();
		    int denom[] = new int[n];
		    for(int i = 0;i < n;i++)
		        denom[i] = scanner.nextInt();
		    Arrays.sort(denom);
		    int cost = scanner.nextInt();
		    int array[][] = new int[denom.length+1][cost+1];
		    for(int j = 0;j < denom.length;j++){
		        if(denom[j] < cost + 1)
		            array[j+1][denom[j]] = 1;
		    }
		    for(int i = 1;i < denom.length+1;i++){
		        for(int j = 0;j < cost+1;j++){
		            if(j < denom[i-1]){
		                array[i][j] = array[i-1][j];
		            }else{
		                array[i][j] = array[i][j] + array[i-1][j] + array[i][j-denom[i-1]];
		            }
		        }
		    }
		    /*for(int i = 0;i < denom.length+1;i++){
		        for(int j = 0;j < cost + 1;j++){
		            System.out.print(array[i][j] + " ");
		        }
		        System.out.println();
		    }*/
		    System.out.println(array[denom.length][cost]);
		}
	}
}
