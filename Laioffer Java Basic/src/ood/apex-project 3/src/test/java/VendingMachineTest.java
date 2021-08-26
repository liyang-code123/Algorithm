import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class VendingMachineTest {
    VendingMachine vm;

    @Before
    public void setUp() throws Exception {
        vm = new VendingMachine();
    }

    @Test
    public void selectItemGetPrice_succeed() throws SoldOutException{
        Item item = Item.COKE;
        int res = vm.selectItemGetPrice(item);

        assertEquals(24, res);
    }

    @Test
    public void selectItemGetPrice_failed() throws SoldOutException{
        Item item = Item.COKE;
        int res = vm.selectItemGetPrice(item);

        assertNotEquals(26, res);
    }

    @Test(expected = SoldOutException.class)
    public void selectItemGetPrice_soldOutException() throws SoldOutException {
        Item item = Item.COKE;
        Coin coin = Coin.QUARTER;
        vm.setItemInventory(Item.COKE, 0);
        vm.selectItemGetPrice(item);
    }

    @Test
    public void insertCoin_oneCoin() {
        Coin coin = Coin.QUARTER;
        int res = vm.insertCoin(coin);

        assertEquals(25, res);
    }

    @Test
    public void insertCoin_multipleSameCoins() {
        Coin coin = Coin.QUARTER;
        int res = vm.insertCoin(coin);
        res = vm.insertCoin(coin);

        assertEquals(50, res);
    }

    @Test
    public void insertCoin_multipleCoins() {
        Coin coinQ = Coin.QUARTER;
        Coin coinD = Coin.DIME;
        vm.insertCoin(coinQ);
        int res = vm.insertCoin(coinD);

        assertEquals(35, res);
    }

    @Test
    public void setInventory_succeed() {
        Item item = Item.SODA;
        int quantity = 10;
        vm.setItemInventory(item, quantity);

        int res = vm.getItemInventory(Item.SODA);

        assertEquals(10, res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setInventory_failed() {
        Item item = Item.SODA;
        int quantity = -1;
        vm.setItemInventory(item, quantity);
    }

    @Test(expected = NotFullyPaidException.class)
    public void collectItemAndChange_notFullyPaidException() throws NotSufficientCoinException, NotFullyPaidException, SoldOutException {
        Item item = Item.SODA;
        Coin coin = Coin.QUARTER;
        vm.selectItemGetPrice(item);
        vm.insertCoin(coin);
        vm.insertCoin(coin);
        vm.collectItemAndChange();
    }

    @Test(expected = NotSufficientCoinException.class)
    public void collectItemAndChange_notSufficientCoinException() throws NotSufficientCoinException, NotFullyPaidException, SoldOutException {
        Item item = Item.COKE;
        Coin coin = Coin.QUARTER;
        vm.selectItemGetPrice(item);
        vm.insertCoin(coin);
        vm.setCashInventory(Coin.PENNY, 0);
        vm.collectItemAndChange();
    }
}