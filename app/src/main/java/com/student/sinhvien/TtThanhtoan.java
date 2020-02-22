package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TtThanhtoan extends AppCompatActivity {
    private Button buttontt, buttonhuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tt_thanhtoan);
        buttontt = (Button) findViewById(R.id.btn_tieptuc);
        buttontt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TtThanhtoan.this, ThongbaoThanhtoan.class);
                startActivity(intent);
            }
        });
        buttonhuy = (Button) findViewById(R.id.btn_huy);
        buttonhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TtThanhtoan.this, ThanhToan.class);
                startActivity(intent);
            }
        });
    }
}

