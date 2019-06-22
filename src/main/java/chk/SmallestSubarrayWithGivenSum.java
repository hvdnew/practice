package chk;

/**
 * <p>Given an array of positive numbers and a positive number ‘S’, find the length of the smallest subarray
 * whose sum is greater than or equal to ‘S’. Return 0, if no such subarray exists. <br>
 * Input: [2, 1, 5, 2, 3, 2], S=7
 * Output: 2
 * Input: [2, 1, 5, 2, 8], S=7
 * Output: 1
 * Input: [3, 4, 1, 1, 6], S=8
 * Output: 3
 * </p>
 */
public class SmallestSubarrayWithGivenSum {

    public static void main(String[] args) {

        System.out.println(new SmallestSubarrayWithGivenSum().smallestSubarrayLength(new int[]{2, 1, 5, 2, 3, 2}, 7));
        System.out.println(new SmallestSubarrayWithGivenSum().smallestSubarrayLength(new int[]{2, 1, 5, 2, 8}, 7));
        System.out.println(new SmallestSubarrayWithGivenSum().smallestSubarrayLength(new int[]{3, 4, 1, 1, 6}, 8));

    }


    public int smallestSubarrayLength(int[] arr, int sum) {

        int windowStart = 0, windowEnd = 0;
        int windowSum = 0;
        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            windowSum += arr[i];

            // shrink window till windowSum < sum
            // update window sum
            // shrink window size
            while (windowSum >= sum) {
                // save minlength
                minLength = Math.min((windowEnd - windowStart + 1), minLength);
                windowSum -= arr[windowStart];
                windowStart++;
            }

            windowEnd++;

        }


        return minLength;
    }


}
