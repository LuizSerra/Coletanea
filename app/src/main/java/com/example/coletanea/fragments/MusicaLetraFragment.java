package com.example.coletanea.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.coletanea.R;
import com.example.coletanea.model.Musica;

/**
 * Created by LCCS on 27/06/2017.
 */

public class MusicaLetraFragment extends Fragment {

    public static final String EXTRA_MUSICA = "musica";
    public static final String TAG_LETRA = "tagDetalhe";

    TextView mTextTitulo;
    TextView mTextletra;

    Musica mMusica;

    public static MusicaLetraFragment getInstance(Musica musica){
        Bundle params = new Bundle();
        params.putSerializable(EXTRA_MUSICA, musica);
        MusicaLetraFragment fragment =  new MusicaLetraFragment();
        fragment.setArguments(params);
        return fragment;

    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mMusica = (Musica) getArguments().getSerializable(EXTRA_MUSICA);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        super.onCreateView(inflater,container,savedInstanceState);

        View layout = inflater.inflate(R.layout.fragment_letra_musica, container, false);
        mTextTitulo = layout.findViewById(R.id.txtTitulo);
        mTextletra = layout.findViewById(R.id.txtLetra);

       if(mMusica!=null){
           mTextTitulo.setText(mMusica.getTitulo());
           mTextletra.setText(mMusica.getLetra());
       }

        return layout;
    }



}
