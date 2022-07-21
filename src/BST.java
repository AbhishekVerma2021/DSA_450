class Node
{
    Node left,right;
    int data;
    Node(int data)
    {
        this.data=data;
    }
}

public class BST
{
    public static void insert(Node x,int data)
    {
        if(x==null)
        {
            System.out.println("NULL");
            return;
        }
        while (true)
        {
            if(x.data>data)
            {
                if(x.left!=null)
                {
                    x=x.left;
                }
                else
                {
                    x.left=new Node(data);
                    return;
                }
            }
            else if(x.data<data)
            {
                if(x.right!=null)
                {
                    x=x.right;
                }
                else
                {
                    x.right=new Node(data);
                    return;
                }
            }
            else{
                System.out.println("DUPLICATE DATA!!!!!!");
                return;
            }
        }
    }
    public static Node insert_rec(Node x,int data)
    {
        if(x==null)
        {
            return new Node(data);
        }
        if(x.data>data)
        {
            x.left=insert_rec(x.left,data);
        }
        else if(x.data<data)
        {
            x.right=insert_rec(x.right,data);
        }
        return x;
    }
    public static void print(Node x)
    {
        if(x==null)
        {
            return;
        }
        print(x.left);
        System.out.println(x.data);
        print(x.right);
    }
    public static void main(String[] args)
    {
        Node root=new Node(1);
        insert_rec(root,5);
        insert_rec(root,87);
        insert_rec(root,12);
        insert_rec(root,7);
        insert_rec(root,6);
        insert_rec(root,2);
        insert_rec(root,3);
        print(root);
    }
}
