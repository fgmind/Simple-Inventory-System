/*
 * This is assignment 2 for Software Development.
 * This class contains the main method to launch the program.
 * It also create the object to store products and inventory
 * and call methods from the product and inventory class.
 */

package IT6260_Assignment2_2804582;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author  :   Francois Gilles Mindiel
 * ID number:   2804582
 */
public class Main {
    // declaring variables to store product info.
    protected HashMap<Integer, ArrayList<String>> product = new HashMap<>();
    protected float invTotal;
    
    protected Scanner scanner = new Scanner(System.in);   // to get user input

    
public static void main(String[] args) {

    Product invProduct = new Product();     // creating object of Product class
    Scanner input = new Scanner(System.in);
    boolean quit = false;
    //populating inventory with sample info
    invProduct.addProduct(45, "Shapes", 15, 2.99);
    invProduct.addProduct(25, "Tea", 100, 1.20);
    invProduct.addProduct(53, "coffee", 20, 6.99);
    invProduct.addProduct(34, "sugar", 10, 0.99);
    invProduct.addProduct(2, "cream", 70, 3.49);
    invProduct.addProduct(4, "sprite", 50, 3);        
    

//creates a welcome screen which comes back until user wishes to quit
while (quit != true){    
    //creating a dialog on console screen to get user input
    System.out.println("======================================="); 
    System.out.println("Welcome to the Simple inventory System!");
    System.out.println("=======================================");
     System.out.println("What would you like to do?");
     System.out.println("1. Add product to inventory\n"
             + "2. Modify product\n"
             + "3. Delete product\n"
             + "4. List all products\n"
             + "5. Generate report\n"
             + "0. Exit system");
         int choice = input.nextInt();           // to get user option using integer

    if (input.hasNextInt()) {
       
if (choice == 1) {
    invProduct.clearScreen();    
    invProduct.addProduct();
        }
if (choice == 2) {
    invProduct.clearScreen();
    invProduct.changeProduct();
        }
if (choice == 3) {
    invProduct.clearScreen();
    invProduct.deleteProduct();
        }
if (choice == 4) {
    invProduct.clearScreen();
    invProduct.listProduct();
        }
if (choice == 5) {
    invProduct.clearScreen();
    invProduct.createInventory();
        }
if (choice == 0) {
    quit = true;
        }
if ((choice <0) || (choice >5)) {           // else option was always printing error message...
    invProduct.clearScreen();
    System.out.println("Error, please choose an option from 0 to 5");
        }
    }
    else{
        System.out.println("Error. Not a valid input. Enter a number from 0 to 5");
    }
        
}    

// when exiting welcome screen!

invProduct.clearScreen();
System.out.println("Thank you for your visit. Goodbye");    

}

public void clearScreen(){
    for (int i = 0; i < 50; i++) {      // to "clear" console screen
    System.out.println("");            
        }
}

public void createInventory(){

    System.out.println("Product ID"+"\t"+"Product Name"+"\t\t\t"+"Quantity"+"\t"+"Price"+"\t\t"+"Total Value");

    for (Map.Entry<Integer, ArrayList<String>> entry : product.entrySet()) {
        Integer key = entry.getKey();
        ArrayList value = entry.getValue();
        
        // extracts String data "quantity" and "price" and converts into float. Then multiplies both numbers
        float itemTotal = (Integer.parseInt(String.valueOf(value.get(1))))*(Float.parseFloat(String.valueOf(value.get(2))));
        value.add(itemTotal);       // adds it to array, for display of inventory.

        System.out.println(key+"\t\t"+value.get(0)+"\t\t\t\t"+value.get(1)+"\t\t$ "+value.get(2)+"\t\t$ "+value.get(3));

        invTotal = invTotal + itemTotal;
    }
    System.out.println("===============================================================================================");
    System.out.println("\t\t\tINVENTORY VALUE:\t\t\t$" + invTotal);
}

}
