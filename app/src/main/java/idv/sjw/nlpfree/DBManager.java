package idv.sjw.nlpfree;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shenf on 2017/4/4.
 */

public class DBManager {

    static final String DBName = "nlpdb";
    static final String TableName = "qustionList";
    static final int DBVersion = 1 ;

    static final String CreadteDB = "CREATE TABLE IF NOT EXIST \'" + TableName + "\'(" +
            "\'key\' INTEGER,"+
            "\'qustion\' TEXT,"+
            "\'a\' TEXT,"+
            "\'b\' TEXT,"+
            "\'c\' TEXT,"+
            "PRIMARY KEY (\'KEY\')" +
            ")";

//    CREATE TABLE `` (
//            `key`	INTEGER,
//            `qustion`	TEXT,
//            `a`	TEXT,
//            `b`	TEXT,
//            `c`	TEXT,
//    PRIMARY KEY(`key`)
//);

    static class DatabaseHelperUser extends SQLiteOpenHelper{
        Context context;
        DatabaseHelperUser(Context context){
            super(context,DBName,null,DBVersion);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL(CreadteDB);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS" + TableName);
            onCreate(db);
        }
    }



    public DBManager(Context context){


    }
}
