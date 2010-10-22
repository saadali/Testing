package android.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ExpandableListActivity;
import android.os.Bundle;
import android.widget.SimpleExpandableListAdapter;

public class Contacts extends ExpandableListActivity{
	 
	 
		    static final String colors[] = {
			  "Family",
			  "Friends",
			  "Other Contacts"
			 
			};

			static final String shades[][] = {
		// Shades of grey
			  {
				"lightgrey",
				"dimgray",
				"sgi gray 92"
			  },
		// Shades of blue
			  {
				"dodgerblue 2",
				"steelblue 2",
				"powderblue"
			  },
		// Shades of yellow
			  {
				"yellow 1",
				"gold 1",
				"darkgoldenrod 1"
			  }
		    };

		    /** Called when the activity is first created. */
		    @Override
		    public void onCreate(Bundle icicle)
		    {
		        super.onCreate(icicle);
		        setContentView(R.layout.explist);
				SimpleExpandableListAdapter expListAdapter =
					new SimpleExpandableListAdapter(
						this,
						createGroupList(),	// groupData describes the first-level entries
						R.layout.child_row,	// Layout for the first-level entries
						new String[] { "colorName" },	// Key in the groupData maps to display
						new int[] { R.id.childname },		// Data under "colorName" key goes into this TextView
						createChildList(),	// childData describes second-level entries
						R.layout.child_row,	// Layout for second-level entries
						new String[] { "shadeName" },	// Keys in childData maps to display
						new int[] { R.id.childname}	// Data under the keys above go into these TextViews
					);
				setListAdapter( expListAdapter );
		    }

		/**
		  * Creates the group list out of the colors[] array according to
		  * the structure required by SimpleExpandableListAdapter. The resulting
		  * List contains Maps. Each Map contains one entry with key "colorName" and
		  * value of an entry in the colors[] array.
		  */
			private List createGroupList() {
			  ArrayList result = new ArrayList();
			  for( int i = 0 ; i < colors.length ; ++i ) {
				HashMap m = new HashMap();
			    m.put( "colorName",colors[i] );
				result.add( m );
			  }
			  return (List)result;
		    }

		/**
		  * Creates the child list out of the shades[] array according to the
		  * structure required by SimpleExpandableListAdapter. The resulting List
		  * contains one list for each group. Each such second-level group contains
		  * Maps. Each such Map contains two keys: "shadeName" is the name of the
		  * shade and "rgb" is the RGB value for the shade.
		  */
		  private List createChildList() {
			ArrayList result = new ArrayList();
			for( int i = 0 ; i < shades.length ; ++i ) {
		// Second-level lists
			  ArrayList secList = new ArrayList();
			  for( int n = 0 ; n < shades[i].length ; n += 2 ) {
			    HashMap child = new HashMap();
				child.put( "shadeName", shades[i][n] );
			    
				secList.add( child );
			  }
			  result.add( secList );
			}
			return result;
		  }
		 
}
