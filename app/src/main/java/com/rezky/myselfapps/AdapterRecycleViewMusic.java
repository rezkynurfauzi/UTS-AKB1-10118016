package com.rezky.myselfapps;

/*
 * NIM   : 10118016
 * NAMA  : Rezky Nur Fauzi
 * KELAS : IF1
 * TGL   : 30/05/2021
 * */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import javax.security.auth.Subject;

public class AdapterRecycleViewMusic  extends RecyclerView.Adapter<AdapterRecycleViewMusic.ViewHolder> {
    private String[] SubjectMusic;
    private Context context;
    public AdapterRecycleViewMusic(String[] subjectMusic, Context context) {
        SubjectMusic = subjectMusic;
        this.context = context;
    }
    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        ViewHolder(View v) {

            super(v);
            textView = v.findViewById(R.id.textItem);
        }
    }
    @NonNull
    @Override
    public AdapterRecycleViewMusic.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_music, parent, false);

        return new AdapterRecycleViewMusic.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AdapterRecycleViewMusic.ViewHolder holder, int position) {

        holder.textView.setText(SubjectMusic[position]);

    }

    @Override
    public int getItemCount() {
        return SubjectMusic.length;
    }
}
