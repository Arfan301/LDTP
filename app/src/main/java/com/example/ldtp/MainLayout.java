package com.example.ldtp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.example.ldtp.databinding.ActivityMainBinding;
import com.example.ldtp.databinding.ActivityMainLayoutBinding;

public class MainLayout extends AppCompatActivity {

    ActivityMainLayoutBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceToActivity();
//        replaceFragment(new HistoryFragment());


        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch(item.getItemId()){

                case R.id.history:
                    replaceFragment(new HistoryFragment());
                    break;
                case R.id.profile:
                    replaceToActivity();
                    break;
                case R.id.notif:
                    replaceFragment(new NotifFragment());
                    break;

            }


            return true;
        });

    }

    private void replaceFragment(Fragment fragment){

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();

    }
    public void replaceToActivity(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }

}