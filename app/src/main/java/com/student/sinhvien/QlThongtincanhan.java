package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QlThongtincanhan extends AppCompatActivity {
    private Button btnqlcn, btndcn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ql_thongtincanhan);
        btnqlcn = (Button) findViewById(R.id.btn_ttcn);
        btnqlcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QlThongtincanhan.this, Thongtincanhan.class);
                startActivity(intent);
            }
        });
        btndcn = (Button) findViewById(R.id.btn_dcn);
        btndcn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(QlThongtincanhan.this, Diemcanhan.class);
                startActivity(intent);
            }
        });
    }
}
