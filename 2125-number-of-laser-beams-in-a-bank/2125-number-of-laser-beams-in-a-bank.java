class Solution {
     public int numberOfBeams(String[] bank) {
        int prevCount = 0, beams = 0;
        for (String lasers : bank) {
            int currCount = getTotalLasers(lasers);
            if (currCount == 0) continue;
            beams += (prevCount * currCount);
            prevCount = currCount;
        }
        
        return beams;
    }
    
    private int getTotalLasers(final String str) {
        int count = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '1') count++;
        }
        return count;
    }
}