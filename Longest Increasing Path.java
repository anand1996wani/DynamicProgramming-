/*
Longest Increasing Path

There is a 2D matrix of N rows and M columns. 
Rows are number 1 to N from top to bottom and columns 1 to M from left to right.
You are standing at (1,1).

From, A [ i ] [ j ] you can move to A [ i + 1 ] [ j ] if A [ i + 1 ] [ j ] > A [ i ] [ j ]. 
Or, from, A [ i ] [ j ] you can move to A [ i ] [ j + 1 ] if A [ i ] [ j + 1 ] > A [ i ] [ j ].
Moving from (1,1), what is the longest path that you can travel?

Input: 
First line contains, T, the number of testcases. Each testcase consists of N, M. Each of the next N lines contain M integers each.

Output: 
For each testcase, print the length of the longest path from (1,1).

Constraints: 
1 ≤ T ≤ 100 
1 ≤ N, M ≤ 100 
1 ≤ A[i][j] ≤ 10^6

Consider 2D array Matrix in which Matrix[i][j] denotes count of longest path starting from i,j. 
Element Matrix[n-1][m-1] is set to 1.
Then Matrix[i][j] = max(Matrix[i+1][j],Matrix[i][j+1])

*/
import java.util.Scanner;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for(int anand = 0;anand < test;anand++){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int array[][] = new int[n][m];
            for(int i = 0;i < n;i++){
                for(int j = 0;j < m;j++){
                    array[i][j] = scanner.nextInt();
                }
            }
            int matrix[][] = new int[n][m];
            matrix[n-1][m-1] = 1;
            for(int i = n-1;i>=0;i--){
                for(int j = m-1;j>=0;j--){
                    if(j==m-1 && i==n-1){
                        
                    }
                    else{
                        //System.out.println(i + " " + j);
                        boolean f1 = false,f2 = false;
                        if(j + 1 < m){
                            if(array[i][j] < array[i][j+1])
                                f1 = true;
                        }
                        if(i + 1 < n){
                            if(array[i][j] < array[i+1][j])
                                f2 = true;
                        }
                        if(f1 && f2)
                            matrix[i][j] = Math.max(matrix[i+1][j],matrix[i][j+1]) + 1;
                        else{
                            if(f1)
                                matrix[i][j] = matrix[i][j+1] + 1;
                            else if(f2)
                                matrix[i][j] = matrix[i+1][j] + 1;
                            else
                                matrix[i][j] = 1;
                        }
                    }
                }
            }
            /*
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    System.out.print(matrix[i][j]);
                    System.out.print(" ");
                }
                System.out.println();
            }*/
            System.out.println(matrix[0][0]);
        }
    }
}
