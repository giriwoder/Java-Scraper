import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class test {

    public static void main(String[] args) throws IOException
    {
        Document doc = Jsoup.connect("https://medium.com/tech-diversity-files/if-you-think-women-in-tech-is-just-a-pipeline-problem-you-haven-t-been-paying-attention-cb7a2073b996")
                .timeout(6000).get();

        Elements body = doc.select("data-new-gr-c-s-loaded");
        System.out.println(body.select("s").size());

        File file = new File("/Users/sohee/Desktop/blog.txt");
        Scanner sc = new Scanner(file);

        //Elements body2 = file.select("body.data-gr-c-s-loaded");

       // while (sc.hasNextLine()) {
            //System.out.println(sc.nextLine());
       // }

        for (Element e : body.select("n p"))
        {
            System.out.println("check loop");

            String img = e.select("figure.jf jg jh ji jj jk jl jm jn jo jp paragraph-image").attr("src");
            System.out.println(img);

            String content = e.select("p").text();
            System.out.println(content);

            String title = e.select("td.posterColumn img").attr("alt");
            System.out.println(title);
            String year = e.select("td.titleColumn span.secondaryInfo")
                    .text().replaceAll("[^\\d]", "");
            System.out.println(year);
            String rate = e.select("td.ratingColumn.imdbRating").text().trim();
            System.out.println(rate);
        }
    }

}
