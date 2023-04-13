package businesslogic.api.customer;

public interface Price {
    /**
     * Discount is the amount by which it is reduced
     */
    void applyDiscount(int amount);
    /**
     * Voucher is a percentage reduction
     */
    void applyVoucher(int percentage);
    /**
     * Choose the currency
     */
    void chooseCurrency(String currency);

    void setPrice(int price);

    int getBackendPrice();

    String getCurrencySymbol();
}
