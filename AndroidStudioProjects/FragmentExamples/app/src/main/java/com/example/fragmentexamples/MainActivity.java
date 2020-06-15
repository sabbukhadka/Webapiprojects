package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragmentexamples.fragments.FirstFragment;
import com.example.fragmentexamples.fragments.SecondFragment;
import com.example.fragmentexamples.fragments.Secondfragment2;
import com.example.fragmentexamples.fragments.firstfragment1;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
//private Button btnFragment;
//private  Boolean status = true;

    //for table layouts
    private ViewPager viewPager;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //for table layouts

        tabLayout = findViewById(R.id.tabid);
        viewPager =findViewById(R.id.viewpager);
        ViewPagerAdapter adapter =new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new firstfragment1(), "Calculate sum");
        adapter.addFragment(new Secondfragment2(), "Area of circle");

        viewPager.setAdapter(adapter);;
        tabLayout.setupWithViewPager(viewPager);
//for table layouts

//        btnFragment = findViewById(R.id.btnFragment);
//
//        btnFragment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                FragmentManager fragmentManager = getSupportFragmentManager();
//                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
//
//                if (status){
//                    FirstFragment first = new FirstFragment();
//                    fragmentTransaction.add(R.id.fragmentContainer, first);
//                    fragmentTransaction.commit();
//                    btnFragment.setText("Load Second Fragment");
//                    status= false;
//                }else{
//                    SecondFragment second = new SecondFragment();
//                    fragmentTransaction.add(R.id.fragmentContainer, second);
//                    fragmentTransaction.commit();
//                    btnFragment.setText("Load First Fragment");
//                    status= true;
//                }
//            }
//        });
    }
}
