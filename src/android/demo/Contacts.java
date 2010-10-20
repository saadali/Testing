package android.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Contacts extends Activity {
	 public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        TextView textview = new TextView(this);
	        textview.setText("> Family" + '\n' + "> Friends" +'\n' +"> Other Contacts");
	        setContentView(textview);
	    }
}
