package com.example.aha1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button button=findViewById(R.id.button);
        final TextView textView=findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                textView.setTextColor(getResources().getColor(R.color.red));
            }
        });
    }
}

