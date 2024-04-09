class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
      int count = 0,i = 0;
        while(tickets[k] > 0){
            for(int j=0; j<tickets.length; j++){
                if(tickets[j] > 0){
                    tickets[j] -= 1;
                    count++;
                }
                if(tickets[k] == 0){
                    break;
                }
            }
            i++;
        }
        return count;  
    }
}