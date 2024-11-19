//Book Comparer in Java
//Compares books and calculates how long they will take to read

import java.util.Scanner; //Imports scanner

public class BookComparer {
    public static void main(String[] args) {
        while(true){ //To loop back to when the program is finished

            //Input Stage
            //Gets all the initial data from the user

            //Gets amount of books
            java.util.Scanner reply = new Scanner(System.in);
            System.out.print("Welcome to the Book Comparer!\n\nHow many books would you like to compare today?: ");
            int amount = reply.nextInt();

            //Transition effect
            try{
                Thread.sleep(1000);
            }
            catch (Exception e){
                System.out.println(e);
            }
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            
            //Declares Arrays, using parallel arrays to store all information about each book
            String [] titles = new String[amount];
            int [] pages = new int[amount];
            double [] time = new double[amount];
            double [] totalTimeMin = new double[amount];
            double [] totalTimeHours = new double[amount];
            double [] rating = new double[amount];

            //Gets specific book info for each book
            for (int i = 0; i < amount; i++){
                System.out.println("(Book " + (i + 1) + ")\nWhat is this book called? ");
                reply.nextLine();
                titles[i] = reply.nextLine();
                System.out.println("How many pages does this book have? ");
                pages[i] = reply.nextInt();
                System.out.println("\nNow read two pages of the book. ");
                try{
                    Thread.sleep(1000);
                }
                catch (Exception e){
                    System.out.println(e);
                }
                
                //Calculates the time for the entire book
                System.out.println("\nHow long did it take to read two pages (Min)? ");
                time[i] = reply.nextDouble();
                totalTimeMin[i] = pages[i] * (time[i]/2);
                totalTimeHours[i] = Math.floor((totalTimeMin[i]/60) * 100) / 100; //Rounds the time in hours to the hundredths for readability
                
                System.out.println("How much did you enjoy the book from the two pages you read (1-10)? ");
                rating[i] = reply.nextDouble();
                System.out.println("\nBook " + (i+1) + " finished!");
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            }


            //Output stage


            //Prints out book table
            System.out.println("\tBook Table\n");
            System.out.println("Num)\tTitle\t\t\t\t|\tPages\t|\tTime To Read\t|\tRating");
            for(int i = 0; i < amount; i++){ //Iterates for each book
                System.out.print((i+1) + ")\t" + titles[i]);
                //Adds spaces to each title so it lines up correctly in the table by subtracting the title length from 24 and adding the difference in spaces
                for (int o = 0; o < (24 - titles[i].length()); o++){
                    System.out.print(" ");
                }
                System.out.print("\t|\t" + pages[i] + "\t|\t");
                if (totalTimeHours[i] > 1) //Checks if the read time is under an hour and if so, it displays the minutes instead of hours
                    System.out.println(totalTimeHours[i] + "h\t\t|\t"+ rating[i] + "/10\t");
                else
                    System.out.println(totalTimeMin[i] + "m\t\t|\t"+ rating[i] + "/10\t");
            }

            //Repeats the program as per user's request
            char check;
            System.out.println("Would you like to compare more books? (y/n)");
            check = reply.next().charAt(0);
            if (check == 'n')
                break;
            else
                continue;
        }
    }
}