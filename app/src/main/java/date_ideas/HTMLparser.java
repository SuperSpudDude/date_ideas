package date_ideas;

import java.util.ArrayList;
import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

/* TODO:
    - handle sizing (p1, p2, p3, etc)
    - divs
    -
*/
public class HTMLparser {
    private Document currDoc;

    public String setDoc(Document doc){
        currDoc = doc;
        return currDoc.title();
    };
    
    public List get(String tag, int amount){ 
        List elementsList = new ArrayList<>();
        org.jsoup.select.Elements hasTags = currDoc.getElementsByTag(tag);
        if(!hasTags.isEmpty()){
            if(hasTags.size() < amount){
                amount = hasTags.size();
            }
            for(int i = 0; i < amount; i++){
                elementsList.add(hasTags.get(i).text());
            }
        }
        return elementsList;
    };
    
    public List getURLs(int amount){
        return get("a", amount);
    };
}