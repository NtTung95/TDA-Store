package Model;

public class Category {
    private int categoryId;
    private String nameCategory;
    private String Img_Category;

    public Category() {
    }

    public Category(int categoryId, String nameCategory, String img_Category) {
        this.categoryId = categoryId;
        this.nameCategory = nameCategory;
        Img_Category = img_Category;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public String getImg_Category() {
        return Img_Category;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public void setImg_Category(String img_Category) {
        Img_Category = img_Category;
    }
}
