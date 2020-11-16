package com.svalero.splashscreen_26_oct_o.movies.lstMovies.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.User;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.presenter.LstMoviesPresenter;

import java.util.ArrayList;

public class LstMoviesActivity extends AppCompatActivity {
    private LstMoviesPresenter lstMoviesPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_movies);

        lstMoviesPresenter = new LstMoviesPresenter(this);
        lstMoviesPresenter.getMovies();
    }
    public void success(ArrayList<Movie> lstMovies){
        Toast.makeText(this, "Lista Movies. ",
                Toast.LENGTH_SHORT).show();
        /*Intent navegar = new Intent(getBaseContext(), RegisterRelativeLayout.class);
        startActivity(navegar);*/
    }

    public void error(String err){
        Toast.makeText(this, err, Toast.LENGTH_SHORT).show();
    }
}