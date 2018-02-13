import java.util.ArrayList;
import java.util.Stack;

public class Fibonacci_Sum {

    public static int fibsum(int A) {
        Stack<Integer> fib = new Stack<Integer>();
        int count = 0;
        int a = 1, b = 1;

        while (a <= A) {
            fib.push(a);
            int temp = a + b;
            a = b;
            b = temp;
        }

        for (int i = fib.size() - 1; i >= 0; i--) {
            int num = fib.get(i);
            while (num <= A) {
                A = A - num;
                count++;
            }
            if (A == 0) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args){
        int a = 4;
        System.out.println(fibsum(a));

    }
}
