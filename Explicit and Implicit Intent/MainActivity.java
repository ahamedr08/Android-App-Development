package com.example.intent;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void startExplicitIntent(View view) {
        Intent explicitIntent = new Intent(this, MainActivity2.class);
        startActivity(explicitIntent);
    }
    public void startImplicitIntent(View view) {
        Intent implicitIntent = new Intent(Intent.ACTION_VIEW);
        implicitIntent.setData(android.net.Uri.parse("https://www.google.com"));
        startActivity(implicitIntent);
    }
}
