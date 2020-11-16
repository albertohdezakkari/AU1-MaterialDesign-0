package com.svalero.splashscreen_26_oct_o.movies.lstMovies.presenter;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.model.LstMoviesModel;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.view.LstMoviesActivity;

import java.util.ArrayList;

public class LstMoviesPresenter {
    private LstMoviesModel lstMoviesModel;
    private LstMoviesActivity lstMoviesActivity;
    public LstMoviesPresenter(LstMoviesActivity lstMoviesActivity) {
        this.lstMoviesActivity = lstMoviesActivity;
        this.lstMoviesModel = new LstMoviesModel();
    }

    public void getMovies(){
        /*Componente Reactivo*/
        lstMoviesModel.getMoviesWS(new LstMoviesContract.Model.
                OnLstMoviesListener() {
            @Override
            public void onFinished(ArrayList<Movie> movies) {
                lstMoviesActivity.success(movies);
            }

            @Override
            public void onFailure(String error) {
                lstMoviesActivity.error("Error en la lista Movies. ");
            }
        });

    }
}
