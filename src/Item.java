public class Item{
    private int id;
    private String name;
    private int price;
    Item(int id, String name, int price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId(){
        return this.id;
    }

    public void display(){
        System.out.println(this.id+"."+this.name+" = "+this.price);
    }
}