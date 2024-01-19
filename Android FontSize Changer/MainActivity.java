package com.example.aha1;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {
    Button increase;
    Button decrease;
    TextView textView;
    private float ourFontsize=14f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        increase=findViewById(R.id.button1);
        decrease=findViewById(R.id.button2);
        textView=findViewById(R.id.tv1);
        increase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ourFontsize += 4f;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontsize);
            }
        });
        decrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ourFontsize -= 4f;
                textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, ourFontsize);
            }
        });
    }
}
