import java.io.*;
import java.util.Scanner;


/**
 * 
 * File input/output program demonstrating basic IO instructions
 * by writing data to a simple text file.
 */



public class In_Out
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String friend;
        int closeOnes = 5;

        try 
        {
            PrintWriter outputFile = new PrintWriter("friends.txt");

            for(int i = 1; i < closeOnes; i++)
            {
                System.out.print("Enter the name of your friend number " + i + ": ");
                friend = sc.nextLine();

                outputFile.println(friend);
            }

            outputFile.close();
            sc.close();
            System.out.println("Names written to file.");

        } catch (Exception e) {
            e.printStackTrace();
        }

        
    }
}