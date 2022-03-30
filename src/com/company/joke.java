package com.company;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class joke {
    private String url;

    public joke()
    {
        this.url = "http://anekdotme.ru/random";
    }

    public String getJoke() throws IOException
    {
        try {
            Document document = Jsoup.connect(this.url).get();
            Element joke = document.select(".anekdot_text").first();
            assert joke != null;
            return joke.text().replaceAll("<.*>", "");
        }
        catch (IOException ex) {
            return ex.getMessage();
        }
    }
}
