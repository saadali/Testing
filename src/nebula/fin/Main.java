package nebula.fin;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.TextView;



public class Main extends Activity implements OnItemSelectedListener
{
	//public static final String Key_Full_Name = "f_name";
    //DBClass _DB=new DBClass(this);
    
    public void onCreate(Bundle savedInstanceState)
	{
		try
		{				
		super.onCreate(savedInstanceState);
		setContentView(R.layout.contents);
		Button signout = (Button) this.findViewById(R.id.signout);
		TextView txtcalc=(TextView)this.findViewById(R.id.txtcalc);
		
		if (signout.isClickable()) {

			signout.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					Intent intent = new Intent();
					setResult(RESULT_OK, intent);
					finish();

				}
			});
		}
		//if (txtcalc.isClickable()) {

			txtcalc.setOnClickListener(new View.OnClickListener() {
				public void onClick(View view) {
					//setContentView(R.layout.calculator);
					Intent intent = new Intent(Main.this,Calculator.class);
			        startActivity(intent);
					

				}
			});
		
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_LONG).show();
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
