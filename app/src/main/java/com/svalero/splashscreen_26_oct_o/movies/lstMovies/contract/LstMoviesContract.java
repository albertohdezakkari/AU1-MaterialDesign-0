package com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.User;

import java.util.ArrayList;

public interface LstMoviesContract {
    interface View{
        void success(ArrayList<Movie> movies);
        void error(String message);
    }
    interface Presenter{
        void getMovies();
    }
    interface Model{
        /*Me tienes que mandar el Callback,
            camino de retorno*/
        void getMoviesWS(OnLstMoviesListener onLstMoviesListener);
                /*Programación Reactiva (Callback)*/
                interface OnLstMoviesListener{
                    void resolve(ArrayList<Movie> movies);
                    void reject(String error);
                }
    }
}
