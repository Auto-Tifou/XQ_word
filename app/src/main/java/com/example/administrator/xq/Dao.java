package com.example.administrator.xq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Administrator on 2019/7/3 0003.
 */

public class Dao {
    private PersonSQLiteOpenHelper helper;

    public Dao(Context context) {
        helper=new PersonSQLiteOpenHelper(context);
    }
    public long add(String name,String number){  //添加
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",name);
        values.put("number",number);
        Long id=db.insert("person",null,values);
        db.close();
        return id;
    }
    public  int update(String name,String newnumber){   //更新
        SQLiteDatabase db=helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("number",newnumber);
        int number=db.update("person",values,"name=?",new String[]{name});
        db.close();
        return number;
    }
    public int delete(String name){    //删除
        SQLiteDatabase db=helper.getWritableDatabase();
        int number=db.delete("person","name=?",new String[]{name});
        db.close();
        return number;
    }
    public boolean find(String name){   //查
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.query("person",null,"name=?",new String[]{name},null,null,null);
        boolean result=cursor.moveToNext();
        cursor.close();
        db.close();
        return result;
    }
    public String query(String name){    //查询
        SQLiteDatabase db=helper.getWritableDatabase();
        Cursor cursor=db.query("person",null,"name=?",new String[]{name},null,null,null);
        cursor.moveToNext();
        int index=cursor.getColumnIndex("number");
        String number=cursor.getString(index);
        return number;
    }
}

