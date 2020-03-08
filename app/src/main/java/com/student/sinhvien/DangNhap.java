package com.student.sinhvien;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DangNhap extends AppCompatActivity {
    private Button buttontnDangNhap;
    private TextView tvDangKy,tvQuenMatKhau;
    private EditText edtcmnd,edtpw;
    String z="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dang_nhap);
        buttontnDangNhap = (Button) findViewById(R.id.btn_dn);
        buttontnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtcmnd = (EditText) findViewById(R.id.edt_cmnd);
                edtpw = (EditText) findViewById(R.id.edt_mk);
                if (edtcmnd.getText().toString().trim().equals("") || edtpw.getText().toString().trim().equals(""))
                    Toast.makeText(DangNhap.this, "Hãy nhập tên tk và mk", Toast.LENGTH_SHORT).show();
                else {
                    try {
                        DBconnect DBconnect = new DBconnect();
                        Connection con = DBconnect.CONN();
                        if (con == null) {
                            Toast.makeText(DangNhap.this, "Hãy kiểm tra kết nối", Toast.LENGTH_SHORT).show();
                        } else {
                            String userid = edtcmnd.getText().toString();
                            String password = edtpw.getText().toString();
                            String query = "select * from DANGKY where tentk='" + userid + "' and matkhau='" + password + "'";
                            Statement stmt = con.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
                            if (rs.next()) {
                                Intent intent = new Intent(DangNhap.this, TrangChu.class);
                                startActivity(intent);
                                Toast.makeText(DangNhap.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(DangNhap.this,"Sai tài khoản hoặc mật khẩu", Toast.LENGTH_SHORT).show();
                            }
                        }
                    } catch (Exception ex) {
 //                       Toast.makeText(DangNhap.this, "Đăng nhập không thành công", Toast.LENGTH_SHORT).show();
//                        z = "Exceptions";
                    }
                }
            }

        });
        tvDangKy = (TextView) findViewById(R.id.tv_dkchua);
        tvDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this, DangKy.class);
                startActivity(intent);
            }
        });
        tvQuenMatKhau = (TextView) findViewById(R.id.tv_quenmk);
        tvQuenMatKhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DangNhap.this, QuenMatKhau.class);
                startActivity(intent);
            }
        });
    }
}

