package com.example.braintrainer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;
import static java.util.logging.Logger.global;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
    int answer;
    int qAnswered = 0;
    int score = 0;



    //generateQuestion
    public void generateQuestion () {
        Button answer1 = (Button) findViewById(R.id.optionOne);
        Button answer2 = (Button) findViewById(R.id.optionTwo);
        Button answer3 = (Button) findViewById(R.id.optionThree);
        Button answer4 = (Button) findViewById(R.id.optionFour);
        TextView scores = (TextView) findViewById(R.id.scoreView);

        qAnswered++;

        scores.setText(Integer.toString(score) + "/" + Integer.toString(qAnswered));

        ArrayList<Button> buttons = new ArrayList<>(asList(answer1, answer2, answer3, answer4));
        int a, b;
        Random rand = new Random();
        int upperbound = 10;
        do { upperbound = rand.nextInt(50); }
        while (upperbound < 2);
        Log.i("upperbound", Integer.toString(upperbound));
        a = rand.nextInt(upperbound);
        do { upperbound = rand.nextInt(50); }
        while (upperbound < 2);
        b = rand.nextInt(upperbound);
        answer = a + b;
        Log.i("a", Integer.toString(a));
        Log.i("b", Integer.toString(b));
        TextView question = (TextView) findViewById(R.id.questionView);
        question.setText(Integer.toString(a) + " + " + Integer.toString(b));
        int id = rand.nextInt(4);
        buttons.get(id).setText(Integer.toString(answer));
        for ( int i = 0; i<4; i++) {
            if ( i != id)
            {
                do { upperbound = rand.nextInt(50); }
                while (upperbound < 2);

                int Fa = rand.nextInt(upperbound);
                do { upperbound = rand.nextInt(50); }
                while (upperbound < 2);
                int Fb = rand.nextInt(upperbound);
                int falseAnswer = Fa + Fb;
                buttons.get(i).setText(Integer.toString(falseAnswer));
            }
        }

    }

    public void checkAnswer (boolean answerIs) {
        if (answerIs) {
           //correct
            score++;
        }
        else {
            //incorrect
        }
        generateQuestion();
    }

    public void pressOpt1 (View view) {
        Button answer1 = (Button) findViewById(R.id.optionOne);
        if (Integer.toString(answer).equals(answer1.getText()))
        {
            checkAnswer(true);
        }
        else {
            checkAnswer(false);
        }
    }

    public void pressOpt2 (View view) {
        Button answer1 = (Button) findViewById(R.id.optionTwo);
        if (Integer.toString(answer).equals(answer1.getText()))
        {
            checkAnswer(true);
        }
        else {
            checkAnswer(false);
        }
    }

    public void pressOpt3 (View view) {
        Button answer1 = (Button) findViewById(R.id.optionThree);
        if (Integer.toString(answer).equals(answer1.getText()))
        {
            checkAnswer(true);
        }
        else {
            checkAnswer(false);
        }
    }

    public void pressOpt4 (View view) {
        Button answer1 = (Button) findViewById(R.id.optionFour);
        if (Integer.toString(answer).equals(answer1.getText()))
        {
            checkAnswer(true);
        }
        else {
            checkAnswer(false);
        }
    }

    //play game
    public void playGame () {
        Button answer1 = (Button) findViewById(R.id.optionOne);
        Button answer2 = (Button) findViewById(R.id.optionTwo);
        Button answer3 = (Button) findViewById(R.id.optionThree);
        Button answer4 = (Button) findViewById(R.id.optionFour);

        CountDownTimer timer = new CountDownTimer(30000, 100) {
            @Override
            public void onTick(long millisUntilFinished) {
                TextView time = (TextView) findViewById(R.id.timerView);
                time.setText(Integer.toString((int) millisUntilFinished / 1000) + " sec");
            }

            @Override
            public void onFinish() {
                Button button = (Button) findViewById(R.id.resetButton);
                button.setVisibility(View.VISIBLE);

                TextView question = (TextView) findViewById(R.id.questionView);
                question.setText(" ");

                answer1.setEnabled(false);
                answer2.setEnabled(false);
                answer3.setEnabled(false);
                answer4.setEnabled(false);

            }
        }.start();

        generateQuestion();

    }

    //Start or Stop
    public void resetFunc(View view) {
        Button answer1 = (Button) findViewById(R.id.optionOne);
        Button answer2 = (Button) findViewById(R.id.optionTwo);
        Button answer3 = (Button) findViewById(R.id.optionThree);
        Button answer4 = (Button) findViewById(R.id.optionFour);
        Button button = (Button) findViewById(R.id.resetButton);
        if (gameActive == true) {
            gameActive = false;
            button.setText("PLAY AGAIN!");
            button.setVisibility(View.INVISIBLE);
            //start game
            playGame();
            answer1.setEnabled(true);
            answer2.setEnabled(true);
            answer3.setEnabled(true);
            answer4.setEnabled(true);
        } else {
            //reset function
            gameActive = true;
            button.setVisibility(View.INVISIBLE);
            playGame();
            answer1.setEnabled(true);
            answer2.setEnabled(true);
            answer3.setEnabled(true);
            answer4.setEnabled(true);
         }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button answer1 = (Button) findViewById(R.id.optionOne);
        Button answer2 = (Button) findViewById(R.id.optionTwo);
        Button answer3 = (Button) findViewById(R.id.optionThree);
        Button answer4 = (Button) findViewById(R.id.optionFour);

        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);

        //First question
        //TextView question = (TextView) findViewById(R.id.questionView);
       // question.setText(generateQuestion());
    }



}