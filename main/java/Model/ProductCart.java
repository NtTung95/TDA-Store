package Model;

public class ProductCart {
    private int productId;
    private int categoryId;
    private int quantity;
    private double price;
    private String description;
    private String productName;
    private int amoutSelect;
    private String sizeSelect;
    private String ImgMain;

    public ProductCart() {
    }


    public ProductCart(int productId, int categoryId, int quantity, double price, String description, String productName, String imgMain, String img1, String img2, String img3, String img4, int size_S, int size_M, int size_L, int size_XL, int size_XXL) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.productName = productName;
    }

    public int getProductId() {
        return productId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    public String getProductName() {
        return productName;
    }

    public int getAmoutSelect() {
        return amoutSelect;
    }

    public String getSizeSelect() {
        return sizeSelect;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAmoutSelect(int amoutSelect) {
        this.amoutSelect = amoutSelect;
    }

    public void setSizeSelect(String sizeSelect) {
        this.sizeSelect = sizeSelect;
    }

    public String getImgMain() {
        return ImgMain;
    }

    public void setImgMain(String setImgMain) {
        this.ImgMain = setImgMain;
    }
}
