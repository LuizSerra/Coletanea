package com.example.coletanea.activity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.coletanea.R;
import com.example.coletanea.fragments.MusicaLetraFragment;
import com.example.coletanea.model.Musica;

public class MusicaLetraActivity extends AppCompatActivity {

    public static final String EXTRA_MUSICA = "musica";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musica_letra);

        Intent intent = getIntent();
        Musica mMusica = (Musica) intent.getSerializableExtra(EXTRA_MUSICA);

        MusicaLetraFragment fragment = MusicaLetraFragment.getInstance(mMusica);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.letra,fragment,MusicaLetraFragment.TAG_LETRA);
        ft.commit();
    }


}
