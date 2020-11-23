package com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.User;

import java.util.ArrayList;

public interface LstMoviesContract {
    interface View{
        void success();
        void error();
    }
    interface Presenter{
        void getMovies();
    }
    interface Model{
        /*Me tienes que mandar el Callback,
            camino de retorno*/
        void getMoviesWS(OnLstMoviesListener onLstMoviesListener);
        /*Programación Reactiva*/
        interface OnLstMoviesListener{
            void onFinished(ArrayList<Movie> movies);
            void onFailure(String error);
        }
    }
}
