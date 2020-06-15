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

public class Secondfragment2 extends Fragment {
    private Button btnarea;
    private EditText etradius;

    public  Secondfragment2(){}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment2, container, false);

       etradius = view.findViewById(R.id.etradius);// yo layout ma used vayekowidgets reference
        btnarea =view.findViewById(R.id.btnarea);


        btnarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float radius = Float.parseFloat(etradius.getText().toString());

                float area =3.14f*radius*radius;

                Toast.makeText(getActivity()," area of the Circle: " +area,Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
