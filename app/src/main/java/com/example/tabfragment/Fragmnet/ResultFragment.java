package com.example.tabfragment.Fragmnet;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tabfragment.R;

public class ResultFragment extends Fragment {
    private FragmentManager fragmentManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_result, container, false);
        fragmentManager = getChildFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragA, new AFragment())
                .commit();
        Log.d("tag", "A fragment Added");

        fragmentManager.beginTransaction()
                .add(R.id.fragB, new BFragment())
                .commit();
        Log.d("tag", "B fragment Added");

        return v;
    }
}