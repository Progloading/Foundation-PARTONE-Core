import java.io.*;
import java.util.Scanner;


/**
 * 
 * File input/output program demonstrating basic IO instructions
 * by writing data to a simple text file.
 */



public class In_Out
{
    public static PrintWriter addFriends(PrintWriter outputFile)
    {   
           Scanner scan_1 = new Scanner(System.in);
           Scanner scan_2 = new Scanner(System.in);

           outputFile.println(" ");
           outputFile.println("<<<<<<<<<< New Entry >>>>>>>>>>");
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
            outputFile.println("<<<<<<<<<< New Entry >>>>>>>>>>");
            outputFile.println(" ");

            System.out.print("How many quotes would you like to add? ");
            int quotations = scan_3.nextInt();
            
            for(int i = 1; i <= quotations; i++)
            {
                outputFile.println(" ");
                System.out.println("Enter the quote -> ");
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

        System.out.print("What would you like to do? (1 or 2) ");
        int choice = scanner.nextInt();

        switch(choice)
        {
            case 1:
                try
                {
                    PrintWriter outputFile_ONE = new PrintWriter("close_friends.txt");
                    addFriends(outputFile_ONE);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            break;

            case 2:
                try
                {
                    PrintWriter outputFile_TWO = new PrintWriter("Quotes.txt");
                    quotes_Added(outputFile_TWO);
                }catch(Exception e)
                {
                    e.printStackTrace();
                }
            break;

        }
        
        System.out.println("Data written to file.");
        scanner.close();
        
    }
}