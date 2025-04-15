import java.util.ArrayList;

public class Lunch extends Food {
    private ArrayList<Item> lunch = new ArrayList<Item>();
    private final int[] id = { 1, 2, 3, 4, 5 };
    private final String[] names = {"Poratta", "Chappathi", "Meals", "Biriyani", "Fried Rice"};
    private final int[] prices = {15, 15, 60, 80, 60};

    public void makeFood(){
        for(int i=0;i<names.length;i++){
            lunch.add(new Item(id[i], names[i], prices[i]));
        }
    }

    public ArrayList<Item> getFood(){
        return lunch;
    }

    public int priceOfFood(int id){
        for(Item item : lunch)
            if(item.getId() == id)
                return item.getPrice();
        return -1;
    }

    public void display(){
        for(Item item : lunch){
            System.out.println(item.getId()+"."+item.getName()+" = "+item.getPrice());
        }
    }

    public Item getFood(int id){
        for(Item item : lunch)
            if(item.getId()==id)
                return item;
        return null;
    }
}
