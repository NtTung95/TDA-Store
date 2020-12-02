package Model;

public class Product {
    private int productId;
    private int categoryId;
    private int quantity;
    private double price;
    private String description;
    private String productName;
    private String imgMain;
    private String img1;
    private String img2;
    private String img3;
    private String img4;
    private int Size_S;
    private int Size_M;
    private int Size_L;
    private int Size_XL;
    private int Size_XXL;

    public Product() {
    }

    public Product(int productId, int categoryId, int quantity, double price, String description, String productName, String imgMain, String img1, String img2, String img3, String img4, int size_S, int size_M, int size_L, int size_XL, int size_XXL) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.productName = productName;
        this.imgMain = imgMain;
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        Size_S = size_S;
        Size_M = size_M;
        Size_L = size_L;
        Size_XL = size_XL;
        Size_XXL = size_XXL;
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

    public String getImgMain() {
        return imgMain;
    }

    public String getImg1() {
        return img1;
    }

    public String getImg2() {
        return img2;
    }

    public String getImg3() {
        return img3;
    }

    public String getImg4() {
        return img4;
    }

    public int getSize_S() {
        return Size_S;
    }

    public int getSize_M() {
        return Size_M;
    }

    public int getSize_L() {
        return Size_L;
    }

    public int getSize_XL() {
        return Size_XL;
    }

    public int getSize_XXL() {
        return Size_XXL;
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

    public void setImgMain(String imgMain) {
        this.imgMain = imgMain;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public void setImg4(String img4) {
        this.img4 = img4;
    }

    public void setSize_S(int size_S) {
        Size_S = size_S;
    }

    public void setSize_M(int size_M) {
        Size_M = size_M;
    }

    public void setSize_L(int size_L) {
        Size_L = size_L;
    }

    public void setSize_XL(int size_XL) {
        Size_XL = size_XL;
    }

    public void setSize_XXL(int size_XXL) {
        Size_XXL = size_XXL;
    }
}
