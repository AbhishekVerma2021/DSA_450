package DSA_450.src;

import java.util.Arrays;

public class DP_EqualSumPartition
{
    //RECURSIVE SOLUTION
    public static int euqalSum_Recursive(int[] arr,int n)
    {
        int sum=0;
        for(int i:arr)
            sum+=i;
        if(sum%2!=0)
            return 0;
        else
            return equalSumPart(arr,sum/2,n);
    }
    public static int equalSumPart(int arr[],int sum,int n)
    {
        if(sum==0)
            return 1;
        if(n==0)
            return 0;
        if(arr[n-1]<=sum)
            return equalSumPart(arr,sum-arr[n-1],n-1)|equalSumPart(arr,sum,n-1);
        return equalSumPart(arr,sum,n-1);
    }
    //MEMOIZED SOLUTION
    static int tm[][];
    public static int equalSum_Memoized(int[] arr,int n) {
        int sum = 0;
        for (int i : arr)
            sum += i;
        if (sum % 2 != 0)
            return 0;
        else
        {
            tm=new int[n+1][(sum/2)+1];
            for(int[] i:tm)
                Arrays.fill(i,-1);
            return equalSumPart_Mem(arr, sum / 2, n);
        }
    }
    public static int equalSumPart_Mem(int arr[],int sum,int n)
    {
        if(sum==0)
            return 1;
        if(n==0)
            return 0;
        if(tm[n][sum]!=-1)
            return tm[n][sum];
        if(arr[n-1]<=sum)
            return tm[n][sum]=equalSumPart_Mem(arr,sum-arr[n-1],n-1)|equalSumPart_Mem(arr,sum,n-1);
        return tm[n][sum]=equalSumPart_Mem(arr,sum,n-1);
    }
    //TOP_DOWN/TABULAR SOLUTION
    static int td[][];
    public static int euqalSum_TD(int []arr,int n)
    {
        int sum=0;
        for(int i:arr)
            sum+=i;
        if(sum%2!=0)
            return 0;
        sum/=2;
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
        for(int j=1;j<sum+1;j++)
        {
            if(arr[i-1]<=j)
                td[i][j]=td[i-1][j-arr[i-1]]|td[i-1][j];
            else
                td[i][j]=td[i-1][j];
        }
        return td[n][sum];
    }
    public static void main(String[] args) {
        int arr[]={1,5,3,10,2,1};
        System.out.print("RECURSIVE SOLUTION = ");
        if(euqalSum_Recursive(arr,arr.length)==1)
            System.out.println("YES");
        else
            System.out.println("NO");
        System.out.print("MEMOIZED SOLUTION = ");
        if(equalSum_Memoized(arr,arr.length)==1)
            System.out.println("YES");
        else
            System.out.println("NO");
        System.out.print("TOP_DOWN/TABULAR SOULTION = ");
        if(euqalSum_TD(arr,arr.length)==1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
