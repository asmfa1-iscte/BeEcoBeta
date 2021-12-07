package com.example.beecobeta;

import android.app.Activity;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProfileFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private View i;

    private String user_name;
    private String user_nivel;
    private String user_pontos;
    private int user_progresso;

    public ProfileFragment() {
        // Required empty public constructor
    }

    public ProfileFragment(String user_name, String user_nivel, String user_pontos, int user_progresso) {
        this.user_name = user_name;
        this.user_nivel = user_nivel;
        this.user_pontos = user_pontos;
        this.user_progresso = user_progresso;
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProfileFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProfileFragment newInstance(String param1, String param2) {
        ProfileFragment fragment = new ProfileFragment();
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

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        i = inflater.inflate(R.layout.fragment_profile, container, false);
        setUserName(user_name);
        setUserProgress(user_progresso);
        setUserNivel(user_nivel);
        setUserPontos(user_pontos);
        return i;
    }

    public void setUserName(String s) {
        ((TextView) i.findViewById(R.id.name)).setText(s);
    }

    public void setUserProgress(int s) {
        ((ProgressBar) i.findViewById(R.id.levelProgressBar)).setProgress(s);
    }

    public void setUserNivel(String s) {
        ( (TextView) i.findViewById(R.id.level)).setText(s);
    }

    public void setUserPontos(String s) {
        ( (TextView) i.findViewById(R.id.points)).setText(s);
    }

    public void addPoints(int points) {

    }

}