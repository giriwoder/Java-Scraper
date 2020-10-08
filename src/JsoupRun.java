import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupRun {

	public static void main(String[] args) throws IOException
	{
		Document doc = Jsoup.connect("https://www.imdb.com/chart/top")
				.timeout(6000).get();
		Elements body = doc.select("tbody.lister-list");
		//System.out.println(body.select("tr").size());
		for(Element e : body.select("tr"))
		{
			String img = e.select("td.posterColumn img").attr("src");
			System.out.println(img);

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
