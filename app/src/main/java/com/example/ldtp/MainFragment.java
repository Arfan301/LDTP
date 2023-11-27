package com.example.ldtp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class MainFragment extends Fragment {
    private EditText display;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        display = view.findViewById(R.id.userInput);
        display.setShowSoftInputOnFocus(false);

        view.findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                zeroBTN(view);
            }
        });

        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                oneBTN(view);
            }
        });

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                twoBTN(view);
            }
        });

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                threeBTN(view);
            }
        });

        view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fourBTN(view);
            }
        });

        view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fiveBTN(view);
            }
        });

        view.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sixBTN(view);
            }
        });

        view.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sevenBTN(view);
            }
        });

        view.findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                eightBTN(view);
            }
        });

        view.findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nineBTN(view);
            }
        });

        view.findViewById(R.id.buttonBackspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backBTN(view);
            }
        });

        view.findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearBTN(view);
            }
        });

        return view;
    }

    private void updateText(String addInput){
        display.findViewById(R.id.userInput);
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);

        if(getString(R.string.display).equals(display.getText().toString())){
            display.setText(addInput);
            display.setSelection(cursorPos + 1);
        }else {
            display.setText(String.format("%s%s%s", leftStr, addInput, rightStr));
            display.setSelection(cursorPos + 1);
        }
    }



    public void zeroBTN(View view){
        updateText("0");
    }

    public void oneBTN(View view){
        updateText("1");
    }

    public void twoBTN(View view){
        updateText("2");
    }

    public void threeBTN(View view){
        updateText("3");
    }

    public void fourBTN(View view){
        updateText("4");
    }

    public void fiveBTN(View view){
        updateText("5");
    }

    public void sixBTN(View view){
        updateText("6");
    }

    public void sevenBTN(View view){
        updateText("7");
    }

    public void eightBTN(View view){
        updateText("8");
    }

    public void nineBTN(View view){
        updateText("9");
    }

    public void clearBTN(View view){
        display.setText("");
    }

    public void backBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 &&  textLen != 0){
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }
}