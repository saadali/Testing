package android.demo;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class Contacts123 extends Activity{
	 
	 
	public static final String Key_Full_Name = "f_name";
	public static final String Key_User_Name = "n_username";
    DBClass _DB=new DBClass(this);
    
    public void onCreate(Bundle savedInstanceState)
	{
		try
		{				
		super.onCreate(savedInstanceState);
		setContentView(R.layout.listview);
		
		ListView _list=(ListView)findViewById(R.id.list);
		_DB.open();
		Cursor cursor=_DB.getAllTitles();
		/*if (cursor.moveToFirst())
        {
            do {          
            	Toast.makeText(getApplicationContext(), 
	                    "NAME : " + cursor.getString(1) + "\n" + "First Name :" + cursor.getString(0)+ "\n" + "Email :" + cursor.getString(2)+ "\n" + "Password :" + cursor.getString(3),Toast.LENGTH_LONG).show();      
            } while (cursor.moveToNext());
        }*/
		
		startManagingCursor(cursor);
		String[] fields = new String[] {
				Key_Full_Name
        };
		SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, cursor,
                fields, new int[] {R.id.TextView01});
        _list.setAdapter(adapter);
        //ListAdapter adapter = new SimpleCursorAdapter(this, R.layout.row, cursor, fields, new int[] {R.id.TextView01});
      //  setListAdapter(adapter);
        _list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            
			@Override
			public void onItemClick(AdapterView<?> parent, View childView, int position, long id) {
				Cursor c = (Cursor) parent.getItemAtPosition(position);
				Integer mNamendex = c.getColumnIndex(Key_User_Name);
				String value=c.getString(mNamendex);
				Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
				Intent intent = new Intent(Contacts123.this,Contacts123.class);
				intent.putExtra("User_name", value);
		        startActivityForResult(intent, 0);
				
			}
		});
		_DB.close();
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	

    /*@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
		
		//integer mNamendex = cursor.getColumnIndex(People.NAME);

		Cursor c = (Cursor) parent.getItemAtPosition(position);
		Integer mNamendex = c.getColumnIndex(Key_Full_Name);
		String value=c.getString(mNamendex);
		Toast.makeText(getApplicationContext(), value, Toast.LENGTH_LONG).show();
		
		


		
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}*/
	
}


