package com.example.coletanea.util;

import android.content.res.AssetManager;

import com.example.coletanea.model.Musica;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by LCCS on 28/06/2017.
 */

public class LeitorXML {

        private List<Musica> lerMusicaXML() throws Exception {
            List<Musica> musicas = new ArrayList<Musica>();

            InputStream is = getArquivo();


                String tagAtual = null;
                String categoria = null;
                Musica mMusica = null;

                XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
                XmlPullParser xpp = factory.newPullParser();
                xpp.setInput(is,"UTF-8");

                int eventType = xpp.getEventType();

                while (eventType!= XmlPullParser.END_DOCUMENT){
                    if(eventType == XmlPullParser.START_TAG){
                        tagAtual = xpp.getName();
                        if("musica".equals(tagAtual)){
                             mMusica = new Musica();
                        }
                    }
                    else if(eventType == XmlPullParser.END_TAG){
                        if("musica".equals(xpp.getName())){
                            musicas.add(mMusica);
                        }
                    }
                    else if((eventType == XmlPullParser.TEXT &&!xpp.isWhitespace())){
                        String text = xpp.getText();
                        if("titulo".equals(tagAtual)){
                            mMusica.setTitulo(text);
                        }
                        else if("letra".equals(tagAtual)){
                            mMusica.setLetra(text);
                        }
                    }
                    eventType = xpp.next();
                }

            return musicas;
        }

   private InputStream getArquivo() throws Exception{
        String file= "assets/listaMusicas.xml";
       InputStream is = null;
        try {
            is = this.getClass().getClassLoader().getResourceAsStream(file);
        }catch (Exception e){
            e.printStackTrace();
        }
        return is;
    }

    public List<Musica>  getLista() throws Exception {
        return lerMusicaXML();
    }
}
