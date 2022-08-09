package DSA_450.src;

import java.util.ArrayList;

public class Symmetric_Tree
{
    static ArrayList<Integer> List=new ArrayList<>();
    public static ArrayList<Integer> Nodes(Node x)
    {
        if(x==null)
            return List;
        Nodes(x.left);
        List.add(x.data);
        Nodes(x.right);
        return List;
    }
    public static boolean SymmetricTree(Node x)
    {

        ArrayList<Integer> List=Nodes(x);

        if(List.size()==1)
            return true;
        if(List.size()%2!=0)
        {
            int f=0;
            for(int i=0,j=List.size()-1;i<List.size()/2&&j>List.size()/2;i++,j--)
            {
                if(List.get(i)==List.get(j))
                    f++;
            }
            if(f==List.size()/2)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        Node root=new Node(1);
        
        System.out.println(SymmetricTree(root));
        Node.Print_Tree(root);
    }
}
