package com.example.kidsbook;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Apple extends Fragment {

    public Apple() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("test_frag", "onCreateView() in fragment Apple (Zach Hutz)");
        return inflater.inflate(R.layout.fragment_apple, container, false);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.i("test_frag", "onAttach() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test_frag", "onCreate() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("test_frag", "onActivityCreated() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("test_frag", "onStart() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("test_frag", "onResume() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("test_frag", "onPause() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("test_frag", "onStop() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("test_frag", "onDestroyView() in fragment Apple (Zach Hutz)");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("test_frag", "onDetach() in fragment Apple (Zach Hutz)");
    }
}
