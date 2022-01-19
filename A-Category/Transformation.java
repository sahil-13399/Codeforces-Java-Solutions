import java.util.ArrayList;
import java.util.Scanner;

public class Transformation {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();
        ArrayList<Long> list = new ArrayList<Long>();
        list.add(a);
        boolean flag = callTransformation(a,b,list);

        if(!flag) {
            System.out.println("NO");
        }

    }

    private static boolean callTransformation(long a, long b, ArrayList<Long> list) {

        if(a > b) {
            return false;
        }

        if(a == b) {
            System.out.println("YES");
            System.out.println(list.size());
           for(long num : list) {
                System.out.print(num + " ");
            }
            return true;
        }
        list.add(10 * a + 1);
        boolean result1 = callTransformation(10 * a + 1, b, list);
        list.remove(list.size() - 1);
        list.add(2 * a);
        boolean result2 = callTransformation(2 * a, b, list);
        list.remove(list.size() - 1);
        return result1 || result2;
    }
}
