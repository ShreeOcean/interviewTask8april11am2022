package com.ocean.myinterviewapp8thapril11am;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ocean.myinterviewapp8thapril11am.databinding.ActivityMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    CoffeeListAdapter adapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        ApiName apiName = RetrofitApi.getInstance(ApiName.class);
        Call<List<CoffeeModel>> call =apiName.getItemDetails();
        call.enqueue(new Callback<List<CoffeeModel>>() {
            @Override
            public void onResponse(Call<List<CoffeeModel>> call, Response<List<CoffeeModel>> response) {
                if (response.isSuccessful() && response.code() == 200){
                    List<CoffeeModel> list = response.body();
                    progressDialog.dismiss();
                    adapter = new CoffeeListAdapter(MainActivity.this, list);
                    binding.recyclerView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();

                    Log.d("Popular Movie", "onResponse: " + list);

                }
            }

            @Override
            public void onFailure(Call<List<CoffeeModel>> call, Throwable t) {

            }
        });
//        call.enqueue(new Callback<CoffeeModel>() {
//            @Override
//            public void onResponse(Call<CoffeeModel> call, Response<CoffeeModel> response) {
//                if (response.isSuccessful() && response.code() == 200){
//                    CoffeeModel list = response.body();
//                    progressDialog.dismiss();
//                    adapter = new CoffeeListAdapter(MainActivity.this, (List<CoffeeModel>) list);
//                    binding.recyclerView.setAdapter(adapter);
//                    adapter.notifyDataSetChanged();
//
//                    Log.d("Popular Movie", "onResponse: " + list.getTitle() + list.getDescription());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CoffeeModel> call, Throwable t) {
//                progressDialog.dismiss();
//                Toast.makeText(MainActivity.this, ""+ t.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });

    }
}