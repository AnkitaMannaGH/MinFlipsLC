class Solution {
    public boolean even(int n)
{
    return  ((n&1)!=1);
}
    public int minFlips(int a, int b, int c) {
      int count=0;
   while((a|b) != c)
   {
       if(even(c))
       {
           if(!even(a) && !even(b))
           count+=2;
           else if(!even(a) || !even(b))
           count++;
       }
       else
       {
           if(even(a) && even(b))
           count+=1;
       }
       a=a>>1;
       b=b>>1;
       c=c>>1;
   } 
   return count;
}  
}

