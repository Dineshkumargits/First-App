package ae.eies.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {
    Button toast_btn;
    Button intent_btn;
    Button menu_btn;
    Button list_btn;
    Button scroll_btn;
    Button sp_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        toast_btn=(Button)findViewById(R.id.toast_button);
        intent_btn=(Button)findViewById(R.id.intent_button);
        menu_btn=(Button)findViewById(R.id.menu_button);
        list_btn=(Button)findViewById(R.id.list_button);
        scroll_btn=(Button)findViewById(R.id.scroll_button);
        sp_btn=(Button)findViewById(R.id.sp_button);

        sp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent spcodings=new Intent(Main4Activity.this,Sp_Codings.class);
                startActivity(spcodings);
            }
        });

        scroll_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent scrollcodings=new Intent(Main4Activity.this,Scroll_Codings.class);
                startActivity(scrollcodings);
            }
        });

        list_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listcodings=new Intent(Main4Activity.this,List_Codings.class);
                startActivity(listcodings);
            }
        });

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent menucodings=new Intent(Main4Activity.this,Menu_Codings.class);
                startActivity(menucodings);
            }
        });

        intent_btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intentcodings=new Intent(Main4Activity.this,Intent_codings.class);
                startActivity(intentcodings);
            }
        });

        toast_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toastcodings=new Intent(Main4Activity.this, Toast_Codings.class);
                startActivity(toastcodings);
            }
        });
    }
}
