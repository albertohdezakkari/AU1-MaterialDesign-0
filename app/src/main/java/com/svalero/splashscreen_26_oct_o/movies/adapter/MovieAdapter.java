package com.svalero.splashscreen_26_oct_o.movies.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.splashscreen_26_oct_o.R;
import com.svalero.splashscreen_26_oct_o.beans.Movie;

import java.util.ArrayList;

public class MovieAdapter
        extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private ArrayList<Movie> lstMovies;

    /*Tantos elementos como objetos
            quiera mostrar en la fila*/
    public static class MovieViewHolder
            extends RecyclerView.ViewHolder{
        public ImageView img; //0x565854
        public TextView titulo; // 0x457855
        public TextView director; // 0x487889

        public MovieViewHolder(View v){
            super(v);
            img = (ImageView) v.findViewById(R.id.imgMovie);
            titulo = (TextView) v.findViewById(R.id.txtTitulo);
            director = (TextView) v.findViewById(R.id.txtDirector);
        }
    }

    public MovieAdapter(ArrayList<Movie> lstMovies) {
        this.lstMovies = lstMovies;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                int viewType) {
        View v = LayoutInflater.
                        from(parent.getContext())
                .inflate(R.layout.row_movie,
                        parent,
                        false);
        return new MovieViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder,
                                 int position) {
            // Enlace=pintado
        // holder.img
            // Vídeo de Picasso o Glide
        Movie movie = lstMovies.get(position);

        holder.titulo.setText(movie.getTitulo());
        holder.director.setText(movie.getTitulo());

        // Picasso.with(context).load(movie.getImage()).
        //  into(holder.img);
    }

    @Override
    public int getItemCount() {
        return lstMovies.size();
    }


}
