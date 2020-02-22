package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ThongbaoThanhtoan extends AppCompatActivity {
    private TextView x;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thongbao_thanhtoan);
        x = (TextView) findViewById(R.id.tv_x);
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThongbaoThanhtoan.this, TrangChu.class);
                startActivity(intent);
            }
        });
    }
}
