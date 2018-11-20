/*
0 - 1 Knapsack Problem


You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. 
Note that we have only one quantity of each item, In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. 
Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. 
You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

*/


/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    int partition(int weight[],int value[],int low,int high){
        int pivotele = weight[high];
        int pivotele1 = value[high];
        int index = low - 1;
        for(int i = low;i < high;i++){
            if(weight[i] < pivotele){
                int temp1 = value[index+1];
                value[index+1] = value[i];
                value[i] = temp1;
                
                int temp = weight[index+1];
                weight[index+1] = weight[i];
                weight[i] = temp;
                index++;
            }
        }
        int temp1 = value[index+1];
        value[index+1] = pivotele1;
        value[high] = temp1;
        
        int temp = weight[index+1];
        weight[index+1] = pivotele;
        weight[high] = temp;
        return index+1;
    }
    void sort(int weight[],int value[],int low,int high){
        if(low < high){
            int pivot = this.partition(weight,value,low,high);
            this.sort(weight,value,low,pivot-1);
            this.sort(weight,value,pivot+1,high);
        }
    }
	public static void main (String[] args) {
		//code
		Scanner scanner = new Scanner(System.in);
		int test = scanner.nextInt();
		for(int c = 0; c < test;c++){
		    int n = scanner.nextInt();
		    int w = scanner.nextInt();
		    int value[] = new int[n];
		    int weight[] = new int[n];
		    for(int i = 0;i<n;i++){
		        value[i] = scanner.nextInt();
		    }
		    for(int i = 0;i<n;i++){
		        weight[i] = scanner.nextInt();
		    }
		    GFG gfg = new GFG();
		    gfg.sort(weight,value,0,n-1);
		    int array[][] = new int[n+1][w+1];
		    for(int i = 1;i < n+1;i++){
		        for(int j = 0;j < w+1;j++){
		            if(j < weight[i-1]){
		                array[i][j] = array[i-1][j];
		            }else{
		                array[i][j] = Math.max(array[i-1][j],value[i-1] + array[i-1][j-weight[i-1]]);
		            }
		        }
		    }
		    /*for(int i = 1;i < n+1;i++){
		        for(int j = 0;j < w+1;j++){
		           System.out.print(array[i][j] + " "); 
		        }
		        System.out.println();
		    }*/
		    System.out.println(array[n][w]);
		}
	}
}
