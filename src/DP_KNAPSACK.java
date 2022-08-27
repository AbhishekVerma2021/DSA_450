//You are given 2 arrays of items  of their weight wt[] and a value array val[] and a max Weight a bag can hold
//You have to find the maximum value of the items that can be put into the bag such that the value sum up maximum.
package DSA_450.src;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DP_KNAPSACK
{
    //RECURSIVE SOLUTION
    public static int knapSack_Recursion(int wt[],int val[],int w,int n)
    {
        if(n==0||w==0)
            return 0;
        if(wt[n-1]<=w)
            return Math.max(val[n-1]+knapSack_Recursion(wt,val,w-wt[n-1],n-1),knapSack_Recursion(wt,val,w,n-1));
        return knapSack_Recursion(wt,val,w,n-1);
    }
    //MEMOIZED SOLUTION
    static int t[][];
    public static  void knapSack_Memoize(int wt[],int val[],int w,int n)
    {
       t=new int[n+1][w+1];
       for(int i[]:t)
           Arrays.fill(i,-1);
       System.out.println(knapSack_Memoize_Cal(wt,val,w,n));
    }
    public static int knapSack_Memoize_Cal(int wt[],int val[],int w,int n)
    {
        if(n==0||w==0)
            return 0;
        if(t[n][w]!=-1)
            return t[n][w];
        if(wt[n-1]<=w)
            return t[n][w]=Math.max(val[n-1]+knapSack_Memoize_Cal(wt,val,w-wt[n-1],n-1),knapSack_Memoize_Cal(wt,val,w,n-1));
        return t[n][w]=knapSack_Memoize_Cal(wt,val,w,n-1);
    }

    //TOP_DOWN/TABULAR SOLUTION
    static int tt[][];
    public static void knapSack_TD(int wt[],int val[],int w,int n)
    {
        tt=new int[n+1][w+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<w+1;j++)
                if(i==0||j==0)
                    tt[i][j]=0;
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<w+1;j++)
            {
                if(wt[i-1]<=j)
                    tt[i][j]=Math.max(val[i-1]+tt[i-1][j-wt[i-1]],tt[i-1][j]);
                else
                    tt[i][j]=tt[i-1][j];
            }
        }
        System.out.println("TOP_DOWN SOLUTION : "+tt[n][w]);
    }
    public static void main(String[] args)
    {
       int wt[]={8,9,2,1,4};
       int val[]={7,2,5,6,4};
       int w=13;
       System.out.println("Recursive Solution : "+knapSack_Recursion(wt,val,w,wt.length));
       knapSack_Memoize(wt,val,w,wt.length);
       knapSack_TD(wt,val,w, wt.length);
    }
}
