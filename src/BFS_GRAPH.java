package DSA_450.src;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Graph
{
    static int v;
    static LinkedList<Integer> adj[];
    Graph(int v)
    {
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++)
            adj[i]=new LinkedList<>();
    }
    public static void createGraph(int v,int c)
    {
        adj[v].add(c);
    }
    public static void BFS_Traversal(int s)
    {
        boolean visited[]=new boolean[v];
        visited[s]=true;
        Queue<Integer> qu=new LinkedList<>();
        qu.add(s);
        while (!qu.isEmpty())
        {
            int t=qu.poll();
            System.out.print(t);
            Iterator<Integer> i=adj[t].listIterator();
            while(i.hasNext())
            {
                int n=i.next();
                if(!visited[n])
                {
                    visited[n]=true;
                    qu.add(n);
                }
            }
        }
    }
}


public class BFS_GRAPH
{

    public static void main(String[] args)
    {
        Graph gobj=new Graph(4);
        gobj.createGraph(0,1);
        gobj.createGraph(0,2);
        gobj.createGraph(1,2);
        gobj.createGraph(2,0);
        gobj.createGraph(2,3);
        gobj.createGraph(3,3);
        gobj.BFS_Traversal(2);
    }
}
