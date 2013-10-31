package com.android.worldnews;

import java.util.ArrayList;

import com.android.worldnews.data.Article;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ArticleListAdapter extends ArrayAdapter<Article>
{
	private ArrayList<Article> articleList;
	private Context context;
	
	public ArticleListAdapter(Context context, ArrayList<Article> list)
	{
		super(context, R.layout.article_list, list);
		this.articleList = list;
		this.context = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View view = inflater.inflate(R.layout.article_list, parent, false);
		TextView textView = (TextView) view.findViewById(R.id.label);
		
		Article article = articleList.get(position);
		
		textView.setText(article.getTitle());
		
		return view;	
	}
}
