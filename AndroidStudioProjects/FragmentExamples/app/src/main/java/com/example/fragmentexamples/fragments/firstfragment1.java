package com.example.fragmentexamples.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.fragmentexamples.R;

public class firstfragment1  extends Fragment {
    private Button btncalculate;
    private EditText etfirst, second;
    public firstfragment1(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

       View view = inflater.inflate(R.layout.first_fragment1, container, false);
       etfirst = view.findViewById(R.id.etfirst);// yo layout ma used vayekowidgets reference
       second = view.findViewById(R.id.second);
       btncalculate =view.findViewById(R.id.btncalculate);
       btncalculate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               int first = Integer.parseInt(etfirst.getText().toString());
               int seconds= Integer.parseInt(second.getText().toString());
               int result = first+seconds;
               Toast.makeText(getActivity(),"the sum is: " +result,Toast.LENGTH_LONG).show();
           }
       });


        return view;
    }
}
