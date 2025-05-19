package com.example.customtoastexample;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        btn = findViewById(R.id.btn);

        //Custom Toast

        Toast toast = new Toast(getApplicationContext());

        View view = getLayoutInflater().inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.viewToast));
        toast.setView(view);

        TextView textView = view.findViewById(R.id.toastTxt);
        textView.setText("Message sent Successfully!!");
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER,0,0);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toast.show();
            }
        });
    }


}