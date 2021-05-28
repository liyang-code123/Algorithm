package algorithm2;

// problem 1:
public class BestTimeToBuyAndSellStock {
    public int bestTime (int[] array) {
        if (array == null || array.length == 0) return 0;

        int min = array[0];
        int indexBuy, indexSell = 0;
        int profit = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                indexBuy = i;
                System.out.println(i);
            } else {
                profit = Math.max(profit, array[i] - min);
                indexSell = i;
                System.out.println(i);
            }
        }
        return profit;
    }

    public static void main (String[] args) {
        BestTimeToBuyAndSellStock test = new BestTimeToBuyAndSellStock();
        int[] array = {1, 3, 5, 1, 5, 8, 9};
        System.out.println(test.bestTime(array));
    }
}
