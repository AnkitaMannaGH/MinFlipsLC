class Solution {
    public String firstPalindrome(String[] words)
    {
        for(String word : words)
        {
            if(!isPalin(word))
                continue;
            else
                return word;
        }
        return "";
    }
    private boolean isPalin(String word)
    {
        int N = word.length();
        for(int i = 0; i < N; i++)
        {
            if(word.charAt(i) == word.charAt(N-i-1))
                continue;
            else
                return false;
        }
        return true;
    }
}