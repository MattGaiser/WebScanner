/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscanner;

import java.util.*;
/**
 *
 * @author Matthew
 */
public class WebScanner {

    /**
     * @param args the command line arguments
     */
    Set<String> pagesGoneTo = new HashSet<String>();
    List<String> pagesToGoTo = new LinkedList<String>();
    
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
    private String nextPage()
    {
        String next;
        
        do {
            next = this.pagesToGoTo.remove(0);
        
        } while (this.pagesGoneTo.contains(next));
        this.pagesGoneTo.add(next);
        return next; 
        
    }
}
