import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            long[] arr = new long[n];

            for(int i = 0 ; i < n; i++) {
                arr[i] = sc.nextLong();
            }
            int maxCount = 0;
            for(int i = 0; i < n; i++) {
                int count = 0;
                for(int j = i; j < n; j++) {
                    if(Math.abs(arr[j] - arr[i]) <= 2) {
                        count++;
                    }
                }

                maxCount = Math.max(maxCount,count);
            }
            
            System.out.println(maxCount);
        }


    }
}
