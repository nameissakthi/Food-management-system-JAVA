import java.util.ArrayList;

class CartItem{
    private int foodId;
    private int quantity;
    private Food food;
    private int sideDishId;
    private int sideDishQuantity;
    private Sidedish sidedish;

    CartItem(int foodId, int quantity, Food food, int sideDishId, int sideDishQuantity, Sidedish sidedish){
        this.foodId = foodId;
        this.quantity = quantity;
        this.food = food;
        this.sideDishId = sideDishId;
        this.sideDishQuantity = sideDishQuantity;
        this.sidedish = sidedish;
    }

    public int getFoodId(){
        return this.foodId;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public Food getFood(){
        return this.food;
    }

    public int getSideDishId(){
        return this.sideDishId;
    }

    public int getSideDishQuantity() {
        return sideDishQuantity;
    }

    public Sidedish getSidedish() {
        return sidedish;
    }
}

public class Cart {
    private ArrayList<CartItem> cart = new ArrayList<>();
    private int total = 0;

    public void addToCart(CartItem Item){
        cart.add(Item);
        calculateTotal();
    }

    private void calculateTotal(){
        for(CartItem Item : cart){
            this.total += (Item.getFood().priceOfFood(Item.getFoodId()))*Item.getQuantity();
            if(Item.getQuantity()>0 && Item.getSidedish().getFood(Item.getFoodId())!=null)
                this.total += (Item.getSidedish().priceOfFood(Item.getSideDishId()))*Item.getQuantity();
        }
    }

    public int getTotal(){
        return this.total;
    }

    public void displayCart(){
        for(CartItem Item : cart)
            System.out.println(Item.getFood().getFood(Item.getFoodId()).getName()+" x "+Item.getQuantity());
        for(CartItem Item : cart)
            if(Item.getQuantity()>0 && Item.getSidedish().getFood(Item.getFoodId())!=null)
                System.out.println(Item.getSidedish().getFood(Item.getFoodId()).getName()+" x "+Item.getQuantity());
    }

    public void clearCart(){
        cart.clear();
    }
}
