package Model;

public class orderDetail {
    private String orderId;
    private String productId;
    private String quantity;

    public orderDetail() {
    }

    public orderDetail(String orderId, String productId, String quantity) {
        this.orderId = orderId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getProductId() {
        return productId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
