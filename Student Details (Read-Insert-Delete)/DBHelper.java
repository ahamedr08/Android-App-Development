package com.example.sqlitedatabase;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
public class DBHelper extends SQLiteOpenHelper{
public DBHelper(@Nullable Context context){
super(context,"student", null, 1);
}
@Override
public void onCreate(SQLiteDatabase sqLiteDatabase) {
sqLiteDatabase.execSQL("create table student(rollno int,name varchar(20),dept varchar(10))");
}
@Override
public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
sqLiteDatabase.execSQL("drop table if exists student");
onCreate(sqLiteDatabase);
}
public void deleteStudent(String rollNumber) {
SQLiteDatabase db = this.getWritableDatabase();
db.delete("student", "rollno=?", new String[]{rollNumber});
db.close();
}
}