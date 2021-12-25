import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SubstringRemovalGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        while(n-- > 0) {
            String binary = sc.nextLine();
            char[] arr = binary.toCharArray();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            int count = 0;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == '1') {
                    count++;
                } else {
                    if(count > 0) {
                        pq.add(count);
                    }

                    count = 0;
                }
            }

            if(count > 0) {
                pq.add(count);
            }

            int score = 0;
            while(!pq.isEmpty()) {
                score += pq.peek();
                pq.poll();
                if(pq.size() > 0) {
                    pq.poll();
                }
            }
            System.out.println(score);
        }
    }
}
