package businesslogic.api.customer;


public class PriceImpl implements Price {

    private int amount;

    public PriceImpl(int money) {
        this.amount = money;
        //Currency will always be Euro because we are from Europe
    }


    @Override
    public void applyDiscount(int reduceBy) {
        if (reduceBy <= amount && reduceBy > 0) {
            amount -= reduceBy;
        }
    }

    @Override
    public void applyVoucher(int percentage) {
        if (percentage < 100 && percentage > 0) {
            this.amount -= ((double) amount / 100) * percentage;
        }
    }


    @Override
    public void setPrice(int price) {
        this.amount = price;
    }

    @Override
    public int getBackendPrice() {
        return amount;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(amount / 100)
                .append(',')
                .append((amount % 100))
                .append(CurrencyType.EURO.toString())
                .toString();
    }
}
