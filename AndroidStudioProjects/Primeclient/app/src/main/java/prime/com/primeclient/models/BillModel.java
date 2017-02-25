package prime.com.primeclient.models;

import java.util.List;

/**
 * Created by BrahmaRishi on 07/02/17.
 */

public class BillModel {
    int invoiceNumber;
    SupplierModel supplier;
    CustomerModel customer;
    List<PosListItemModel> list;
    List<TaxModel> taxes;
    double TOTAL;
//    String terms_of_payment;
//    String Customer_Purchase_Order_Number;


    public int getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(int invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public SupplierModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierModel supplier) {
        this.supplier = supplier;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerModel customer) {
        this.customer = customer;
    }

    public List<PosListItemModel> getList() {
        return list;
    }

    public void setList(List<PosListItemModel> list) {
        this.list = list;
    }

    public List<TaxModel> getTaxes() {
        return taxes;
    }

    public void setTaxes(List<TaxModel> taxes) {
        this.taxes = taxes;
    }

    public double getTOTAL() {
        return TOTAL;
    }

    public void setTOTAL(double TOTAL) {
        this.TOTAL = TOTAL;
    }
}
