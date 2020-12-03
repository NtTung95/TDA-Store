package Model;

public class HistoryOrders {
    private int idOrder, customerId, quantity;
    private String productName,dateOrdered;
    private int price;

    public HistoryOrders(int idOrder, int customerId, int quantity, String productName, String dateOrdered, int price) {

        this.idOrder = idOrder;
        this.customerId = customerId;
        this.quantity = quantity;
        this.productName = productName;
        this.dateOrdered = dateOrdered;
        this.price = price;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
