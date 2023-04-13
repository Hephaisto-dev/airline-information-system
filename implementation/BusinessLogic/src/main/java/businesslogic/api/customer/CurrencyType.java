package businesslogic.api.customer;

import java.util.Currency;

public enum CurrencyType {
    EURO(Currency.getInstance("EUR")),
    DOLLAR(Currency.getInstance("USD"));

    private final Currency currency;

    CurrencyType(Currency currency) {
        this.currency = currency;
    }


    @Override
    public String toString(){
        return currency.getSymbol();
    }

    public CurrencyType getCurrencyType(String ISO_Code){
        switch(ISO_Code){
            case("EUR"):
                return CurrencyType.EURO;
            case("USD"):
                return CurrencyType.DOLLAR;
        }
        return null;
    }

    public Currency getCurrency() {
        return currency;
    }
}
