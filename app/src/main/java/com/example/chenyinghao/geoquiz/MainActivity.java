package com.example.chenyinghao.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mTrueButton;
    private Button mfalseButton;
    private Button mNextButton;
    private TextView mQuestionTextview;
    private TrueFalse[] mQuestionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans,true),
            new TrueFalse(R.string.question_mideast,false),
            new TrueFalse(R.string.question_africa,false),
            new TrueFalse(R.string.question_americas,true),
            new TrueFalse(R.string.question_asia,true),
    };
    private int mCurrentIndex =0;
    private void updateQuestion(){
        int question = mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextview.setText(question);
    }
    private void checkAnswer(boolean userPressedTrue){
        boolean answerIsTrue=mQuestionBank[mCurrentIndex].isTrueQuestion();
        int messageResId=0;
        if(userPressedTrue == answerIsTrue){
            messageResId = R.string.correct_toast;
        }else {
            messageResId = R.string.incorrect_toast;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT)
                .show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuestionTextview=(TextView)findViewById(R.id.question_text_view);
        final int question= mQuestionBank[mCurrentIndex].getQuestion();
        mQuestionTextview.setText(question);

        mTrueButton=(Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
                checkAnswer(true);
            }
        });
        mfalseButton=(Button)findViewById(R.id.false_button);
        mfalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                checkAnswer(false);
            }
        });
        mNextButton = (Button)findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex=(mCurrentIndex + 1)%mQuestionBank.length;
                int question=mQuestionBank[mCurrentIndex].getQuestion();
                mQuestionTextview.setText(question);
            }
        });
        mQuestionTextview = (TextView)findViewById(R.id.question_text_view);
        mQuestionTextview.setText(question);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCurrentIndex=(mCurrentIndex + 1) % mQuestionBank.length;
                mQuestionTextview.setText(question);
                updateQuestion();
            }
        });
        updateQuestion();


    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;

    }
}
