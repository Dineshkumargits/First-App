package ae.eies.myapplication;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by adk on 4/4/17.
 */

public class session extends AppCompatActivity{
    SharedPreferences prefs;
    static SharedPreferences.Editor editor;
    Context ctx;
    public session(Context ctx){
        this.ctx=ctx;
        prefs=ctx.getSharedPreferences("MyApp",Context.MODE_PRIVATE);
        editor=prefs.edit();

    }
    public static void setloggedin(boolean loggedin){
        editor.putBoolean("loggedInmode",loggedin);
        editor.commit();

    }
    public boolean loggedin(){
        return prefs.getBoolean("loggedInmode",false);
    }
}
