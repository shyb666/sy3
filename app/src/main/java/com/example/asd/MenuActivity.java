package com.example.asd;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
public class MenuActivity extends AppCompatActivity {
private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_view);
        textView=findViewById(R.id.text);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.type_select_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.size1) {
         textView.setTextSize(10);
            return true;
        } else if (id == R.id.size2) {
            textView.setTextSize(16);
            return true;
        }if (id == R.id.size3) {
            textView.setTextSize(20);
            return true;
        } else if (id == R.id.toast) {
            Toast.makeText(this,"提示",Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.red) {
        textView.setTextColor(Color.parseColor("#FF0000"));
        return true;
    } else if (id == R.id.black) {
            textView.setTextColor(Color.parseColor("#000000"));
        return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
