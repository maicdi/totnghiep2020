package com.student.sinhvien;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class DangkyXetuyen extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPaperAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);
        viewPager = (ViewPager) findViewById(R.id.viewpaper_id);
        adapter = new ViewPaperAdapter(getSupportFragmentManager());

        adapter.AddFragment(new Dkxta(),"THÔNG TIN HỒ SƠ");
        adapter.AddFragment(new Dkxtb(),"THÔNG TIN ĐĂNG KÝ");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_call);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_group);
//        tabLayout.getTabAt(0).setIcon(R.drawable.ic_star);


        ActionBar actionBar = getSupportActionBar();
        actionBar.setElevation(0);

    }
}
