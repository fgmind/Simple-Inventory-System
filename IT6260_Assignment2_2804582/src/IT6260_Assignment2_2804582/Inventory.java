/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IT6260_Assignment2_2804582;

import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author  :   Francois Gilles Mindiel
 * ID number:   2804582
 */
public class Inventory extends Main{
    

    @Override
    public void createInventory(){
    System.out.println("Product ID"+"\t"+"Product Name"+"\t\t\t"+"Quantity"+"\t"+"Price"+"\t\t"+"Total Value");

    for (Map.Entry<Integer, ArrayList<String>> entry : product.entrySet()) {
        Integer key = entry.getKey();
        ArrayList value = entry.getValue();
        
        // extracts String data "quantity" and "price" and converts into float. Then multiplies both numbers
        float itemTotal = (Integer.parseInt(String.valueOf(value.get(1))))*(Float.parseFloat(String.valueOf(value.get(2))));
        value.add(itemTotal);       // adds it to array, for display of inventory.

        System.out.println(key+"\t\t"+value.get(0)+"\t\t\t\t"+value.get(1)+"\t\t$ "+value.get(2)+"\t\t$ "+value.get(3));

        invTotal = invTotal + itemTotal;    // stores total value of stock
    }
    System.out.println("===============================================================================================");
    System.out.println("\t\t\tINVENTORY VALUE:\t\t\t$" + invTotal);

}
    
 }

