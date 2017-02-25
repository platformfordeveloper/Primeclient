package prime.com.primeclient.models;

/**
 * Created by BrahmaRishi on 10/02/17.
 */

public class ProductModel {
    String productName;
    String productCode;
    int minBillQty;
    float cost;
    CustomerModel customer;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public int getMinBillQty() {
        return minBillQty;
    }

    public void setMinBillQty(int minBillQty) {
        this.minBillQty = minBillQty;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }
}
