class StockSpanner {
     Stack<Integer> prices, heights;
    public StockSpanner() {
        prices = new Stack();
        heights = new Stack();
        
    }
    
    public int next(int price) {
        int w = 1;
        while (!prices.isEmpty() && prices.peek() <= price) {
            prices.pop();
            w += heights.pop();
        }

        prices.push(price);
        heights.push(w);
        return w;    
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */