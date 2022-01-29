package date_ideas;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Before;
import org.junit.BeforeClass;

import date_ideas.HTMLparser;

public class HTMLparserTest {
    HTMLparser p = new HTMLparser();
    static Document noLink;
    static Document tenLink;

    @BeforeClass
    public static void setupDocuments(){
        URL url1 = HTMLparserTest.class.getResource("../test_web_page_0_link.html");
        File noLinkFile = new File(url1.getPath());
        URL url2 = HTMLparserTest.class.getResource("../test_web_page_10_link.html");
        File tenLinkFile = new File(url2.getPath());

        try{
            noLink = Jsoup.parse(noLinkFile, null);
            tenLink = Jsoup.parse(tenLinkFile, null);
        } catch (IOException ioe){
            System.out.println("document setup failed: " + ioe.getMessage());
        }
    }

    @Before
    public void setDoc(){
        p.setDoc(tenLink);
    }

    @Test
    public void setDocShouldReturnTitle(){
        assertEquals("test_web_page_0_link", p.setDoc(noLink));
        assertEquals("test_web_page_10_link", p.setDoc(tenLink));
    }

    @Test
    public void getPragraphTagShouldReturnCount1(){
        int result = p.get("p",1).size();
        assertEquals(1, result);
    }
    
    @Test
    public void getTagThatsNotAvailable(){
        int result = p.get("sctipt", 10).size();
        assertEquals(0, result);
    }
    
    @Test
    public void get1linkShouldReturn1Link(){
        int result = p.getURLs(1).size();
        assertEquals(1, result);}

    @Test
    public void get5LinksShouldReturn5Links(){
        int result = p.getURLs(5).size();
        assertEquals(5, result);}

    @Test
    public void getMoreLinksThanAvailableShouldReturnMaxAvailableLinks(){
        int result = p.getURLs(11).size();
        assertEquals(10, result);
    }



}
