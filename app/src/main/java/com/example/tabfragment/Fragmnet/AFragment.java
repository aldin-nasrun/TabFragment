package com.example.tabfragment.Fragmnet;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.tabfragment.R;
import com.example.tabfragment.ViewModel.SharedView;

public class AFragment extends Fragment {
    Button btn_result;
    EditText et_result;
    TextView tv_result;
    private SharedView sharedView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        btn_result = v.findViewById(R.id.btn_resultA);
        et_result = v.findViewById(R.id.et_resultA);
        tv_result = v.findViewById(R.id.tv_resultA);
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            sharedView.setText(et_result.getText());
            }
        });
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        sharedView = ViewModelProviders.of(getActivity()).get(SharedView.class);
        sharedView.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                tv_result.setText(charSequence);
            }
        });
    }
}