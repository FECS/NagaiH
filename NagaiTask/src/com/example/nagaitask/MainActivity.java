package com.example.nagaitask;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//setContentView(R.layout.fragment_main);
		
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
        
//          mWebView = (WebView) findViewById(R.id.webView1);
//          mWebView.setWebViewClient(new WebViewClient());
        
       
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		
		static WebView mWebView;

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView =  inflater.inflate(R.layout.fragment_main, container,false);
			mWebView  = (WebView) rootView.findViewById(R.id.webView1);
			mWebView.setWebViewClient(new WebViewClient());
			
			return rootView;
		}
		
		public static void click(){
			mWebView.loadUrl("https://www.google.co.jp/");
		}
		public static void click2(String url){
			mWebView.loadUrl(url);
		}
		
	}

	public void Clicked(View view){
		Log.d("Test","Clicked!");
		PlaceholderFragment.click();
//		WebView m2WebView  = (WebView) view.findViewById(R.id.webView1);
//		mWebView.loadUrl("https://www.google.co.jp/");
	}
	public void Clicked2(View view){
		Log.d("Test","Clicked2!");
		EditText edittext = (EditText)findViewById(R.id.editText1);
		String text = edittext.getText().toString();
		PlaceholderFragment.click2(text);
	}
	@Override
    public boolean onTouchEvent(MotionEvent event) {
		String text;
		EditText edittext = (EditText)findViewById(R.id.editText1);
		if(edittext == null){
			text = "nothing is written!";
		}else{
			text = edittext.getText().toString();
		}
		Toast.makeText(this, text, Toast.LENGTH_LONG).show();
        return true;
    }
}
