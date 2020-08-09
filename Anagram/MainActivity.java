package com.mg.anagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv_info,tv_word;
    EditText et_guess;
    Button b_check,b_new;
    Random r;
    String d[]= {
            "one",
            "two",
            "three",
            "four",
            "five",
            "six",
            "seven",
            "this",
            "you",
            "inhale",
            "exhale",
            "fun",
            "enjoy",
            "scared",
            "television"
    };
    String currentword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_info=(TextView)findViewById(R.id.tv_info);
        tv_word=(TextView)findViewById(R.id.tv_word);
        et_guess=(EditText)findViewById(R.id.et_guess);
        b_check=(Button)findViewById(R.id.b_check);
        b_new=(Button)findViewById(R.id.b_new);
        r= new Random();
        newgame();
        b_check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (et_guess.getText().toString().equalsIgnoreCase(currentword)){
                    tv_info.setText("Awesome!");
                    b_check.setEnabled(false);
                    b_new.setEnabled(true);
                    newgame();
                }
                else {
                    tv_info.setText("Try again!");
                }
            }
        });
        b_new.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                newgame();
            }
        });

    }
    private String shuffleword(String word){
        List<String> letters= Arrays.asList(word.split(""));
        Collections.shuffle(letters);
        String shuffled="";
        for (String letter:letters){
            shuffled+=letter;
        }
        return shuffled;
    }
    private void newgame(){
        currentword=d[r.nextInt(d.length)];
        tv_word.setText(shuffleword(currentword));
        et_guess.setText("");
        b_new.setEnabled(false);
        b_check.setEnabled(true);
    }
}
