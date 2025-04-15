import java.util.ArrayList;

public class Sidedish extends Food {
    private ArrayList<Item> sidedish = new ArrayList<Item>();
    private final int[] id = { 1, 2, 3, 4 };
    private final String[] names = { "Omelette", "Half Boil", "Full Boil", "Kalakki" };
    private final int[] prices = {15, 15, 15, 15};

    public void makeFood(){
        for(int i=0;i<names.length;i++){
            sidedish.add(new Item(id[i], names[i], prices[i]));
        }
    }

    public ArrayList<Item> getFood(){
        return sidedish;
    }

    public int priceOfFood(int id){
        for(Item item : sidedish)
            if(item.getId() == id)
                return item.getPrice();
        return -1;
    }

    public void display(){
        for(Item item : sidedish){
            System.out.println(item.getId()+"."+item.getName()+" = "+item.getPrice());
        }
    }

    public Item getFood(int id){
        for(Item item : sidedish)
            if (item.getId()==id)
                return item;
        return null;
    }
}
