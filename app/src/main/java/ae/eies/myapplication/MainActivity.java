package ae.eies.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.jar.Attributes;

public class MainActivity extends AppCompatActivity {
    EditText et_email,et_pass;
    Button login_btn,reg_btn;
    DataBaseHelper db;
    private session session;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DataBaseHelper(this);
        session= new session(this);
        et_email=(EditText)findViewById(R.id.et_email);
        et_pass=(EditText)findViewById(R.id.et_password);
        login_btn=(Button)findViewById(R.id.login_btn);
        reg_btn=(Button)findViewById(R.id.register_btn);
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();


            }
        });
        reg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent adk=new Intent(MainActivity.this,Register.class);
                startActivity(adk);

            }
        });
        if (session.loggedin()) {
            startActivity(new Intent(MainActivity.this,Main2Activity.class));
            finish();
        }

    }

    public void login(){
        String email=et_email.getText().toString();
        String pass=et_pass.getText().toString();
        if (db.getuser(email,pass)) {
            session.setloggedin(true);
            Intent intent = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intent);
        }
        else
            Toast.makeText(this, "Wrong Entry", Toast.LENGTH_SHORT).show();
    }
}
