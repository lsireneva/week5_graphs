import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static void main(String[] args){

        TreeNode<Integer> root= new TreeNode<>(3);
        root.left= new TreeNode<>(9);
        root.right = new TreeNode<>(20);
        root.right.left= new TreeNode<>(15);
        root.right.right = new TreeNode<>(7);
        System.out.println(levelOrder (root));
    }

    public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int cur_level = 1;
        int next_level = 0;
        ArrayList<Integer> list = new ArrayList<Integer>();

        if(root == null)
            return result;

        queue.offer(root);


        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            cur_level--;
            list.add((Integer) node.val);

            if(node.left != null){
                queue.offer(node.left);
                next_level++;
            }

            if(node.right != null){
                queue.offer(node.right);
                next_level++;
            }

            if(cur_level == 0){
                cur_level = next_level;
                next_level = 0;
                result.add(new ArrayList<Integer>(list));
                list.clear();
            }

        }

        return result;
    }

}
