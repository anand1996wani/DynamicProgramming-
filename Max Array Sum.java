/*

Max Array Sum

Given an array of integers, find the subset of non-adjacent elements with the maximum sum. Calculate the sum of that subset.
For example, given an array  we have the following possible subsets:

Our maximum subset sum is .

Function Description

Complete the  function in the editor below. It should return an integer representing the maximum subset sum for the given array.

maxSubsetSum has the following parameter(s):

arr: an array of integers
Input Format

The first line contains an integer, . 
The second line contains  space-separated integers .


*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] array) {
        int maxSum[] = new int[array.length];
        if(array.length == 1){
            return array[0];
        }else if(array.length == 2){
            return Math.max(array[0],array[1]);
        }else{
            maxSum[0] = array[0];
            maxSum[1] = Math.max(array[0],array[1]);
            int i = 2;
            int n = array.length;
            while(i < n){
                if(array[i] >= (maxSum[i - 2] + array[i]) && array[i] >=  maxSum[i - 1]){
                    maxSum[i] = array[i];
                }else if(maxSum[i - 1] >= (maxSum[i - 2] + array[i]) && maxSum[i - 1] >=  array[i]){
                    maxSum[i] = maxSum[i - 1];
                }else if((maxSum[i - 2]  + array[i]) >= array[i] && (maxSum[i - 2]  + array[i]) >= maxSum[i - 1]){
                    maxSum[i] = maxSum[i - 2]  + array[i];
                }
                i++;
            }
            return maxSum[n - 1];
        }


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


