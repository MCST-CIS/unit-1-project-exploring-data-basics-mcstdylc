import Scanner;

public class BookComparer {
    public static void main(String[] args) {
        while(true){
            java.util.Scanner reply = new Scanner(System.in);
            System.out.println("Welcome to the Book Comparer!\n\nHow many books would you like to compare today?: ");
            int amount = reply.nextInt();
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            String [] titles = new String[amount];
            int [] pages = new int[amount];
            double [] time = new double[amount];
            double [] totalTime = new double[totalTime];
            for (i = books; i > 0; i--){
                
            }
        }
    }
}