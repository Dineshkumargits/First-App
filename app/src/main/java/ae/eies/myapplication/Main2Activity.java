package ae.eies.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import static ae.eies.myapplication.R.id.logout_id;


public class Main2Activity extends AppCompatActivity {
    Button btn;
    EditText ed1;
    TextView td1;
    String text;

;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btn=(Button)findViewById(R.id.button);
        ed1=(EditText)findViewById(R.id.editText);
        td1=(TextView)findViewById(R.id.textView);








        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text=ed1.getText().toString();
                td1.setText(text);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.logout_id){


            session.setloggedin(false);
            finish();
            startActivity(new Intent(Main2Activity.this, MainActivity.class));
        }

      if (item.getItemId()==R.id.about_us){
          Intent adk=new Intent(Main2Activity.this,Main4Activity.class);
          startActivity(adk);
      }
        return super.onOptionsItemSelected(item);
            }

}
