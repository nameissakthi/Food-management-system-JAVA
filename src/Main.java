import java.time.LocalTime;
import java.util.Scanner;

class Admin{
    private String username = "sakthivel";
    private String password = "123456789";
    Scanner sc = new Scanner(System.in);
    Food Breakfast, Lunch, Dinner, Sidedish;

    public Admin(Food Breakfast, Food Lunch, Food Dinner, Food Sidedish){
        this.Breakfast = Breakfast;
        this.Lunch = Lunch;
        this.Dinner = Dinner;
        this.Sidedish = Sidedish;

        if(Breakfast.getFood().isEmpty())
            Breakfast.makeFood();
        if(Lunch.getFood().isEmpty())
            Lunch.makeFood();
        if(Dinner.getFood().isEmpty())
            Dinner.makeFood();
        if(Sidedish.getFood().isEmpty())
            Sidedish.makeFood();
    }

    public void checkCredential(){
        System.out.print("\nEnter username : ");
        String username = sc.nextLine();
        System.out.print("Enter password : ");
        String password = sc.nextLine();

        if(username.isEmpty() || password.isEmpty())
            System.out.println("Every Field is Required");

        if(!(username.equals(this.username) && password.equals(this.password))){
            System.out.println("Wrong Credential");
            return;
        }

        System.out.println("Successfully Login as Admin");
        options();
    }

    private void changePassword(){
        System.out.println("Enter New Password : ");
        String password = sc.nextLine();

        if(password.equals(this.password))
            System.out.println("Old Password can't be new Password");
        else if(password.isEmpty())
            System.out.println("Password can't be Empty");
        else{
            this.password = password;
            System.out.println("Password Changed Successfully!!!!!!");
        }
    }

    private void changeUsername(){
        System.out.println("Enter New Username : ");
        String username = sc.nextLine();

        if(username.equals(this.username))
            System.out.println("Old Username can't be new Username");
        else if(username.isEmpty())
            System.out.println("Username can't be Empty");
        else{
            this.username = username;
            System.out.println("Username Changed Successfully!!!!!!");
        }
    }

    public void listItems(){
        System.out.println("The List Item We Serve in our Hotel");
        System.out.println("For Breakfast : ");
        Breakfast.display();
        System.out.println("For Lunch : ");
        Lunch.display();
        System.out.println("For Dinner : ");
        Dinner.display();
        System.out.println("For Side Dish : ");
        Sidedish.display();
    }

    public void addFood(){
        String name;
        int price;
        System.out.println("ADD FOOD ITEM");
        System.out.println("-------------");
        System.out.println("1. Breakfast");
        System.out.println("2. Lunch");
        System.out.println("3. Dinner");
        System.out.print("Enter Your Choice : ");
        int choice = sc.nextInt();
        switch (choice){
            case 1:
                System.out.println("-----Add Breakfast-----");
                System.out.print("\nEnter the name of Breakfast : ");
                name = sc.next();
                System.out.print("\nEnter the price of the Food : ");
                price = sc.nextInt();
                Breakfast.addFood(new Item(Breakfast.getLastFoodId(), name, price));
                break;
            case 2:
                System.out.println("-----Add Lunch-----");
                System.out.print("\nEnter the name of Food : ");
                name = sc.next();
                System.out.print("\nEnter the price of the Food : ");
                price = sc.nextInt();
                Lunch.addFood(new Item(Breakfast.getLastFoodId(), name, price));
                break;
            case 3:
                System.out.println("-----Add Dinner-----");
                System.out.print("\nEnter the name of food : ");
                name = sc.next();
                System.out.print("\nEnter the price of the Food : ");
                price = sc.nextInt();
                Dinner.addFood(new Item(Breakfast.getLastFoodId(), name, price));
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }

    private void options(){
        System.out.println("------Admins Options------");
        System.out.println("""
                1. Add Food
                2. Change Password
                3. Change Username
                4. List Food Items
                """);
        System.out.print("Enter Your Choice : ");
        switch (sc.nextInt()){
            case 1:
                addFood();
                break;
            case 2:
                changePassword();
                break;
            case 3:
                changeUsername();
                break;
            case 4:
                listItems();
                break;
            default:
                System.out.println("Wrong Choice");
        }
    }
}

class Serving{
    Food food = null;
    Scanner sc = new Scanner(System.in);

