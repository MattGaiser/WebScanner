/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscanner;

/**
 *
 * @author Matthew
 */
public class goFindIt {
     public static void main(String[] args) throws Exception {
        // TODO code application logic here
        WebScanner thing = new WebScanner();
        thing.initiateSearch("http://matthewgaiser.ca/","alberta");
    }
    
}
