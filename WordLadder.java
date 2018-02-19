import java.util.*;

public class WordLadder {

    public static int ladderLength(String start, String end, ArrayList<String> dict) {
            int result = 0;
            if (dict.size() == 0) {
                return result;
            }

            dict.add(start);
            dict.add(end);

            result = bfs(start, end, dict);

            return result;
        }

        private static int bfs(String start, String end, ArrayList<String> dict) {
            Queue<String> queue = new LinkedList<String>();
            Queue<Integer> length = new LinkedList<Integer>();
            queue.add(start);
            length.add(1);

            while (!queue.isEmpty()) {
                String word = queue.poll();
                int len = length.poll();

                if (word.equals(end))  {
                    return len;
                }

                for (int i = 0; i < word.length(); i++) {
                    char[] arr = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == arr[i])
                            continue;

                        arr[i] = c;
                        String str = String.valueOf(arr);
                        if (dict.contains(str)) {
                            queue.add(str);
                            length.add(len + 1);
                            dict.remove(str);
                        }
                    }
                }
            }

            return 0;
        }


    public static void main(String[] args){
        String start = "hit";
        String end = "cog";
        ArrayList<String> dictV = new ArrayList<String>();
        dictV.add("hot");
        dictV.add("dot");
        dictV.add("dog");
        dictV.add("lot");
        dictV.add("log");
        System.out.println(ladderLength(start, end, dictV));
    }

}
