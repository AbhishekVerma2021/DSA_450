package DSA_450.src;

public class Mirror_Tree
{
    public static Node Mirror_Tree(Node x)
    {
        if(x==null)
            return x;
        Node temp=x.left;
        x.left=x.right;
        x.right=temp;
        Mirror_Tree(x.left);
        Mirror_Tree(x.right);
        return x;
    }
    public static void Print_tree(Node x)
    {
        if (x==null)
            return;

        Print_tree(x.left);
        System.out.print(x.data+" ");
        Print_tree(x.right);
    }
    public static void main(String[] args) {
        Node root=new Node(5);
        root.left=new Node(6);
        root.right=new Node(3);
        root.right.left=new Node(4);
        root.right.right=new Node(2);
        root=Mirror_Tree(root);
        Print_tree(root);
    }
}
