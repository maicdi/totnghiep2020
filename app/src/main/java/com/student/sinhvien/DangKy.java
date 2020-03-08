package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
//import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class DangKy extends AppCompatActivity {
    private Button btnDangKy;
    private TextView tvDangNhap;
    // private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_ky);
        btnDangKy = (Button) findViewById(R.id.btn_dk);
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(DangKy.this, HopThongbao.class);
//                startActivity(intent);
                final EditText tentaikhoan = findViewById(R.id.edt_cmnd);
                final EditText matkhau = findViewById(R.id.edt_mk);
                final EditText hoten = findViewById(R.id.edt_hoten);
                final EditText email = findViewById(R.id.edt_email);
                final EditText sdt = findViewById(R.id.edt_sdt);
                // final ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
                if (tentaikhoan.getText().toString().trim().equals("")||matkhau.getText().toString().trim().equals("")||hoten.getText().toString().trim().equals("")||email.getText().toString().trim().equals("")||sdt.getText().toString().trim().equals("")) {
                    Toast.makeText(DangKy.this, "Hãy nhập đầy đủ thông tin! ", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        DBconnect DBconnect = new DBconnect();
                        Connection con = DBconnect.CONN();
                        if ( con == null ) {
                            Toast.makeText(DangKy.this, "Hãy kiểm tra lại kết nối ", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            try {

                                //         String  = "select * from DANGKY where tentk='" + tentaikhoan + "' and matkhau='" + matkhau + "' and hoten='" + hoten + "' and sdt='" + sdt +"' and email='" + email +  "'";
//                        Statement stmt = con.createStatement();
//                        ResultSet rs = stmt.executeQuery(query);
                                PreparedStatement pst = con.prepareStatement("insert into DANGKY values(?,?,?,?,?)");
                                pst.setString(1, tentaikhoan.getText().toString().trim());
                                pst.setString(2, hoten.getText().toString().trim());
                                pst.setString(3, matkhau.getText().toString().trim());
                                pst.setString(4, sdt.getText().toString().trim());
                                pst.setString(5, email.getText().toString().trim());
                                pst.executeUpdate();
                                Toast.makeText(getApplicationContext(),"Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(DangKy.this, DangNhap.class));
                                con.close();
                            } catch (SQLException e) {
                                Toast.makeText(getApplicationContext(),"kiểm tra lại thông tin đăng ký", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }
                    catch (Exception ex)
                    {
                        Toast.makeText(getApplicationContext(),"Hãy kiểm tra lại thông tin đăng ký", Toast.LENGTH_SHORT).show();
                        //               progressBar.setVisibility(View.INVISIBLE);
                    }
                }


            }

        });
        tvDangNhap = (TextView) findViewById(R.id.tv_dn);
        tvDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangKy.this, DangNhap.class);
                startActivity(intent);
            }
        });
    }
}
