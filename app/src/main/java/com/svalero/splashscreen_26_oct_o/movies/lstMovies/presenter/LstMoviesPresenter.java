package com.svalero.splashscreen_26_oct_o.movies.lstMovies.presenter;

import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.model.LstMoviesModel;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.view.LstMoviesActivity;

import java.util.ArrayList;

public class LstMoviesPresenter
        implements LstMoviesContract.Presenter
{
    private LstMoviesModel lstMoviesModel;
    private LstMoviesContract.View vista;

    public LstMoviesPresenter(LstMoviesContract.View vista) {
        this.vista = vista;
        this.lstMoviesModel = new LstMoviesModel();
    }


    @Override
    public void getMovies() {
            lstMoviesModel.getMoviesWS(new
                     LstMoviesContract.Model.OnLstMoviesListener() {
                @Override
                public void onFinished(ArrayList<Movie> movies) {
                    vista.success();
                }

                @Override
                public void onFailure(String error) {
                    vista.error();
                }
            });
            /*if("si ha ido bien"){
                vista.success();
            }else{
                vista.error();
            }*/
    }
}
