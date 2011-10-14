package screen.level2;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import screen.level3.MyCampusDetailActivity;
import screen.main.R;
 
public class MyCampusDeptActivity extends ListActivity {
 
   // final private static String[] DEPT = { "CS Dept", "EE Dept", "Business Dept", "Arts Dept" };
 
    @Override
    public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
       
		String[] BUILDINGS = new String[] { "CS Dept", "EE Dept", "Business Dept", "Arts Dept" };
        
		setListAdapter(new ArrayAdapter<String>(this, R.layout.building_list, BUILDINGS));
    }
        
               	public void onListItemClick( ListView parent, View v, int position, long id)  {
                Intent intent = new Intent(MyCampusDeptActivity.this, MyCampusDetailActivity.class);
                 Object o = this.getListAdapter().getItem(position);
                 intent.putExtra("keyword", o.toString());
                 startActivity(intent);
                 finish();
            } 
    }
    
 