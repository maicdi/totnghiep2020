package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DkXetTuyen extends AppCompatActivity {
    private Spinner spinnergioitinh;
    private static final String TAG = "DkXetTuyen";
    private TextView Ngaysinh;
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private Button buttonhuy;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dk_xet_tuyen);
        buttonhuy = (Button) findViewById(R.id.btn_huy);
        buttonhuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DkXetTuyen.this, TrangChu.class);
                startActivity(intent);
            }
        });
        Ngaysinh = (TextView) findViewById(R.id.tvngaysinh);
        Ngaysinh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dialog = new DatePickerDialog(
                        DkXetTuyen.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        onDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        onDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                Log.d(TAG,"onDateSet: mm/dd/yyyy: " + month + "/" + day + "/" + year);
                String date = day + "/" + month + "/" + year;
                Ngaysinh.setText(date);
            }
        };
        spinnergioitinh = (Spinner) findViewById(R.id.spn_gtinh);
        List<String> list = new ArrayList<>();
        list.add("Nam");
        list.add("Nữ");
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,list);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinnergioitinh.setAdapter(adapter);
        spinnergioitinh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(DkXetTuyen.this,spinnergioitinh.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
//    public void showSelectedItem(View view){
//        String student = (String) spinnergioitinh.getSelectedItem();
//        if(student.name.equals("Chọn giới tính")){
//            Toast.makeText(DkXetTuyen.this,"Vui lòng chọn giới tính",Toast.LENGTH_SHORT).show();
//        }else
//            Toast.makeText(DkXetTuyen.this,student.name, Toast.LENGTH_SHORT).show();
//    }

}


