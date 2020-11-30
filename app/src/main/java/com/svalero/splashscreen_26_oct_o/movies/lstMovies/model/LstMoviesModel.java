package com.svalero.splashscreen_26_oct_o.movies.lstMovies.model;

import android.os.AsyncTask;
import android.os.Handler;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class LstMoviesModel
        implements LstMoviesContract.Model
        {
            private static final
                        String URL ="https://api.themoviedb.org/3/movie/popular";
            private ArrayList<Movie> lstArrayMovies;
            OnLstMoviesListener onLstMoviesListener;

            @Override
            public void getMoviesWS(final OnLstMoviesListener onLstMoviesListener) {
                    this.onLstMoviesListener = onLstMoviesListener;
            }

            /*MONTO LA CÁPSULA QUE ME PERMITE VIAJAR AL API*/

            class TareaInvisibleQueTraeLosDatosDelAPI
                    extends AsyncTask<String, Integer, Boolean>{

                @Override
                protected Boolean doInBackground(String... strings) {
                    Post post = new Post();

                    HashMap<String, String> datos = new HashMap();
                    // CLAVE-VALOR
                    datos.put("api_key", "d9c4177bb1cc819d43088d25fbe2474c");
                    datos.put("language", "es-ES");
                    datos.put("page", "1");
                    try {
                        JSONObject objectMovies = post.getServerDataGetObject(URL);
                        JSONArray lstMovies = objectMovies.getJSONArray("results");
                        lstArrayMovies = Movie.getArrayListFromJSON(lstMovies);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    return true;
                }

                @Override
                protected void onPostExecute(Boolean resp) {
                    if(resp){
                        if(lstArrayMovies!=null && lstArrayMovies.size()>0){
                            onLstMoviesListener.resolve(lstArrayMovies);
                        }
                    }else{
                        onLstMoviesListener.reject("Error al traer " +
                                "los datos del Servidor.");
                    }
                }
            }
        }
