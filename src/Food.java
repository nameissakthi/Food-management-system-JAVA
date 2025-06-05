import java.util.ArrayList;

abstract class Food {
    public void makeFood(){}

    public ArrayList<Item> getFood(){ return null; }

    public void display(){}

    public int priceOfFood(int id){ return -1; }

    public Item getFood(int id){ return null; }

    public void addFood(Item item){}

    public int getLastFoodId(){ return -1; }
}
