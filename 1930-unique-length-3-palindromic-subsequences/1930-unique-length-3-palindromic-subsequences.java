class Solution {
    public int countPalindromicSubsequence(String s) {
        int min[]=new int[26];
        int max[]=new int[26];
        for(int i=0;i<s.length();i++) max[s.charAt(i)-97]=i;
        for(int i=s.length()-1;i>=0;i--) min[s.charAt(i)-97]=i;
        HashSet<Character> set=new HashSet<>();
        int result=0;
        for(int i=0;i<26;i++){
                for(int j=min[i]+1;j<max[i];j++)
                    set.add(s.charAt(j));
                result+=set.size();
                set.clear();
        }
        return result;
    }
}