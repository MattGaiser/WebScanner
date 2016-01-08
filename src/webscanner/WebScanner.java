/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscanner;

import java.util.*;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author Matthew
 */
public class WebScanner {

    /**
     * @param args the command line arguments
     */
    public Set<String> pagesGoneTo = new HashSet<String>();
    public List<String> pagesToGoTo = new LinkedList<String>();
    
    private String nextPage()
    {
        String next;
        
        do {
            next = this.pagesToGoTo.remove(0);
        
        } while (this.pagesGoneTo.contains(next));
        this.pagesGoneTo.add(next);
        return next; 
        
    }
    
    public void initiateSearch(String startURL, String toFind) throws Exception
    {
        while (true)
        {
            String url;
            WebScannerMethods wsm = new WebScannerMethods();
            if (this.pagesToGoTo.isEmpty())
            {
                url = startURL; 
                this.pagesGoneTo.add(startURL); 
            }
            else 
            {
                
                url = this.nextPage();
                if (urlCheck(startURL,url) == false) 
                {
                    this.pagesGoneTo.add(url);
                    this.pagesToGoTo.remove(0);
                    url = this.nextPage();
                }
            }
            System.out.println(url);
            wsm.crawl(url);
            Found victory = new Found();
            victory.somethingFound = wsm.finder(toFind);
            victory.url = url; 
            
            if (victory.somethingFound == true)
            {
                System.out.println("Found revenue");
            }
            else 
            {
                //System.out.println("Search was unsuccessful for url:" + victory.url);
            }
            this.pagesToGoTo.addAll(wsm.getURLs());
        }
    }
     private boolean urlCheck(String startURL, String next)
    {
       String[] pageCheck = {".php",".html",".aspx",".htm"};
       for (int i = 0; i < pageCheck.length;i++)
       {
          if ((next.toLowerCase().contains(pageCheck[i].toLowerCase())) == true)
          {
              if((next.toLowerCase().contains(startURL) == true))
                      {
                          
                      }
          }
       }
       return false;
    }
}
