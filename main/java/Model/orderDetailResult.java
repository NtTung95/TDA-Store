package Model;

public class orderDetailResult {
    private String customerID;
    private String orderId;
    private String productName;
    private String price;
    private String quantity;
    private String dateOrdered;

    public orderDetailResult() {
    }

    public orderDetailResult(String customerID, String orderId, String productName, String price, String quantity, String dateOrdered) {
        this.customerID = customerID;
        this.orderId = orderId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.dateOrdered = dateOrdered;
    }

    public String getCustomerID() {
        return customerID;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductName() {
        return productName;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }
}
