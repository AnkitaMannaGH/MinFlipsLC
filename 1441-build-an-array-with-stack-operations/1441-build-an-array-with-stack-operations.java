class Solution {
    public List<String> buildArray(int[] target, int n) {
        LinkedList<String> res = new LinkedList<>();
        int i = 1;
        for (int num : target) {
            while(i < num && i < n) {
                ++i;
                res.add("Push");
                res.add("Pop");
            }
            ++i;
            res.add("Push");
        }
        return res;
    }
}