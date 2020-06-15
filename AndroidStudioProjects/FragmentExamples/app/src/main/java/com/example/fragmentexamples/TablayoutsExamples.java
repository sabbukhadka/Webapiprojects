package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.fragmentexamples.fragments.Secondfragment2;
import com.example.fragmentexamples.fragments.firstfragment1;
import com.google.android.material.tabs.TabLayout;

public class TablayoutsExamples extends AppCompatActivity {
private ViewPager viewPager;
private TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablayouts_examples);
        tabLayout = findViewById(R.id.tabid);
        viewPager =findViewById(R.id.viewpager);
        ViewPagerAdapter adapter =new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new firstfragment1(), "Calculate sum");
        adapter.addFragment(new Secondfragment2(), "Area of circle");

        viewPager.setAdapter(adapter);;
        tabLayout.setupWithViewPager(viewPager);

    }
}
