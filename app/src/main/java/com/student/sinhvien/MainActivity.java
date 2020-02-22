package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttontndangnhap, buttontndangky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttontndangnhap = (Button) findViewById(R.id.btn_dangnhap);
        buttontndangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DangNhap.class);
                startActivity(intent);
            }
        });
        buttontndangky = (Button) findViewById(R.id.btn_dangky);
        buttontndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DangKy.class);
                startActivity(intent);
            }
        });
    }
}
