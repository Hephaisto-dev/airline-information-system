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

    void setPrice(int price);

    int getBackendPrice();

}
