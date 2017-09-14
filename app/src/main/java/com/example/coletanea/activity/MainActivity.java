package com.example.coletanea.activity;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.example.coletanea.R;
import com.example.coletanea.fragments.MusicaLetraFragment;
import com.example.coletanea.fragments.MusicaListFragment;
import com.example.coletanea.model.Musica;

public class MainActivity extends Activity implements MusicaListFragment.onSelectMusic {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coletanea);
        if(isTablet()) setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public void clickMusic(Musica musica) {
        if(isTablet()){
            MusicaLetraFragment fragment = MusicaLetraFragment.getInstance(musica);
            FragmentManager fm = getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.letra,fragment,MusicaLetraFragment.TAG_LETRA);
            ft.commit();
        }
        else {
            Intent intent = new Intent(this, MusicaLetraActivity.class);
            intent.putExtra(MusicaLetraFragment.EXTRA_MUSICA, musica);
            startActivity(intent);
        }
    }

    private boolean isTablet(){
        return findViewById(R.id.letra)!= null;
    }
}
