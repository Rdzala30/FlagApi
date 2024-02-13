package com.example.flagapi;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

// MainActivity Class.
public class MainActivity extends AppCompatActivity {

    private CountriesAdapter adapter;

    // onCreate Method.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // recycler view
        // variable declaration
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CountriesAdapter();
        recyclerView.setAdapter(adapter);

        fetchCountryList(); // load country data from API.
    }

    private void fetchCountryList() { // fetching country data.
        ApiClient apiClient = Retrofit.getClient().create(ApiClient.class);
        // API Call
        Call<List<CountryList>> call = apiClient.getCountries("name,capital,flag");
        call.enqueue(new Callback<List<CountryList>>() {
            @Override
            public void onResponse(@NonNull Call<List<CountryList>> call, @NonNull Response<List<CountryList>> response) {
                // success
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setCountries(response.body());
                }
                // fail
                else {
                    Toast.makeText(MainActivity.this, "Failed to fetch data", Toast.LENGTH_SHORT).show();
                }
            }

            // handling API failure.
            @Override
            public void onFailure(@NonNull Call<List<CountryList>> call, @NonNull Throwable t) {
                Log.e("API Error", "Error fetching data", t);
                Toast.makeText(MainActivity.this, "Error fetching data", Toast.LENGTH_SHORT).show();
            }
        });
    }
}