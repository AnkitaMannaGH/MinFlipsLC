class Solution {
    public int numberOfWays(String corridor) {
        int count =0;
        int sfc = 0;
        int pc = 0;//plant count
        boolean atleastTwoSeats = false;
        List<Integer> list = new ArrayList<>();
        for(char c: corridor.toCharArray()){
            if(c=='S'){
                sfc++;
                if(count==2){
                    count = count%2;
                    list.add(pc);
                    pc =0;
                }
                count++;
                
            }else{
            if(count==2)
            pc++;    
            }
            if(count ==2)
                atleastTwoSeats =true;
        }
        if(sfc%2==1)
            return 0;//if odd number of sofas
                
        int n = list.size(); 
        long result = 1;
        for(int val : list){
            result = (result*((val+1)%1000000007))%1000000007;
        }
        return (int)((n==0)?0+(atleastTwoSeats?1:0):result%1000000007); 
    }
}