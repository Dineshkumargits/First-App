package ae.eies.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.util.Log;

/**
 * Created by adk on 4/4/17.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String Tag =DataBaseHelper.class.getSimpleName();
    public static final String DB_NAME="login.db";
    public static final int DB_VERSION=1;
    public static final String USER_TABLE="users";
    //public static final String COL_ID="id";
    public static final String COL_EMAIL="email";
    public static final String COL_PASS="pass";
    public static final String CREATE_TABLE_USERS="create table "+USER_TABLE+"("+COL_EMAIL+" TEXT,"+COL_PASS+" TEXT);";


    
    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null,DB_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USERS);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+USER_TABLE);
        onCreate(db);

    }
    public void adduser(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(COL_EMAIL,email);
        values.put(COL_PASS,password);
        long id=db.insert(USER_TABLE,null,values);
        db.close();
        Log.e(Tag,"USER INSERTED "+id);

    }
    public boolean getuser(String email, String pass)
    {
        String selectQuery="select * from "+USER_TABLE+" where "+COL_EMAIL+"="+"'"+email+"'"+" and "+COL_PASS+"="+"'"+pass+"'";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(selectQuery,null);
        cursor.moveToFirst();
        if (cursor.getCount()>0) {
            return true;
        }
        cursor.close();
        db.close();
        return false;
    }
}
