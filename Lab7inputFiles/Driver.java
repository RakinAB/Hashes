import java.util.*;
import java.io.*;

public class Driver{
    public static void main(String[] args) throws FileNotFoundException, IOException {
        HashMap map = new HashMap();
        Scanner scan = new Scanner(System.in);

        //reading UPC.CSV
        try(BufferedReader reader = new BufferedReader(new FileReader("Hashes/Lab7inputFiles/UPC.csv"))){
            String line;
            while((line = reader.readLine()) != null){
                String[] parts = line.split(",");
                if(parts.length >= 2){
                    int key = Integer.parseInt(parts[0]);
                    String desc = parts[2];
                    map.put(key, desc);         //PUT
                }
            }
            reader.close();

        } catch(IOException e){
            System.out.println("Error reading CSV file: " + e.getMessage());
        }

        //User input, allow for testing
        boolean done = false;
        while(!done){

            //Give Options
            System.out.println("\n=============================================================================================");
            System.out.println("* Please enter what you would like to do with the Hash Map: Enter A/B");
            System.out.println("* \t(A) Get an Entry");
            System.out.println("* \t(B) Put an Entry");
            System.out.println("* \t(C) Exit");
            String input = scan.nextLine();        //will get the user's input

            //Searching
            if(input.equalsIgnoreCase("A")){
                System.out.println("* Enter a key: ");
                int searchKey = Integer.parseInt(scan.nextLine());
                String result = map.get(searchKey);
                if(result != null){
                    System.out.println("* Here is the description correlated with the key: " + result);
                } else{
                    System.out.println("* There is no description correlated with this key...");
                }
            }
            //adding a new entry 
            else if(input.equalsIgnoreCase("B")){

            } 
            //exiting program
            else if(input.equalsIgnoreCase("C")){
                System.out.println("* Alright, Goodbye!");
                done = true;
            }
            //if the user inputs an invalid input 
            else{
                System.out.println("This is not a valid input, try again...");
            }
        }
    }
}