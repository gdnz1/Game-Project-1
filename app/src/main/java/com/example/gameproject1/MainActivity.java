package com.example.gameproject1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageButton button_GoHome, button_backspace;
    TextView score_tw, answer_tw, question_tw, time_tw;
    Button button_0, button_1, button_2, button_3, button_4, button_5, button_6, button_7, button_8, button_9;
    Button button_minus, button_dot, button_enter;
    int score, questionCounter = 0, trueCounter = 0, wrongCounter = 0;
    private final String[] operators = {"+", "-", "*", "/"};
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        score = 0;
        answer_tw = findViewById(R.id.answer_tw);
        score_tw = findViewById(R.id.score_tw);
        time_tw = findViewById(R.id.time_tw);
        question_tw =findViewById(R.id.question_tw);
        question_tw.setText("0");
        button_GoHome = findViewById(R.id.button_GoHome);

        button_0 = findViewById(R.id.button_0);
        button_1 = findViewById(R.id.button_1);
        button_2 = findViewById(R.id.button_2);
        button_3 = findViewById(R.id.button_3);
        button_4 = findViewById(R.id.button_4);
        button_5 = findViewById(R.id.button_5);
        button_6 = findViewById(R.id.button_6);
        button_7 = findViewById(R.id.button_7);
        button_8 = findViewById(R.id.button_8);
        button_9 = findViewById(R.id.button_9);

        button_backspace = findViewById(R.id.button_backspace);
        button_minus = findViewById(R.id.button_minus);
        button_dot = findViewById(R.id.button_dot);
        button_enter = findViewById(R.id.button_enter);


        CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                String a1 = String.valueOf((millisUntilFinished / 1000));
                time_tw.setText(a1);
            }

            @Override
            public void onFinish() {
                showResults();
            }
        };

        countDownTimer.start();

        button_GoHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, MainActivityHome.class);
                startActivity(intent2);


            }
        });

        button_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _0 = answer_tw.getText()+"0";
                answer_tw.setText(_0);

            }
        });

        button_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _1 = answer_tw.getText()+"1";
                answer_tw.setText(_1);

            }
        });

        button_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _2 = answer_tw.getText()+"2";
                answer_tw.setText(_2);

            }
        });

        button_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _3 = answer_tw.getText()+"3";
                answer_tw.setText(_3);

            }
        });

        button_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _4 = answer_tw.getText()+"4";
                answer_tw.setText(_4);

            }
        });

        button_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _5 = answer_tw.getText()+"5";
                answer_tw.setText(_5);

            }
        });

        button_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _6 = answer_tw.getText()+"6";
                answer_tw.setText(_6);

            }
        });

        button_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _7 = answer_tw.getText()+"7";
                answer_tw.setText(_7);

            }
        });

        button_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _8 = answer_tw.getText()+"8";
                answer_tw.setText(_8);

            }
        });

        button_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _9 = answer_tw.getText()+"9";
                answer_tw.setText(_9);
            }
        });

        button_dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _do = answer_tw.getText()+".";
                answer_tw.setText(_do);

            }
        });

        button_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String _mi = answer_tw.getText()+"-";
                answer_tw.setText(_mi);
            }
        });

        button_backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String text = answer_tw.getText().toString();

                if(text.length()!=0){
                    String text2 = text.substring(0, text.length() - 1);
                    answer_tw.setText(text2);
                }
            }
        });

        button_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userAnswer = answer_tw.getText().toString();

                if(checkAnswer(userAnswer)){
                    score += 10;
                    score_tw.setText(String.valueOf(score));
                    trueCounter++;
                }else{
                    score-=5;
                    score_tw.setText(String.valueOf(score));
                    wrongCounter++;
                }

                showQuestion();
                answer_tw.setText("");
                questionCounter++;

            }


        });
        showQuestion();

    }
    private double calculateAnswer(int num1, int num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            case "/":

                if (num2 != 0) {
                    return (double) num1 / num2;
                } else {
                    return Double.NaN;
                }
            default:
                return Double.NaN;
        }
    }

    public void showQuestion() {
        boolean easy_mode = MainActivityHome.easy_mode;
        boolean medium_mode = MainActivityHome.medium_mode;
        boolean hard_mode = MainActivityHome.hard_mode;
        int n1,n2;
        String selectedOperator = operators[random.nextInt(operators.length)];
        if(easy_mode){
            n1 = random.nextInt(10);
            n2 = random.nextInt(10);
            String questionText = getString(R.string.question_format, n1, selectedOperator, n2);
            question_tw.setText(questionText);
        } else if (medium_mode) {
            n1 = random.nextInt(20);
            n2 = random.nextInt(20);
            String questionText = getString(R.string.question_format, n1, selectedOperator, n2);
            question_tw.setText(questionText);
        } else if (hard_mode) {
            n1 = random.nextInt(50);
            n2 = random.nextInt(50);
            String questionText = getString(R.string.question_format, n1, selectedOperator, n2);
            question_tw.setText(questionText);
        }

    }

    public boolean checkAnswer(String s1) {
        String question = question_tw.getText().toString();

        String[] parts = question.split(" ");
        int num1 = Integer.parseInt(parts[0]);
        String operator = parts[1];
        int num2 = Integer.parseInt(parts[2]);

        double correctAnswer = calculateAnswer(num1, num2, operator);

        try {
            double userAnswer = Double.parseDouble(s1);
            return userAnswer == correctAnswer;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private void showResults(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Results");
        builder.setMessage(" Number of Questions : "+questionCounter
                + "\n Score: "+ score+"\n True Answers: " +trueCounter
                + "\n Wrong Answers: "+ wrongCounter
        );

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent3 = new Intent(MainActivity.this, MainActivityHome.class);
                startActivity(intent3);
            }

        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                Intent intent4 = new Intent(MainActivity.this, MainActivityHome.class);
                startActivity(intent4);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

    }

}