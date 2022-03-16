package com.example.words.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.words.DetailActivity;
import com.example.words.R;

import java.util.ArrayList;
import java.util.List;

public class LetterAdapter extends RecyclerView.Adapter<LetterAdapter.LetterViewHolder> {
    Context context;
    List<Character> letters = new ArrayList<>();

    public LetterAdapter(@NonNull Context context) {
        for (char i = 'A'; i <= 'Z'; i++) {
            letters.add(i);
        }
        this.context = context;
    }

    @NonNull
    @Override
    public LetterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new LetterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LetterViewHolder holder, int position) {
        Character letter = letters.get(position);
        holder.button.setText(letter.toString());
        holder.button.setOnClickListener((view) -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("a", letter.toString());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return letters.size();
    }

    class LetterViewHolder extends RecyclerView.ViewHolder {
        Button button;

        LetterViewHolder(View view) {
            super(view);
            button = view.findViewById(R.id.button_item);
        }
    }
}
