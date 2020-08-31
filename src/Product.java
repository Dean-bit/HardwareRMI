public class Product implements java.io.Serializable {
    private int id;
    private String name;
    private String quantity;

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getQuantity(){
        return  quantity;
    }

    public void setID(int id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }
}
