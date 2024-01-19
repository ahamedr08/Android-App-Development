package com.example.fontfamily;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
public class MainActivity extends AppCompatActivity {
 private TextView textView;
 private ListView fontListView;
 private String[] fontNames = {"font1", "font2"}; 
 @Override
 protected void onCreate(Bundle savedInstanceState) {
 super.onCreate(savedInstanceState);
 setContentView(R.layout.activity_main);
 textView = findViewById(R.id.textView);
 fontListView = findViewById(R.id.fontListView);
 ArrayAdapter<String> fontAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, 
fontNames);
 fontListView.setAdapter(fontAdapter);
 fontListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
 @Override
 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
 applyFont(fontNames[position]);
 }
 });
 }
 private void applyFont(String fontName) {
 Typeface typeface = ResourcesCompat.getFont(this, getResources().getIdentifier(fontName, "font", 
getPackageName()));
 textView.setTypeface(typeface);
 }
}
