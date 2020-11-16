package com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.User;

import java.util.ArrayList;

public interface LstMoviesContract {
    interface View{

    }
    interface Presenter{

    }
    interface Model{
        /*Programación Reactiva*/
        interface OnLstMoviesListener{
            void onFinished(ArrayList<Movie> movies);
            void onFailure(String error);
        }
    }
}
