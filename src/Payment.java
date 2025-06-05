import java.util.Scanner;

public class Payment {
    private final Scanner sc = new Scanner(System.in);

    public void payBill(Cart cart){
        boolean bool = true;
        System.out.println("""
                ----------------
                |     Cart     |
                ----------------
                """);
        cart.displayCart();
        System.out.println("Total Amount : "+cart.getTotal());
        System.out.println("Do you want to checkout(Y/N) : ");
        char ch = sc.next().trim().charAt(0);
        while (bool){
            if(ch=='y' || ch=='Y') {
                System.out.println("Please Enter the Amount To Pay : ");
                int amount = sc.nextInt();
                if(cart.getTotal()!=amount){
                    System.out.println("Please Enter correct Amount");
                }else {
                    cart.clearCart();
                    bool = false;
                }
            }
        }

        UtilFunc.thankYouScreen();
    }
}
