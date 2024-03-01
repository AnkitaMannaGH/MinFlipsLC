class Solution {
    public String maximumOddBinaryNumber(String s) {
        char[] arr = s.toCharArray();
        int count = -1;
        int i;
        for(i=0;i<arr.length;i++){
            if(arr[i]=='1') count++;
            arr[i] = '0';
        }
        i=0;
        while(count>0 && i<arr.length){
            arr[i] = '1';
            count--;
            i++;
        }
        arr[arr.length-1] = '1';
        return new String(arr);
    }
}