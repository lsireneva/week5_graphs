import java.util.List;

public class Convert_Sorted_List_to_Binary_Search_Tree {


    public static void main(String[] args){

        ListNode head = null;

        head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode tail = new ListNode(6);
        head.next.next.next.next.next = tail;
        sortedListToBST (head);
        preOrder(sortedListToBST (head));
    }

    public static TreeNode sortedListToBST(ListNode a) {
        if(a==null) return null;

        return LLToBST( a, null);
    }

    public static TreeNode LLToBST(ListNode head, ListNode tail){
        ListNode slow_ptr = head;
        ListNode fast_ptr = head;

        if(head==tail) return null;

        while(fast_ptr!=tail && fast_ptr.next!= tail){
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        TreeNode tree_head = new TreeNode (slow_ptr.val);
        tree_head.left = LLToBST(head,slow_ptr);
        tree_head.right = LLToBST(slow_ptr.next,tail);
        return tree_head;
    }

    static void preOrder(TreeNode node)
    {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }
}
