import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class StepNum {

    public static void main(String args[]){
        int n = 10, m = 20;

        // Display Stepping Numbers in
        // the range [n,m]

        ArrayList<Integer> result = stepnum(n, m);
        System.out.println(result);
    }

    public static ArrayList<Integer> stepnum(int A, int B) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0 ; i <= 9 ; i++)
            bfs(A, B, i, result);

        return result;
    }


    public static void bfs(int n,int m,int num, ArrayList result)
    {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(num);

        while (!q.isEmpty())
        {
            int step_num = q.poll();
            System.out.println(step_num);

            if (step_num <= m && step_num >= n)
            {
                result.add(step_num);
            }
            if (step_num == 0 || step_num > m)
                continue;

            int last_digit = step_num % 10;
            System.out.println("last_digit="+last_digit);

            int step_num_a = step_num * 10 + (last_digit - 1);
            int step_num_b = step_num * 10 + (last_digit + 1);

            if (last_digit == 0)
                q.add(step_num_b);
            else if (last_digit == 9)
                q.add(step_num_a);

            else
            {
                q.add(step_num_a);
                q.add(step_num_b);
            }
        }
    }

}
