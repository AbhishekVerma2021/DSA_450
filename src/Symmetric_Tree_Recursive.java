package DSA_450.src;



//We have to prove if the tree is Symmetric or not.
//Take the root node and pass its left and right subtree to another function to get 2 seperate
//trees x and y. now we can compare the values of the left subtree of x to
// right subtree of the y and vice versa.
public class Symmetric_Tree_Recursive
{
    static boolean a,b;
    public static boolean Symmetric(Node x,Node y)
    {
        if(x==null||y==null)
        {
            if(x==null&&y==null)
                return true;
            return false;
        }
        if(x.data!=y.data)
            return false;
        a=Symmetric(x.left,y.right);
        b=Symmetric(x.right,y.left);
        return a&&b;
    }
    public static boolean SymmetricTree(Node x)
    {
        if(x==null)
            return true;
        if(x.right==null&&x.right==null)
            return true;

        return Symmetric(x.left,x.right);
    }
    public static void main(String[] args)
    {
        Node root=new Node(1);
        root.left=new Node(2);
        root.left.left=new Node(3);
        root.right=new Node(2);
        root.right.right=new Node(3);

        System.out.println(SymmetricTree(root));
        Node.Print_Tree(root);
    }
}
