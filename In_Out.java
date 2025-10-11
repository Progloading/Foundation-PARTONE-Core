import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;



/**
 * 
 * File input/output program demonstrating basic IO instructions
 * by writing data to a simple text file. Manipulating those text
 * files for individual needs (Whatever flights your fancy).
 * 
 * 
 * 
 * 
 */



public class In_Out
{
    static LocalDateTime DATE_TIME = LocalDateTime.now();
    /*
     *public static PrintWriter readFriends()
    {

    } 
     * Next order of business is reading the close_friends file
     * with the help of streams and conducting some operation to feed into pipeline. 
     * Potential Operations:
     *  A) capitilize all names
     *  B) return names beginning with a particular letter
     *  C) reversing names beginning with a particular letter
     *  D) reversing names only
     *  E) Put names in alphabetical order and run a separate operation on the resulting list
     *      (perhaps, add a start next to "really" close friends and updating a new file of those)
     * 
     * 
     * 
     * 
     */
    

    public static PrintWriter addFriends(PrintWriter outputFile)
    {   
           Scanner scan_1 = new Scanner(System.in);
           Scanner scan_2 = new Scanner(System.in);

           outputFile.println(" ");
           outputFile.println("<<<<<<<<<< New Entry >>>>>>>>>> " + DATE_TIME);
           outputFile.println(" ");
           
           outputFile.println("");
           System.out.print("How many friends would you like to add today? ");
           int comrads = scan_1.nextInt();

           for(int i = 1; i <= comrads; i++)
           {
                System.out.print("Add the name of your friend number " + i + ": ");
                String friend = scan_2.nextLine();
                outputFile.println(friend);
           }
        
           outputFile.close();
           scan_1.close();
           scan_2.close();

           return outputFile;
    }

    public static PrintWriter quotes_Added(PrintWriter outputFile)
    {
            Scanner scan_3 = new Scanner(System.in);
            Scanner scan_4 = new Scanner(System.in);
            
            outputFile.println(" ");
            outputFile.println("<<<<<<<<<< New Entry >>>>>>>>>> " + DATE_TIME);
            outputFile.println(" ");

            outputFile.println("");
            System.out.print("How many quotes would you like to add? ");
            int quotations = scan_3.nextInt();
            
            for(int i = 1; i <= quotations; i++)
            {
                outputFile.println(" ");
                System.out.println("Enter the quote -> ");
                outputFile.println("");
                String quote = scan_4.nextLine();

                outputFile.println(quote);
            }

            outputFile.close();
            scan_3.close();
            scan_4.close();

            return outputFile;

    }
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        String filename;

        System.out.print("What would you like to do? (1 or 2) ");
        int choice = scanner.nextInt();

        switch(choice)
        {
            case 1:
                try
                {
                    filename = "close_friends.txt";
                    PrintWriter outputFile_ONE = new PrintWriter(new FileWriter(filename, true));
                    addFriends(outputFile_ONE);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            break;

            case 2:
                try
                {
                    filename = "Quotes.txt";
                    PrintWriter outputFile_TWO = new PrintWriter(new FileWriter(filename, true));
                    quotes_Added(outputFile_TWO);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            break;

        }

        System.out.println("");
        System.out.println("Data written to file.");
        scanner.close();
        
    }
}