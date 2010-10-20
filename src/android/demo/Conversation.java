package android.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Conversation extends Activity{
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textview = new TextView(this);
        textview.setText("This is the conversation tab");
        setContentView(textview);
    }
}
