package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DkHkPhu extends AppCompatActivity {
    private Button btntieptuc,btnhuy;
    private Spinner spinnermonhoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dk_hk_phu);
        spinnermonhoc = (Spinner) findViewById(R.id.spn_dkhkp);

        List<String> list = new ArrayList<>();
        list.add("Toán cao cấp");
        list.add("Lập trình mạng");
        list.add("Lập trình căn bản");
        list.add("Lập trình nâng cao");
        list.add("Anh văn");

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnermonhoc.setAdapter(adapter);
        spinnermonhoc.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DkHkPhu.this, spinnermonhoc.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btntieptuc = (Button) findViewById(R.id.btn_tieptuc);
        btntieptuc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DkHkPhu.this, ThanhToan.class);
                startActivity(intent);
            }
        });
        btnhuy = (Button) findViewById(R.id.btn_huy);
        btnhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DkHkPhu.this, TrangChu.class);
                startActivity(intent);
            }
        });
    }
}
