package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThanhToan extends AppCompatActivity {
    private Button  buttonhuy, btnpaypal, btntaitruong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thanh_toan);
        buttonhuy = (Button) findViewById(R.id.btn_huy);
        buttonhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThanhToan.this, TrangChu.class);
                startActivity(intent);
            }
        });
        btnpaypal = (Button) findViewById(R.id.rb_pp);
        btnpaypal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThanhToan.this, TtThanhtoan.class);
                startActivity(intent);
            }
        });
        btntaitruong = (Button) findViewById(R.id.rb_tt);
        btntaitruong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ThanhToan.this, ThongbaoThanhtoan.class);
                startActivity(intent);
            }
        });
    }
}
