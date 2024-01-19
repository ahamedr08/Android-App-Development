package com.example.sqlitedatabase;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
SQLiteDatabase db;
String rno,name;
EditText editText1,editText2;
TextView textView;
Button button1,button2, button3;
@SuppressLint("MissingInflatedId")
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
DBHelper dbHelper=new DBHelper(this);
db=dbHelper.getReadableDatabase();
db=dbHelper.getWritableDatabase();
editText1=findViewById(R.id.et1);
editText2=findViewById(R.id.et2);
button1=findViewById(R.id.bt1);
button2=findViewById(R.id.bt2);
textView=findViewById(R.id.tv2);
button1.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
rno=editText1.getText().toString();
name=editText2.getText().toString();
if(rno.equals("")||name.equals(""))
Toast.makeText(getApplicationContext(),"Enter the details",Toast.LENGTH_LONG).show();
else
{
ContentValues values=new ContentValues();
values.put("rollno",rno);
values.put("name",name);
db.insert("student",null,values);
Toast.makeText(getApplicationContext(),"Inserted",Toast.LENGTH_LONG).
show();
}
}
});
button2.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
StringBuffer sb=new StringBuffer();
Cursor c=db.rawQuery("select * from student",null);
while(c.moveToNext())
{
sb.append("\n"+c.getString(0));
sb.append("---"+c.getString(1));
}
textView.setText(sb.toString());
}
});
button3 = findViewById(R.id.bt3);
button3.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
String rollNumberToDelete = editText1.getText().toString();
if (!rollNumberToDelete.isEmpty()) {
DBHelper dbHelper = new DBHelper(getApplicationContext());
dbHelper.deleteStudent(rollNumberToDelete);
Toast.makeText(getApplicationContext(), "Record deleted", Toast.LENGTH_SHORT).show();
editText1.setText(""); // Clear the roll number field
} else {
Toast.makeText(getApplicationContext(), "Enter a roll number to delete",
Toast.LENGTH_SHORT).show();
}
}
});
}
}