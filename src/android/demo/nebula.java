package android.demo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.demo.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;

public class nebula extends Activity {

	TextView no_nebula;
	Button cancel;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		try
		{				
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		final DBClass _DB=new DBClass(this);
		no_nebula = (TextView) this.findViewById(R.id.no_nebula);
		Button btnSign=(Button)findViewById(R.id.login);
		
		btnSign.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				_DB.open();
				EditText edit_User=(EditText)findViewById(R.id.txtUserID);
				EditText edit_Pass=(EditText)findViewById(R.id.txtPass);
				
				String vUserID=edit_User.getText().toString();
				String vPass=edit_Pass.getText().toString();				
				
				Cursor cursor=_DB.getAuthentication(vUserID, vPass);
				if (cursor.moveToFirst())
		        {
					String str=cursor.getString(0);
					Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();
					Intent intent = new Intent(nebula.this,Main.class);
			        startActivity(intent);
					
					
		        }
				else
				{
					Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_LONG).show();
				}
				
			}
		});
		
		
		
		pages();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	private void pages()
	  {
	 

		if (no_nebula.isClickable()) 
		{
			no_nebula.setOnClickListener(new TextView.OnClickListener() {
				public void onClick(View v) {				
					Intent intent = new Intent(nebula.this, Account.class);
			        startActivity(intent);

				}
			});
		}

		/*if (cancel.isClickable()) 
		  {
			cancel.setOnClickListener(new Button.OnClickListener() {
				public void onClick(View v) {				
					setContentView(R.layout.main);
				}
			});

		}*/

	}
}
