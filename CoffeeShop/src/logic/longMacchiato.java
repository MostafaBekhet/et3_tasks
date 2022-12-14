package logic;

public class longMacchiato implements IBeverage{

    private int id;
    private String name;
    private int price;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCost() {
        return this.price;
    }

    public String getInfo() {
        return id + " " + name + " " + price;
    }
}
