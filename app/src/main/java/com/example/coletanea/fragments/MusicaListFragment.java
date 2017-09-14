package com.example.coletanea.fragments;

import android.app.Activity;
import android.app.ListFragment;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.coletanea.model.Musica;
import com.example.coletanea.util.LeitorXML;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LCCS on 26/06/2017.
 */

public class MusicaListFragment extends ListFragment {

    List<Musica> musicaList;
    MusicaTask mTask;
    ArrayAdapter<Musica> adapter;
    Activity activity;
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        activity = getActivity();
        carregaMusicas();
        /*musicaList = carregaMusicas();
        adapter = new ArrayAdapter<Musica>(getActivity(), android.R.layout.simple_list_item_1,musicaList);
        setListAdapter(adapter);*/
    }

    private void carregaMusicas(){

        if(mTask== null || mTask.getStatus()!=AsyncTask.Status.RUNNING){
            mTask = new MusicaTask();
            mTask.execute();
        }
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l,v,position,id);

        if(activity instanceof onSelectMusic){
            Musica mMusica = (Musica) l.getItemAtPosition(position);
            onSelectMusic listener = (onSelectMusic)activity;
            listener.clickMusic(mMusica);
        }

    }

    public interface onSelectMusic{
        void clickMusic(Musica musica);
    }

    class MusicaTask extends AsyncTask<Void, Void,List<Musica>>{

        @Override
        protected void onPreExecute(){
            super.onPreExecute();

        }

        @Override
        protected List<Musica> doInBackground(Void... strings) {
            List<Musica> musicas = new ArrayList<Musica>();
        /*Musica m;
        for (int i = 0; i < 10; i++) {
            m = new Musica("Musica " + i,"Letra " + i);
            musicas.add(m);
        }

        return musicas;*/
            try {
                musicas = new LeitorXML().getLista();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return musicas;
        }

        @Override
        protected  void onPostExecute(List<Musica> musicaList){
            adapter = new ArrayAdapter<Musica>(activity, android.R.layout.simple_list_item_1,musicaList);
            setListAdapter(adapter);
        }
    }

}
