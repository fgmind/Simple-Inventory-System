/*
 * This is assignment 2 for Software Development.
 * This class creates a hashmap to store product info.
 */

package IT6260_Assignment2_2804582;

// importing the java utility packages needed for array lists, hashmaps and maps.
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author  :   Francois Gilles Mindiel
 * ID number:   2804582
 */
public class Product extends Main{

    /**
     *
     * @param id
     * @param name
     * @param qty
     * @param price
     */
public void addProduct(int id, String name,int qty, double price){
/*
method used to add product using parameters. Useful to populate the inventory   
*/
    ArrayList productInfo = new ArrayList();    // stores name, quantity and price of each product
    int pdctID = id;        // only integer number allowed
    String pdctName = name;
    int pdctQty = qty;      // quantity can only be whole number
    double pdctPrice = price;    // since price has cents
 
    //populate the list
    productInfo.add(pdctName);
    productInfo.add(pdctQty);
    productInfo.add(pdctPrice);

    product.put(pdctID,productInfo);    // to create hashmap, with id as key
}

public void addProduct(){               // gets input from user
/*
    this method gets user to input the different values to store product info
    and store them in hashmap
    */
    ArrayList productInfo = new ArrayList();
    
    System.out.println("Enter Product ID:");
    int pdctID = scanner.nextInt();

    System.out.println("Enter product name:");
    String pdctName = scanner.next();
    
    System.out.println("Enter Product quantity:");
    int pdctQty = scanner.nextInt();
    
    System.out.println("Enter product price:");
    double pdctPrice = scanner.nextFloat();
 
    //populate the list
    productInfo.add(pdctName);
    productInfo.add(pdctQty);
    productInfo.add(pdctPrice);

    try {
        product.put(pdctID,productInfo);    // to create hashmap, with id as key
        System.out.println("Product added to inventory");
    } catch (Exception e) {
        System.out.println("Error. Please check that input is correct");
    }

}

public void listProduct(){
        
        System.out.println("Product ID"+"\t"+"Product Name"+"\t\t\t"+"Quantity"+"\t"+"Price");
        for (Map.Entry<Integer, ArrayList<String>> entry : product.entrySet()) {
            Integer key = entry.getKey();
            ArrayList value = entry.getValue();
        System.out.println(key+"\t\t"+value.get(0)+"\t\t\t\t"+value.get(1)+"\t\t$ "+value.get(2));
        } 
}
    
public void changeProduct(){
    /*
    used to modify a product. it selects a product first. then gets user input stored
    in a different variable (temp), deletes the product, and adds the "new" product,
    with same product key as previously back into the list.
    */
    System.out.println("enter pdct id number:");
    int id = scanner.nextInt();
    String answer = scanner.next();
    ArrayList temp = product.get(id);
    
    System.out.println("Product: "+temp.get(0));
    System.out.println("");
    System.out.println("Enter new name:");
    String newName = scanner.next();    
    System.out.println("Enter new quantity:");
    int newQty = scanner.nextInt();
    System.out.println("Enter new price:");
    double newPrice = scanner.nextDouble();
    
    System.out.println("Are you sure you want to modify product?");
    System.out.println("yes or no");
    if ("yes".equals(answer)) {
        temp.clear();
        temp.add(newName);
        temp.add(newQty);
        temp.add(newPrice);

        product.remove(id);
        product.put(id, temp);

        //Product info changed!!!
        System.out.println(product.get(id));
        if ("no".equals(answer)) {
            System.out.println("Product not changed.");
        }
    }
    
    
}

public void deleteProduct(){
    System.out.println("enter pdct id number:");
    int id = scanner.nextInt();
    String answer = scanner.next();
    ArrayList temp = product.get(id);
    
    System.out.println("Product: "+temp.get(0));
    
    System.out.println("Are you sure you want to delete product?");
    System.out.println("yes or no");
    if ("yes".equals(answer)) {
    product.remove(id);
    System.out.println("Product removed from inventory");
    }    
    if ("no".equals(answer)) {
        System.out.println("Product not deleted.");
    }

}

public HashMap getProduct() {
        return product;
}

}