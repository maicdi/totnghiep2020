package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TracuuHoso extends AppCompatActivity {
    private Button btnthoat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tracuu_hoso);
        btnthoat = (Button) findViewById(R.id.btn_thoat);
        btnthoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TracuuHoso.this, TrangChu.class);
                startActivity(intent);
            }
        });
    }
}
