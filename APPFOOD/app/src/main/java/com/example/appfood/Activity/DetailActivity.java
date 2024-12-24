package com.example.appfood.Activity;

import android.os.Bundle;

import com.bumptech.glide.Glide;
import com.example.appfood.Domain.Foods;
import com.example.appfood.Helper.ManagmentCart;
import com.example.appfood.R;
import com.example.appfood.databinding.ActivityDetailBinding;

public class DetailActivity extends BaseActivity {
ActivityDetailBinding binding;
private Foods object;
private int num = 1;
private ManagmentCart managmentCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getWindow().setStatusBarColor(getResources().getColor(R.color.black));

        getIntentExtra();
        setVariable();
    }

    private void setVariable() {
        managmentCart=new ManagmentCart(this);

        binding.backBtn.setOnClickListener(view -> finish());{
            Glide.with(DetailActivity.this)
                    .load(object.getImagePath())
                    .into(binding.pic);
            binding.priceTxt.setText("$"+object.getPrice());
            binding.titleTxt.setText(object.getTitle());
            binding.descriptioTxt.setText(object.getDescription());
            binding.rateTxt.setText(object.getStar()+"Rating");
            binding.ratingBar2.setRating((float) object.getStar());
            binding.totalTxt.setText(object.getPrice()+"$");


            binding.plusBtn.setOnClickListener(view -> {
                num=num+1;
                binding.numTxt.setText(num+" ");
                binding.totalTxt.setText("$"+(num* object.getPrice()));
            });

            binding.minusTxt.setOnClickListener(view -> {
                if (num>1){
                    num=num-1;
                    binding.numTxt.setText(num+"");
                    binding.totalTxt.setText("$"+(num* object.getPrice()));
                }
            });

            binding.addBtn.setOnClickListener(view -> {
                object.setNumberInCart(num);
                managmentCart.insertFood(object);
            });
        };
    }

    private void getIntentExtra() {
        object= (Foods) getIntent().getSerializableExtra("object");
    }
}