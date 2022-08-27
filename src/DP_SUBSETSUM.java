package DSA_450.src;

import java.util.Arrays;

public class DP_SUBSETSUM
{
    public static Boolean subsetSum_Recursive(int[] arr,int sum,int n)
    {
        if(sum==0)
            return true;
        if(n==0)
            return false;
        if(arr[n-1]<=sum)
            return subsetSum_Recursive(arr,sum-arr[n-1],n-1)||subsetSum_Recursive(arr,sum,n-1);
        return subsetSum_Recursive(arr,sum,n-1);
    }
    //MEMOIZED SOLUTION
    static int tm[][];
    public static Boolean subsetSum_Memoize(int[] arr,int sum,int n)
    {
        tm=new int[n+1][sum+1];
        for(int[] i:tm)
            Arrays.fill(i,-1);
        return subsetSum_Memoize_Cal(arr,sum,n)==1;
    }
    public static int subsetSum_Memoize_Cal(int[] arr,int sum,int n)
    {
        if(sum==0)
            return tm[n][sum]=1;
        if(n==0)
            return tm[n][sum]=0;

        if(tm[n][sum]!=-1)
            return tm[n][sum];
        if(sum>=arr[n-1])
            return tm[n][sum]=subsetSum_Memoize_Cal(arr,sum-arr[n-1],n-1)|subsetSum_Memoize_Cal(arr,sum,n-1);
        return subsetSum_Memoize_Cal(arr,sum,n-1);
    }
    //TOPDOWN SOLUTION
    static int td[][];
    public static Boolean subsetSum_TD(int[] arr,int sum,int n)
    {
        td=new int[n+1][sum+1];
        for(int i=0;i<n+1;i++)
            for(int j=0;j<sum+1;j++)
            {
                if(j==0)
                    td[i][j]=1;
                if(i==0)
                    td[i][j]=0;
            }
        for(int i=1;i<n+1;i++)
        {
            for(int j=1;j<sum+1;j++)
            {
                td[i][j]=td[i-1][j];
                if(arr[i-1]<=j)
                    td[i][j]=td[i-1][j-arr[i-1]]|td[i-1][j];

            }
        }
        return td[n][sum]==1;
    }
    public static void main(String[] args)
    {
        int arr[]={1,0,1,3,0,9};
        int n=arr.length;
        int sum=10;
        System.out.println("RECURSIVE SOLUTION = "+subsetSum_Recursive(arr,sum,n));
        System.out.println("MEMOIZED SOLUTION = "+subsetSum_Memoize(arr,sum,n));
        System.out.println("TOP-DOWN/TABULAR SOLUTION = "+subsetSum_TD(arr,sum,n));
    }
}
