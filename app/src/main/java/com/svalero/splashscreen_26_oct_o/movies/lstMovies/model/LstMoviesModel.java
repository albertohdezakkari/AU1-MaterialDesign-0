package com.svalero.splashscreen_26_oct_o.movies.lstMovies.model;

import android.os.AsyncTask;
import android.os.Handler;

import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.utils.Post;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.HashMap;

public class LstMoviesModel
        implements LstMoviesContract.Model
        {
    final boolean resp = true;

            @Override
            public void getMoviesWS(final OnLstMoviesListener onLstMoviesListener) {
                    final Handler simulacion = new Handler();
                    simulacion.postDelayed(new Runnable() {
                                   @Override
                                   public void run() {
                                      if(resp){
                                          onLstMoviesListener.
                                                  onFinished();
                                      } else{
                                          onLstMoviesListener.
                                                  onFailure("Error al traer " +
                                                          "las películas. ");
                                      }
                                   }
                               }
                            , 3000);
            }
            /*MONTO LA CÁPSULA QUE ME PERMITE VIAJAR AL API*/
            class TareaInvisibleQueTraeLosDatosDelAPI
                    extends AsyncTask<String, Integer, Boolean>{
                /*SEMÁFORO=>
                 *  ROJO => doInBackground(); // URL DONDE ESTÁ LA API
                 *  AMARILLO=> Notificar el % de cumplimiento. // Integer
                 *  VERDE =>  onPostExecute(); // True/false: Ha ido bien/Ha ido mal
                 * */
                /*FIN*/

                @Override
                protected Boolean doInBackground(String... strings) {
                    // URL= "https://api.themoviedb.org/3/
                        //  movie/popular?api_key=d9c4177bb1cc819d43088d25fbe2474c&
                        //  language=es-ES&page=1"
                    // La clase que se utiliza para "CONFIGURAR" ESA PETICIÓN
                        // SE LLAMA=> POST
                    Post post = new Post();
                    String url ="https://api.themoviedb.org/3/movie/popular";
                    HashMap<String, String> datos = new HashMap();
                    // CLAVE-VALOR
                    datos.put("api_key", "d9c4177bb1cc819d43088d25fbe2474c");
                    datos.put("language", "es-ES");
                    datos.put("page", "1");

                    /* Seguir el día 30 de Noviembre
                        JSONObject listaObjectMovies = post.getServerDataPost(datos, url);
                        JSONArray listaMovies = listaObjectMovies.
                            getJSONArray("results");
                     */

                    /*for (int i = 0; i < ; i++) {
                        if(valor.equals("25514")){
                            break;
                        }
                    }*/
                    /*datos.get("25514");*/

                    return true;
                    //return false;
                }

                @Override
                protected void onPostExecute(Boolean aBoolean) {
                    super.onPostExecute(aBoolean);
                }
            }


        }
