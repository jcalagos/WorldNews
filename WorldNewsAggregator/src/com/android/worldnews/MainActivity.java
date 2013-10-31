package com.android.worldnews;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity 
{	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button button = (Button) findViewById(R.id.button1);
		
		button.setOnClickListener(new OnClickListener()
		{
			@Override
			public void onClick(View v)
			{
				String url = "http://news.google.com/news?q=china";
				Intent intent = new Intent(MainActivity.this, ArticleList.class);
				intent.putExtra("url", url);
				startActivity(intent);
			}
		});
		
       
        
	}
}
