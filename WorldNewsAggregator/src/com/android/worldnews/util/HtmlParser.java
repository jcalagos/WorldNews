package com.android.worldnews.util;

import java.io.IOException;
import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.android.worldnews.data.Article;

public class HtmlParser 
{
	
	private Document doc;		// jsoup object - stores an HTML Document
	private Elements links;		// jsoup object - stores a list of our links
	private ArrayList<Article> articleList = new ArrayList<Article>(); // List of our articles
	
	// parseUrlAndGetArticles will parse a passed-in url and return a list of Article objects
	public ArrayList<Article> parseUrlAndGetArticles(String url)
	{
		try
		{
			// Connect to URL and put HTML code in doc
			doc = Jsoup.connect(url).get();
			
			// Assuming the HTML <title>string</title> is the location, 
			// store string as our location
			String location = doc.title();
			System.out.println("Location: " + location);
			
			// Grab links from our HTML document
			links = doc.select("a[href]");
			
			// Iterate through links and store the important ones
			for (Element link: links)
			{
				if (link.attr("href").contains("http") 
							&& !link.attr("href").contains("google.com")
							&& !link.attr("href").contains("youtube.com")
							&& !link.attr("href").contains("blogger.com")
							&& !link.attr("href").contains(".html"))
				{
					System.out.println("\nlink: " + link.attr("href"));
					System.out.println("text: " + link.text());
					
					// Creates an Article(title, URL, country) and adds it to list of articles
					Article article = new Article(link.text(), link.attr("href"), location);
					articleList.add(article);
				}
			}
			
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return articleList;
	}
}
