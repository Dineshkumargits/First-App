package ae.eies.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class Main3Activity extends AppCompatActivity {
    ListView listView;
    String[] options=new String[]{"Language","Set Walpaper","Set Default","Notification","Codings"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        listView=(ListView)findViewById(R.id.listview);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.options_list,options);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String value=(String)listView.getItemAtPosition(position);
                        Toast.makeText(Main3Activity.this, "position"+position+"value:"+value, Toast.LENGTH_SHORT).show();
                        if (position==4){
                            Intent adk=new Intent(Main3Activity.this,Main4Activity.class);
                            startActivity(adk);
                        }
                    }
                }
        );
    }

}
