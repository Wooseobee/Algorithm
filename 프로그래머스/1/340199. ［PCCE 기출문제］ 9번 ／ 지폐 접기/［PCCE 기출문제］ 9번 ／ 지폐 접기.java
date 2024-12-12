class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int walletLow = Math.min(wallet[0], wallet[1]);
        int walletHigh = Math.max(wallet[0], wallet[1]);
        
        int billLow = Math.min(bill[0], bill[1]);
        int billHigh = Math.max(bill[0], bill[1]);
        
        while(billLow > walletLow || billHigh > walletHigh) {
            if(bill[0] > bill[1]) {
                bill[0] /= 2;
            } else {
                bill[1] /= 2;
            }
            billLow = Math.min(bill[0], bill[1]);
            billHigh = Math.max(bill[0], bill[1]);
            answer++;
        }
        return answer;
    }
}