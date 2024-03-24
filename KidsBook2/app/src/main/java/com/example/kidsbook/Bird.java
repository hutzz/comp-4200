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

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bird#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bird extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Bird() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Bird.
     */
    // TODO: Rename and change types and number of parameters
    public static Bird newInstance(String param1, String param2) {
        Bird fragment = new Bird();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.i("test_frag", "onCreateView() in fragment Bird (Zach Hutz)");
        return inflater.inflate(R.layout.fragment_bird, container, false);
    }
//    @Override
//    public void onAttach(@NonNull Context context) {
//        super.onAttach(context);
//        Log.i("test_frag", "onAttach() in fragment Bird (Zach Hutz)");
//    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("test_frag", "onCreate() in fragment Bird (Zach Hutz)");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("test_frag", "onResume() in fragment Bird (Zach Hutz)");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("test_frag", "onPause() in fragment Bird (Zach Hutz)");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("test_frag", "onDestroyView() in fragment Bird (Zach Hutz)");
    }
}