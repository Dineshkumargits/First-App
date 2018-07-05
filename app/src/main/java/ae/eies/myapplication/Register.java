package ae.eies.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{
    EditText et_mail,et_pass;
    Button reg_btn;
    TextView back_text;
    private DataBaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        db=new DataBaseHelper(this);
        et_mail=(EditText)findViewById(R.id.email);
        et_pass=(EditText)findViewById(R.id.password);
        reg_btn=(Button)findViewById(R.id.register_btn);
        back_text=(TextView)findViewById(R.id.back_text);
        reg_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register_btn:
                register();
                break;
            case R.id.back_text:
                startActivity(new Intent(Register.this,MainActivity.class));
                finish();
                break;
            default:
        }
    }
    public void register(){
        String email=et_mail.getText().toString();
        String pass=et_pass.getText().toString();
        if (email.isEmpty()&&pass.isEmpty()){
            Toast.makeText(this, "The field is Empty", Toast.LENGTH_SHORT).show();
        }
        else {
            db.adduser(email,pass);
            Toast.makeText(this, "user Registered", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}
