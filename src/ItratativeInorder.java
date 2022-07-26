package DSA_450.src;


import java.util.Stack;

public class ItratativeInorder
{
    public static void Inorder(Node x)
    {
        Stack<Node> stack=new Stack<>();
        while (!stack.isEmpty()||x!=null)
        {
            if(x!=null)
            {
                stack.push(x);
                x=x.left;
            }
            else
            {
                x=stack.pop();
                System.out.print(x.data+" ");
                x=x.right;
            }
        }
    }
    public static void main(String[] args) {
        /* Construct the following tree
                   1
                 /   \
                /     \
               2       3
              /      /   \
             /      /     \
            4      5       6
                  / \
                 /   \
                7     8
        */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        Inorder(root);
    }

}
