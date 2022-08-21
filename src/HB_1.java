//
//
//Luke Skywalker gave Chewbacca an integer number x. Chewbacca isn't good at numbers but he loves inverting digits in them. Inverting digit t means replacing it with digit 9 - t.
//
//        Help Chewbacca to transform the initial number x to the minimum possible positive number by inverting some (possibly, zero) digits. The decimal representation of the final number shouldn't start with a zero.
//        Input Format
//
//        The first line contains a single integer x (1 ≤ x ≤ 10^18) — the number that Luke Skywalker gave to Chewbacca.
//        Constraints
//
//        x <= 100000000000000000
//        Output Format
//
//        Print the minimum possible positive number that Chewbacca can obtain after inverting some digits. The number shouldn't contain leading zeroes.
//        Sample Input
//
//        4545
//
//        Sample Output
//
//        4444
//
//        Explanation
//
//        There are many numbers form after inverting the digit. For minimum number, check if inverting digit is less than or greater than the original digit. If it is less, then invert it otherwise leave it.

package DSA_450.src;

import java.util.Scanner;

public class HB_1
{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),res=0,p=0;
        while(n!=0)
        {
            int rem=n%10;
            if(rem>4)
                rem=9-rem;
            if(n/10==0&&rem==0)
                rem=9;
            res+=Math.pow(10,p)*rem;
            p++;
            n/=10;
        }
        System.out.print(res);
    }
}
