package prime.com.primeclient.models.pos;

import java.util.ArrayList;

/**
 * Created by BrahmaRishi on 07/02/17.
 */

public class BillModel {
    ArrayList<PosListItemModel> list;
    ArrayList<TaxModel> taxes;
    Customer customer;
    Supplier supplier;
    int INVOICE_REFERANCE_NUMBER;
    int total;
    String terms_of_payment;
    String Customer_Purchase_Order_Number;

}
