/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webscanner;

import java.util.*;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author Matthew
 */
public class WebScannerMethods {
    private List<String> links = new LinkedList<String>();
    private Document webPage;
    private String userAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:40.0) Gecko/20100101 Firefox/40.1";
    public void crawl (String next) throws Exception
    {
        Connection get = Jsoup.connect(next).userAgent(userAgent);
        get.referrer("http://www.google.com");
        webPage = get.get();
        Elements linked = webPage.select("a[href]"); 
        
        linked.stream().forEach((link) -> {
            this.links.add(link.absUrl("href"));
        });
        
    }
    
    public boolean finder (String searchParameter)
    {
        String textPile = this.webPage.body().text();
        System.out.println(textPile);
        if (( textPile.toLowerCase().contains(searchParameter.toLowerCase())) == true)
        {
            System.out.println("Yipee");
            boolean var = true;
            return var;
        }
        return false; 
    }
    
    public List<String> getURLs()
    {
        return this.links;
    }
    
}
