package com.example.flagapi;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


//Adapter class for displaying a list of countries in a RecyclerView.
public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountryViewHolder> {
    private List<CountryList> countries = new ArrayList<>();

    @SuppressLint("NotifyDataSetChanged")
    public void setCountries(List<CountryList> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.country_list, parent, false);
        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        CountryList countryList = countries.get(position);
        holder.bind(countryList);
    }


    @Override
    public int getItemCount() {
        return countries.size();
    }


    static class CountryViewHolder extends RecyclerView.ViewHolder {
        TextView countryName; // Country Name
        TextView capital;     // Capital Name
        ImageView flag;       // Flag Image.

        /**
         * Constructor for the ViewHolder.
         *
         * @param itemView The View that represents an individual item in the RecyclerView.
         */
        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);
            countryName = itemView.findViewById(R.id.countryName);
            capital = itemView.findViewById(R.id.countryCapital);
            flag = itemView.findViewById(R.id.countryFlag);
        }

        public void bind(CountryList countryList) {
            countryName.setText(countryList.getCountryName());
            capital.setText(countryList.getCountryCapital());
            Picasso.get().load(countryList.getCountryFlag()).into(flag);
        }
    }
}
