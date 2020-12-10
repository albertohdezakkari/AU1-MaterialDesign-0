package com.svalero.splashscreen_26_oct_o.movies.lstMovies.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.RegisterRelativeLayout;
import com.svalero.splashscreen_26_oct_o.beans.Movie;
import com.svalero.splashscreen_26_oct_o.beans.User;
import com.svalero.splashscreen_26_oct_o.movies.adapter.MovieAdapter;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.contract.LstMoviesContract;
import com.svalero.splashscreen_26_oct_o.movies.lstMovies.presenter.LstMoviesPresenter;

import java.util.ArrayList;

public class LstMoviesActivity
        extends AppCompatActivity
        implements LstMoviesContract.View
        {

    private RecyclerView recycler;
    private LstMoviesPresenter lstMoviesPresenter;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lst_movies);

        lstMoviesPresenter = new LstMoviesPresenter(this);
        lstMoviesPresenter.getMovies();

        // Obtener el Recycler
        recycler = (RecyclerView) findViewById(R.id.recyclerMovies);
        recycler.setHasFixedSize(true);

        // Usar un administrador para LinearLayout
            // 1º) Tipo Lista
            // 2º) Tipo Grid
            lManager = new LinearLayoutManager(this);
            recycler.setLayoutManager(lManager);
    }

            @Override
            public void success(ArrayList<Movie> movies) {
                // Crear un nuevo adaptador
                MovieAdapter adapter = new MovieAdapter(movies);

                recycler.setAdapter(adapter);
            }

            @Override
            public void error(String message) {
                Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
            }
        }