package com.example.android.mvpsample.view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.mvpsample.R;
import com.example.android.mvpsample.model.Person;
import com.squareup.picasso.Picasso;

class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView nameTextView;
    private ImageView photoImageView;
    private Person person;

    PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_tv);
        photoImageView = itemView.findViewById(R.id.photo_iv);

        itemView.setOnClickListener(this);
    }

    void bind(Person person){
        this.person = person;
        nameTextView.setText(person.getName());
        Picasso.get().load(R.drawable.vader).into(photoImageView);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(), person.getName(), Toast.LENGTH_SHORT).show();
    }
}
