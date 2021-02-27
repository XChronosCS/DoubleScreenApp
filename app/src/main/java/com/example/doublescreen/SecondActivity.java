package com.example.doublescreen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {

    private Button goBack;

    private TextView woopThought;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        goBack = (Button) findViewById(R.id.button_Go_back);
        woopThought = (TextView) findViewById(R.id.woop_thought);
        woopThought.setText(Thoughts.getRandomThought().label);

        goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                launchActivity();
            }
        });
    }

    private void launchActivity() {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


    public enum Thoughts {
        A("Down with the Patriarchy!"), B("Woop!"), C("Water is Wet!"), D("Gen 4 Remakes when?"),
        E("Hope you're having a great day!"), F("I'm scared of heights!"), G("Banana!"),
        H("The revolution is soon!"), I("I'm actually a ditto!"), J("I like trains."),
        K("I should run for President!"), L("I wish I had hands."), M("Why can I use Ice Punch?"),
        N("The meaning of life is 42"), O("Would I know if I was dumb?"), P("What happens when you close this app?"),
        Q("Subs not Dubs."), R("Bubbles!"), S("My favorite color is blurple!");

        public final String label;

        Thoughts(String label) {
            this.label = label;
        }

        public static Thoughts getRandomThought() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}