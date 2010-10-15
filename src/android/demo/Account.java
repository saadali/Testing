package android.demo;



import android.app.Activity;
import android.database.Cursor;
import android.demo.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Account extends Activity
{
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.account);
		final DBClass _DB=new DBClass(this);
		
		Button btnCreate=(Button)findViewById(R.id.createbutton);
		Button btncancel=(Button)findViewById(R.id.cancel);
		
		
		btnCreate.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
               _DB.open();				
 				
				EditText Edit_useName=(EditText)findViewById(R.id.nname);
				EditText Edit_FullName=(EditText)findViewById(R.id.fname);
				EditText Edit_emailAddress=(EditText)findViewById(R.id.eaddress);
			    EditText Edit_password=(EditText)findViewById(R.id.pwd);
			 //   EditText Edit_conPassword=(EditText)findViewById(R.id.cpwd);
			    
			    String vUsername=Edit_useName.getText().toString().trim();
			    String vFullname=Edit_FullName.getText().toString();
			    String vEmail=Edit_emailAddress.getText().toString();
			    String vPassword=Edit_password.getText().toString();
			  //  String vConpass=Edit_conPassword.getText().toString();	
			    
			    Cursor c= _DB.getTitle(vUsername);
			    if (c.moveToFirst())
		        {
			    	String str=c.getString(0);
			    	Toast.makeText(v.getContext(), str +" This User already Exits!!!", Toast.LENGTH_LONG).show();
		        }
			    else
			    {
			    	_DB.insertTitle(vUsername, vFullname, vEmail, vPassword);
			    	Toast.makeText(v.getContext(), "SAVE SUCCESSFULLY", Toast.LENGTH_LONG).show();
			    }
		        
			   /*long ln=_DB.insertTitle(vUsername, vFullname, vEmail, vPassword);
			   if(ln>0)
			    {
			    
			    Toast.makeText(v.getContext(), "SAVE SUCCESSFULLY", Toast.LENGTH_LONG).show();
			    }
			    else
			    {
			    	Toast.makeText(v.getContext(), "This User already Exits!!!", Toast.LENGTH_LONG).show();
			    }*/
			    
		        _DB.close();
		       
				
			}
		});
		
		btncancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
		
		
	}

}
