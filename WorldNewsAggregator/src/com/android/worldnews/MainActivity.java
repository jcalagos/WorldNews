package com.android.worldnews;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;

public class MainActivity extends Activity
{	
	private GoogleMap map;
	private Marker marker;
	
	static final LatLng CHINA = new LatLng(35, 105);
	static final LatLng RUSSIA = new LatLng(60, 100);
	static final LatLng KAZAKHSTAN = new LatLng(48, 68);
	static final LatLng MONGOLIA = new LatLng(46, 105);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{	
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		map = ((MapFragment) getFragmentManager().findFragmentById(R.id.map)).getMap();
		map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
		
		marker = map.addMarker(new MarkerOptions()
			.position(CHINA)
			.title("China"));
		
		marker = map.addMarker(new MarkerOptions()
			.position(RUSSIA)
			.title("Russia"));
		
		marker = map.addMarker(new MarkerOptions()
		.position(KAZAKHSTAN)
		.title("Kazakhstan"));
		
		marker = map.addMarker(new MarkerOptions()
		.position(MONGOLIA)
		.title("Mongolia"));
		
		map.moveCamera(CameraUpdateFactory.newLatLngZoom(CHINA, 0));
					
		
		//Button button = (Button) findViewById(R.id.button1);
		
		map.setOnMarkerClickListener(new OnMarkerClickListener()
		{
			@Override
			public boolean onMarkerClick(Marker marker)
			{
				String searchUrl = "http://news.google.com/news?q=" + marker.getTitle();
				Intent intent = new Intent(MainActivity.this, ArticleList.class);
				intent.putExtra("searchUrl", searchUrl);
				startActivity(intent);
				return true;
			}
		});   
	}
}
