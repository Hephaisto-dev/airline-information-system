package businesslogic.api.customer;



public class PriceImpl implements Price{

    private int amount;
    private CurrencyType currency;

    public PriceImpl(int money){
        this.amount = money;
        this.currency = CurrencyType.EURO;//Euro as basic, bc we are in Europe
    }

    public PriceImpl(int money, CurrencyType Currency){
        this.amount = money;
        this.currency = Currency;
    }

    @Override
    public void applyDiscount(int reduceBy) {
        if(reduceBy <= amount && reduceBy > 0){
            amount -= reduceBy;
        }
    }

    @Override
    public void applyVoucher(int percentage) {
        if(percentage < 100 && percentage > 0){
            this.amount -= ((double)amount/100) * percentage;
        }
    }

    @Override
    public void chooseCurrency(String ISO_Code) {
        this.currency = currency.getCurrencyType(ISO_Code);
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
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(amount/100)
                .append(',')
                .append((amount%100))
                .append(currency.toString())
                .toString();
    }

    @Override
    public String getCurrencySymbol(){
        return currency.getCurrency().getSymbol();
    }
}
