package chk;

import java.util.Arrays;

public class MaxSumOfSubArray {

    public static void main(String[] args) {

        System.out.println(new MaxSumOfSubArray().maxSum(new int[]{2, 3, 4, 1, 5}, 2));

    }

    public int maxSum(int[] arr, int k) {

        if (arr.length < k) {
            throw new IllegalArgumentException("really?");
        }

        int[] sumArr = new int[arr.length - (k-1)];
        int sumIdx = 0;
        int windowSum = 0;
        int maxSum = 0;

        for (int i = 0; i < arr.length; i++) {

            windowSum += arr[i];

            if (i >= (k - 1)) {

                maxSum = Math.max(maxSum, windowSum);

                sumArr[sumIdx] = windowSum;
                windowSum -= arr[sumIdx];
                sumIdx++;
            }

        }
        System.out.println(Arrays.toString(sumArr));
        return maxSum;

    }


}
