package android.demo;

import android.app.Activity;
import android.database.Cursor;
import android.demo.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;


public class Addcontacts extends Activity {
	@Override
		public void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.add_contact);
			final DBClass _DB=new DBClass(this);
			
			Button add=(Button)findViewById(R.id.add);
			Button back=(Button)findViewById(R.id.back);
			
			Spinner spinner = (Spinner) findViewById(R.id.spinner);
		    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
		            this, R.array.group_prompt, android.R.layout.simple_spinner_item);
		    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		    spinner.setAdapter(adapter);
		    
		    back.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					finish();
				}
				});
		    
		    
		    add.setOnClickListener(new View.OnClickListener() {
				
				public void onClick(View view) {
	               _DB.open();				
	 				
					EditText Edit_user=(EditText)findViewById(R.id.edittext);
					Spinner Edit_group=(Spinner)findViewById(R.id.spinner);
				
				 //   EditText Edit_conPassword=(EditText)findViewById(R.id.cpwd);
				    
				    String vuser=Edit_user.getText().toString().trim();
				    String vgroup=Edit_group.getContext().toString();
				   
				  //  String vConpass=Edit_conPassword.getText().toString();	
				    
				    Cursor d= _DB.getTitle1(vuser);
				    if (d.moveToFirst())
			        {
				    	String str=d.getString(0);
				    	Toast.makeText(view.getContext(), str +" This Contact already Exits!!!", Toast.LENGTH_LONG).show();
			        }
				    else
				    {
				    	_DB.insertTitle1(vuser,vgroup);
				    	Toast.makeText(view.getContext(), "SAVE SUCCESSFULLY", Toast.LENGTH_LONG).show();
				    }
				
				
				 _DB.close();
			       
					
			}
		});
	
	
	}
}
		
	
	
