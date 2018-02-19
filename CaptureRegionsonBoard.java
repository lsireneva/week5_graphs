import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CaptureRegionsonBoard {

        public static void solve(ArrayList<ArrayList<Character>> a) {
            if(a == null || a.size() == 0)
                return;
            int m = a.size();
            int n = a.get(0).size();

            for(int i =0; i < m; i++){
                if(a.get(i).get(0) == 'O')
                    bfs(a, i, 0);
                if(a.get(i).get(n-1) == 'O')
                    bfs(a, i, n-1);
            }


            for(int j =0; j < n; j++){
                if(a.get(0).get(j) == 'O')
                    bfs(a, 0, j);
                if(a.get(m-1).get(j) == 'O')
                    bfs(a, m-1, j);
            }
            for(int i = 0; i < m; i++){
                for(int j =0; j < n; j++){
                    if(a.get(i).get(j) == 'O')
                        a.get(i).set(j, 'X');
                    else if(a.get(i).get(j) == '#')
                        a.get(i).set(j, 'O');
                }
            }

        }

        public static void bfs(ArrayList<ArrayList<Character>> a, int i, int j){
            if(i < 0 || i >= a.size() || j < 0 || j >= a.get(0).size())
                return;

            if(a.get(i).get(j) != 'O')
                return;

            a.get(i).set(j, '#');

            bfs(a, i - 1, j); // top
            bfs(a, i + 1, j); // bottom
            bfs(a, i, j - 1); // left
            bfs(a, i, j + 1); // right
        }

    public static void main(String[] args){
        ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>>();
        ArrayList<Character> temp = new ArrayList<Character>();
        temp.add('X');
        temp.add('X');
        temp.add('X');
        a.add(new ArrayList<Character>(temp));
        temp.clear();

        temp.add('X');
        temp.add('0');
        temp.add('X');
        a.add(new ArrayList<Character>(temp));
        temp.clear();

        temp.add('X');
        temp.add('X');
        temp.add('X');
        a.add(new ArrayList<Character>(temp));
        temp.clear();


        for(ArrayList<Character> list : a){
            System.out.println(list);
        }

        solve(a);
        System.out.println();
        for(ArrayList<Character> list : a){
            System.out.println(list);
        }
    }
}
