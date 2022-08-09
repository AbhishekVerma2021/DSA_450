package DSA_450.src;

public class Node
{
    Node left,right;
    int data;
    Node(int data)
    {
        this.data=data;
    }
    public static void Print_Tree(Node x)
    {
        if(x==null)
            return;
        Print_Tree(x.left);
        System.out.print(x.data+" ");
        Print_Tree(x.right);
    }
}
