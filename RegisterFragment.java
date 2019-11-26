package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RegisterFragment extends Fragment {


    public RegisterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_register, container, false);


        Button buttonCancel = (Button) view.findViewById(R.id.bottonCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();//从栈中弹出此Fragment，在此APP中表示返回上一个页面
            }
        });


        Button buttonOk = (Button) view.findViewById(R.id.bottonOk);
        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editTextname = (EditText) view.findViewById(R.id.editTextname);
                EditText editTextpassword = (EditText) view.findViewById(R.id.editTextpassword);
                EditText editTextemail = (EditText) view.findViewById(R .id.editTextemail);
                EditText editTextphone = (EditText) view.findViewById(R.id.editTextphone);
                EditText editTextaddress = (EditText)view.findViewById(R.id.editTextaddress);
                RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.radioGroup);

                String name = editTextname.getText().toString();
                String password = editTextpassword.getText().toString();
                String email = editTextemail.getText().toString();
                String phone = editTextphone.getText().toString();
                String address = editTextaddress.getText().toString();
                boolean sex = false;
                int checkRadioId = radioGroup.getCheckedRadioButtonId();
                if (checkRadioId == R.id.radioButtonMale){
                    sex = true;
                }

                FirstActivity activity = (FirstActivity) getActivity();
                if (activity != null){
                    activity.userName = name;
                    activity.password = password;
                }

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });

        return view;
    }

}
