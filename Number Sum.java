/*

Number Sum

Alice is given an array of  integers. Now, she is playing a game with Bob. In one turn Alice picks a sub-array of the given array . In every turn, she picks a new subarray i.e. one with either different starting index or different ending index from the subarrays picked before.

Now, Bob starts shouting the natural numbers from beginning i.e. he first says  then  and so on. Alice stops him at the first integer which does not appear in the subarray that she has picked in this turn. Later on, she asks Bob to write the sum of all the values in which she stops him on a paper. Bob is weak in maths, can you help him?

Note: Please go through the sample carefully.

Input Format

The first line contains a single integer . The next line contains  space-separated integers, where the -th integer denotes .

Output Format

Print the single integer representing the required result.

Constraints


SAMPLE INPUT 
3
1 2 3
SAMPLE OUTPUT 
12
Explanation
Since, Alice can pick any subarray in any order. So let's find out the answer for each subarray and then add it.

Array = 
In the below lines  denotes the subarray that inclues all elements in the range :






So, the answer is 12


*/

import java.util.*;
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        long array[] = new long[N];
        for(int i = 0; i < N;i++)
            array[i] = scanner.nextLong();
        long myArray[][] = new long[N][N];
        long sum = 0;
        for(int i = 0;i < N;i++){
            if(array[i] == 1){
                myArray[i][i] = 2;
            }
            else{
                myArray[i][i] = 1;
            }
            sum = sum + myArray[i][i];
        }
        for(int i = 0;i < N;i++){
            for(int j = i + 1;j < N;j++){
                if(array[j] == myArray[i][j - 1]){
                    myArray[i][j] = myArray[i][j - 1] + 1;
                }else{
                    myArray[i][j] = myArray[i][j - 1];
                }
                sum = sum + myArray[i][j];
            }
        }
        System.out.println(sum);
    }
}
