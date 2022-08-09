package DSA_450.src;

import java.util.Scanner;

public class BTfromArray
{

    int h;
    static String[] str;
    BTfromArray(int he)
    {
        h = he;
        str=new String[h];
        System.out.println(str.length);
    }
    public static void Root(String st)
    {
        str[1]=st;
    }
    public static void LeftChild(String st,int parent)
    {

        int index=2*parent;
        if(str[parent]==null)
        {
            System.out.println("No PARENT!!! of"+index);
        }
        else
        {
            str[index]=st;
        }
    }
    public static void RighChild(String st,int parent)
    {
        int index=2*parent+1;
        if(str[parent]==null)
        {
            System.out.println("No PARENT!!! of "+ index);
        }
        else
        {
            str[index]=st;
        }
    }

    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("ENTER HEIGHT");
        BTfromArray obj=new BTfromArray(sc.nextInt());


        Root("A");
        LeftChild("B",1);
        LeftChild("D",2);
        LeftChild("E",3);//No Parent Error
        RighChild("F",1);
        LeftChild("G",3);

        for (String s :str) {
            System.out.print(s+"  ");
        }
    }
}
