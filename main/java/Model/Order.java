package Model;

public class Order {
    private String orderId;
    private String CustomerId;
    private String dateOrdered;
    private String Status;

    public Order() {
    }

    public Order(String orderId, String customerId, String dateOrdered, String status) {
        this.orderId = orderId;
        CustomerId = customerId;
        this.dateOrdered = dateOrdered;
        Status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerId() {
        return CustomerId;
    }

    public String getDateOrdered() {
        return dateOrdered;
    }

    public String getStatus() {
        return Status;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        CustomerId = customerId;
    }

    public void setDateOrdered(String dateOrdered) {
        this.dateOrdered = dateOrdered;
    }

    public void setStatus(String status) {
        Status = status;
    }
}

