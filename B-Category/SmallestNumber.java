import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SmallestNumber {

    static long result = Long.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            list.add(sc.nextLong());
        }
        sc.nextLine();
        String s = sc.nextLine();
        char arr[] = s.toCharArray();
        findCombinations(list, arr, 0, 0);
        System.out.println(result);
    } 

    public static void findCombinations(List<Long> list, char arr[], int index, long res) {
        if(index == 3) {
            result = Math.min(res, result);
            return;
        }
        int n = list.size();
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                long a = list.get(i);
                long b = list.get(j);
                list.remove(i);
                list.remove(j - 1);
                if(arr[index] == '*') {
                    list.add(a * b);
                    res += a * b;
                } else {
                    list.add(a + b);
                    res += a + b;
                } 
                findCombinations(list, arr, index + 1, res);
                list.remove(list.size() - 1);
                list.add(j, b);
                list.add(i, a);
                if(arr[index] == '*') {
                    res -= a * b;
                } else {
                    list.add(a + b);
                    res -= a + b;
                } 
            }
        }

        return;
    }
    
}
