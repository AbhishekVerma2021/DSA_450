package DSA_450.src;

public class RecursiveInorder
{
    public static Node Inorder(Node x)
    {
        if(x==null)
            return x;
        Inorder(x.left);
        System.out.print(x.data+" ");
        Inorder(x.right);
        return x;
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
