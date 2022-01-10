package date_ideas;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import date_ideas.Search;

public class SearchTest {
    Search s;

    @Test
    void setURLReturnsCorrectURL(){
        String url = "https://www.google.com";
        assertEquals(s.setURL(url), url);
    }

    @Test
    void isConnectedWithKnownTrue(){
        String url = "https://www.google.com";
        s.setURL(url);
        assertTrue(s.connected());
    }

    @Test
    void isNotConnectedWithKnownFalse(){
        String url = "invalid url format";
        s.setURL(url);
        assertFalse(s.connected());
    }

    @Test
    void get1link(){

    }

    @Test
    void get5Links(){

    }

    @Test
    void getMoreLinksThanAvailable(){

    }

    @Test
    void getPTag(){

    }

    @Test
    void getTagThatsNotAvailable(){

    }


}
