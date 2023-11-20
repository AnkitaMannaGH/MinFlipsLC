class Solution {
        public int garbageCollection(String[] garbage, int[] travel) {
        
        return count(garbage,'M',travel) + count(garbage,'P',travel) + count(garbage,'G',travel) ;
    }
    public int count(String[] a,char c,int[] t)
    {
        int n =0,l=a.length,s=0;
        for(int i=0;i<l;i++)
        {
            String w = a[i];
            for(int j=0;j<w.length();j++)
            {
                if(w.charAt(j)==c)
                {
                    n++;s=i;
                }
            }
        }
        for(int i=0;i<s;i++)
        {
            n+= t[i];
        }
        return n;
    }
}