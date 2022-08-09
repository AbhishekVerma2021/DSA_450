package DSA_450.src;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int arithmeticTriplets(int[] nums, int diff)
    {
        int s=nums.length,f=0;
        for(int i=0;i<s-3+1;i++)
        {
            int n=0,x=0;
            for(int j=i+1;j<s-1;j++)
            {
                if(nums[j]-nums[i]==diff)
                {
                    n=j;
                    x++;
                    break;
                }
            }
            if(x>0)
            {
                for(int j=n;j<s;j++)
                {
                    if(nums[j]-nums[n]==diff)
                    {
                        f++;
                    }
                }
                x=0;
            }
        }
        return f;
    }
    public static void main(String args[])
    {
        int arr[]=new int[]{1,2,3,5,7,9};
        System.out.println(arithmeticTriplets(arr,2));
    }
}
