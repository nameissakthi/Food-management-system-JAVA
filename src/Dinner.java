import java.util.ArrayList;

public class Dinner extends Food {
    private ArrayList<Item> dinner = new ArrayList<Item>();
    private final int[] id = { 1, 2, 3 };
    private final String[] names = {"Idly", "Dosa", "Chappathi"};
    private final int[] prices = {10, 15, 15};

    public void makeFood(){
        for(int i=0;i<names.length;i++){
            dinner.add(new Item(id[i], names[i], prices[i]));
        }
    }

    public ArrayList<Item> getFood(){
        return dinner;
    }

    public int priceOfFood(int id){
        for(Item item : dinner)
            if(item.getId() == id)
                return item.getPrice();
        return -1;
    }

    public void display(){
        for(Item item : dinner){
            System.out.println(item.getId()+"."+item.getName()+" = "+item.getPrice());
        }
    }

    public Item getFood(int id){
        for(Item item : dinner)
            if(item.getId()==id)
                return item;
        return null;
    }
}
