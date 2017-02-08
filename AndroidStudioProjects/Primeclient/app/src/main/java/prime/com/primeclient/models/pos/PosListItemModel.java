package prime.com.primeclient.models.pos;

import android.util.Log;


/**
 * Created by BrahmaRishi on 02/02/17.
 */

public class PosListItemModel {
    private String productName;
    private double rate;
    private double qty;
    private String taxName;
    TaxModel tax;
    private double price;

    public PosListItemModel(String productName, double qty, double rate, TaxModel tax, String taxName) {
        this.productName = productName;
        this.qty = qty;
        this.rate = rate;
        this.tax = tax;
        this.taxName = taxName;
    }

    public String getTaxName() {
        return taxName;
    }

    public void setTaxName(String taxName) {
        this.taxName = taxName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(double qty) {
        this.qty = qty;
    }

    public TaxModel getTax() {
        return tax;
    }

    public void setTax(TaxModel tax) {
        this.tax = tax;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
