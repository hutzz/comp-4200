package com.example.kidsbook;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Cat#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Cat extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Cat() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Cat.
     */
    // TODO: Rename and change types and number of parameters
    public static Cat newInstance(String param1, String param2) {
        Cat fragment = new Cat();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        Log.i("test_frag", "onCreate() in Cat (Zach Hutz)");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.i("test_frag", "onCreateView() in Cat (Zach Hutz)");
        return inflater.inflate(R.layout.fragment_cat, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("test_frag", "onStart() in Cat (Zach Hutz)");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("test_frag", "onStop() in Cat (Zach Hutz)");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("test_frag", "onDestroyView() in Cat (Zach Hutz)");
    }
}