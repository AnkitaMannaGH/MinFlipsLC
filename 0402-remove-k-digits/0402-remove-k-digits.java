class Solution {
    public String removeKdigits(String num, int k){
        if(num==null || num.length()<=k){
            return "0";
        }
        int toBeRm = k;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<num.length() && toBeRm>0;i++){
            while(toBeRm>0 && !stack.isEmpty() && num.charAt(i)<num.charAt(stack.peek())){
                    int r = stack.pop();
                    toBeRm--;
            }
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        for(int index : stack){
            if(i>=num.length()-k)
                break;
            sb.append(num.charAt(index));
            i++;
        }
        if(stack.size()<num.length()-k){
            sb.append(num.substring(k+stack.size()));
        }
        String res = sb.toString();
        return trimLeadingZero(res);
    }
    private String trimLeadingZero(String num){
        for(int i=0;i<num.length();i++){
            if(num.charAt(i)!='0'){
                return num.substring(i);
            }
        }
        return "0";
    }
}