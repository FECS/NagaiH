package com.example.nagaitask2;



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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Build;

public class MainActivity extends Activity {
	static String[] items = {"a","b","c","d","e","f","g","h","i","j","k","l","m","nagai!!!!!","o","p","q","r","s"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

        
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

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			final ListView listview;
			final View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
	        ArrayAdapter<String> adapter = new ArrayAdapter<String>(rootView.getContext(),android.R.layout.simple_list_item_1, items);
	        listview = (ListView)rootView.findViewById(R.id.listView1);
	        
	        listview.setAdapter(adapter);
	        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
	                ListView listView = (ListView) parent;
	                String item = (String) listView.getItemAtPosition(position);
	                Toast.makeText(rootView.getContext(), item + " clicked",
	                        Toast.LENGTH_LONG).show();
	            }
	        });
			return rootView;
		}
	}
//    public boolean onTouchEvent(MotionEvent event) {
//		Log.d("Touch!!", "X:" + event.getX() + ",Y:" + event.getY());
//		Toast.makeText(this, "X:" + event.getX() + ",Y:" + event.getY(), Toast.LENGTH_LONG).show();
//        return true;
//    }
//    public boolean onInterceptTouchEvent(MotionEvent event){
//		Log.d("Touch!!", "X:" + event.getX() + ",Y:" + event.getY());
//		Toast.makeText(this, "X:" + event.getX() + ",Y:" + event.getY(), Toast.LENGTH_LONG).show();
//    	return false;
//    }
//    public void textClicked(View view){
//		Log.d("Touch!!", "X:" + view.getX() + ",Y:" + view.getY());
//
//    }

}
