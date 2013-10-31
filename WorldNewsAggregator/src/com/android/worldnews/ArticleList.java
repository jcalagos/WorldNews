package com.android.worldnews;

import java.util.ArrayList;

import com.android.worldnews.data.Article;
import com.android.worldnews.util.HtmlParser;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;

import android.widget.ListView;
import android.widget.Toast;


public class ArticleList extends ListActivity {
	
	
	HtmlParser parser = new HtmlParser();
	ArrayList<Article> articleList;
	
	// Creates a list of articles for the passed url
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		 
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
	    StrictMode.setThreadPolicy(policy);
	    
	    // Passes URL from MainActivity to this activity
	    Bundle extras = getIntent().getExtras();
	    String newsUrl = extras.getString("url");
	    	    
	    articleList = parser.parseUrlAndGetArticles(newsUrl);
		
	    setListAdapter(new ArticleListAdapter(this, articleList));    
	}
	
	// Sets what happens when you click on an article in the list
	@Override
	protected void onListItemClick(ListView listView, View view, int position, long id)
	{
		String selectedValue = (String) ((Article) getListAdapter().getItem(position)).getUrl();
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();
	}
}
