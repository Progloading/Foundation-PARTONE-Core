import java.io.*;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;




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
    
     public static PrintWriter readFriends(String filename) throws IOException
    { 
        List<String> names = new ArrayList<String>(100);
        String searchCriteria1 = "<";
        String searchCriteria2 = " ";
        
        // The method gets the file name passed as a parameter and the File object opens said file
        File file = new File(filename);
                            
                            //Scanner object could be used for operations but BufferReader is more efficient
                            //Scanner reader = new Scanner(file);
        try 
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while((line = reader.readLine()) != null)
            {  
                if((!line.contains(searchCriteria1)) && (!line.contains(searchCriteria2)))
                { names.add(line); }
            }
            reader.close();
        } catch(Exception e) {
            e.printStackTrace();
        }

        // Pass through Stream to apply intermediate y terminal actions: Core-Coding series (part 1)
        List<String> cap_Names = names.stream()
                                .map(name -> name.toUpperCase())
                                .collect(Collectors.toList());
                       
        PrintWriter result = new PrintWriter("resulting.txt");
        result.println(cap_Names);
        result.close();

        return result;

    }

    /* 
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
     * Answer: Option A is selected since that was the first thought.
     * 
     * 
     */
    

    public static PrintWriter addFriends(PrintWriter outputFile) throws IOException
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

    public static PrintWriter quotes_Added(PrintWriter outputFile) throws IOException
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
    public static void main(String[] args) throws IOException
    {
        Scanner scanner = new Scanner(System.in);
        Scanner key = new Scanner(System.in);
        String filename;

        System.out.println("\n1) Add Friends ");
        System.out.println("2) Add Quotes ");
        System.out.println("3) Read Friends ");
        System.out.println("4) ###### (TBA) Read Quotes "); // Will be added soon
        System.out.print("\nhat would you like to do? (1 - 3) ");
        int choice = scanner.nextInt();

        switch(choice)
        {
            case 1:
                try
                {
                    System.out.print("Enter the name of the file: ");
                    filename = key.nextLine();
                    PrintWriter outputFile_ONE = new PrintWriter(new FileWriter(filename, true));
                    addFriends(outputFile_ONE);
                }catch(Exception e) {
                    e.printStackTrace();
                }
            break;

            case 2:
                try
                {
                    System.out.print("Enter the name of the file: ");
                    filename = key.nextLine();
                    PrintWriter outputFile_TWO = new PrintWriter(new FileWriter(filename, true));
                    quotes_Added(outputFile_TWO);
                }catch(Exception e) {
                    e.printStackTrace();
                }
            break;

            case 3:
                try 
                {
                    System.out.print("Enter the name of the file: ");
                    filename = key.nextLine();
                    readFriends(filename);

                } catch (Exception e) {
                    e.printStackTrace();
                }

        }

        System.out.println("");
        System.out.println("Data written to file.");
        scanner.close();
        key.close();
        
    }
}