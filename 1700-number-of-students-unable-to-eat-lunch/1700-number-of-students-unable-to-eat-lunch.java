class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        int[] type = new int[2];
        int len = students.length;
        for (int i: students) 
            type[i]++;
        for (int i=0;i<len;i++) 
            if (--type[sandwiches[i]] < 0) 
                return len - i;
        return 0;
    }
}