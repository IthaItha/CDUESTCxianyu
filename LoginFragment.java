package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.snackbar.Snackbar;

public class LoginFragment extends Fragment {
    EditText editTextName;
    EditText editTextPassword;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v =  inflater.inflate(R.layout.fragment_login,container,false);

        editTextName = (EditText) v.findViewById(R.id.editTextname);
        editTextPassword = (EditText) v.findViewById(R.id.editTextpassword);

        editTextName = (EditText) v.findViewById(R.id.editTextname);
        editTextName.setHint("请输入用户名");



        Button buttonLogin = (Button) v.findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar snackbar = Snackbar.make(view, "登陆成功", Snackbar.LENGTH_LONG);
                snackbar.show();
            }
        });


        Button buttonSign = (Button) v.findViewById(R.id.buttonSign);
        buttonSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    RegisterFragment fragment = new RegisterFragment();
                    fragmentTransaction.replace(R.id.fragment_container,fragment);
                    fragmentTransaction.addToBackStack("login");
                    fragmentTransaction.commit();

                }

        });

        return v;

    }


    @Override
    public void onViewStateRestored(@Nullable Bundle saveInstanceState){
        super.onViewStateRestored(saveInstanceState);
        FirstActivity activity = (FirstActivity) getActivity();
        if (activity != null){
            if (activity.userName != null){
                editTextName.setText(activity.userName);
            }
            if (activity.password != null){
                editTextPassword.setText(activity.password);
            }
        }
    }
}