    public int sideDish(Sidedish sideDish){
        if(sideDish.getFood().isEmpty())
            sideDish.makeFood();
        System.out.println("!!!Please Choose Your SideDish!!!");
        System.out.println("-----------------------------");
        sideDish.display();
        System.out.println("-----------------------------");
        System.out.print("Enter Your Choice : ");
        return sc.nextInt();
    }

    public int calculateBill(Food food, Food sidedish, int mainDishId, int sideDishId, int[] quantity){
        int mainDishPrice = food.priceOfFood(mainDishId);
        int sideDishPrice = sidedish.priceOfFood(sideDishId);

        int Total = 0;

        if(sideDishId==-1)
            Total = (mainDishPrice*quantity[0]);
        else
            Total = (mainDishPrice*quantity[0])+(sideDishPrice*quantity[1]);

        return Total;
    }

    public void mainDish(LocalTime time, Breakfast bf, Lunch lun, Dinner din, Sidedish sidedish, Cart cart){
        String timing = "";
        if(time.getHour()<=11) {
            food = bf;
            timing="breakfast";
        }else if(time.getHour()<=18) {
            food = lun;
            timing="lunch";
        }else {
            food = din;
            timing="dinner";
        }

        if(food==null) {
            System.out.println("Our server Crashed");
            return;
        }

        if(food.getFood().isEmpty())
            food.makeFood();

        System.out.println("!!!Please Choose Your Food!!!");
        System.out.println("-----------------------------");
        food.display();
        System.out.println("-----------------------------");
        System.out.print("Enter Your choice : ");
        int mainDish = sc.nextInt();
        System.out.print("Enter Quantity : ");
        int[] quantity = new int[2];
        quantity[0] = sc.nextInt();
        System.out.print("Do You Want Side Dish(Y/N) : ");
        String sideDishChoice = sc.next().trim();
        int sideDish = 0;
        if(sideDishChoice.equalsIgnoreCase("yes") || sideDishChoice.equalsIgnoreCase("y")){
            sideDish = sideDish(sidedish);
            System.out.print("Enter Side Dish Quantity : ");
            quantity[1] = sc.nextInt();
        }

        cart.addToCart(new CartItem(mainDish, quantity[0], food, sideDish, quantity[1], sidedish));

        System.out.println("Subtotal : "+calculateBill(food, sidedish, mainDish, sideDish, quantity));
    }
}

class User{
    Serving serving = null;
    Admin admin = null;

    public void chooseUser(Breakfast breakfast, Lunch lunch, Dinner dinner, Sidedish sidedish, Cart cart, Payment payment){
        Scanner sc = new Scanner(System.in);
        char ch = 'y';
        while (ch=='y' || ch=='Y'){
            System.out.println("""
                1. Admin
                2. Consumer
                """);
            System.out.print("Enter Your Choice : ");
            switch (sc.nextInt()){
                case 1:
                    admin = new Admin(breakfast, lunch, dinner, sidedish);
                    admin.checkCredential();
                    break;
                case 2:
                    serving = new Serving();
                    UtilFunc.timeChange();
                    serving.mainDish(LocalTime.now(), breakfast, lunch, dinner, sidedish, cart);
                    break;
                default:
                    System.out.println("Wrong Option");
            }
            System.out.print("\nDo you want to continue(Y/N) : ");
            ch = sc.next().toLowerCase().charAt(0);
        }
    }
}

public class Main {
    static Breakfast breakfast;
    static Lunch lunch;
    static Dinner dinner;
    static Sidedish sidedish;
    static Cart cart;
    static Payment payment;

    public static void main(String[] args) {
        System.out.println("----------------------------");
        System.out.println("|   MARAN PORATTA KADAI    |");
        System.out.println("| Kovilvasal, Kalugumalai. |");
        System.out.println("----------------------------\n");

        breakfast = new Breakfast();
        lunch = new Lunch();
        dinner = new Dinner();
        sidedish = new Sidedish();
        cart = new Cart();
        payment = new Payment();

        new User().chooseUser(breakfast, lunch, dinner, sidedish, cart, payment);

        if(!cart.getCart().isEmpty())
            payment.payBill(cart);
    }
}