import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class UtilFunc {
    public static void clrscr(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void wait(int seconds){
        try {
            TimeUnit.SECONDS.sleep(seconds);
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }
    public static void timeChange(){
        LocalTime time = LocalTime.now();
        System.out.println("---------------");
        if(time.getHour()<=11)
            System.out.println("|  Breakfast  |");
        else if(time.getHour()<=18)
            System.out.println("|    Lunch    |");
        else
            System.out.println("|    Dinner   |");
        System.out.println("---------------\n");
    }
    public static void loadingScreen(){
        try {
            System.out.print("===");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print("=====");
            TimeUnit.MILLISECONDS.sleep(2000);
            System.out.print("==========");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print("====");
            TimeUnit.MILLISECONDS.sleep(1000);
            System.out.print("=======");
            System.out.println();
        }catch (InterruptedException e){
            System.out.println(e.getMessage());
        }
    }

    public static void thankYouScreen(){
        clrscr();
        System.out.println("---------------------------------------------------------------------------------");
        System.out.println("|                                  THANK YOU                                    |");
        System.out.println("---------------------------------------------------------------------------------");
    }
}
