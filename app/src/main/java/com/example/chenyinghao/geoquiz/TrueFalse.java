package com.example.chenyinghao.geoquiz;

/**
 * Created by chenyinghao on 2017/6/20.
 */

public class TrueFalse  {
    private int mQuestion;
    private boolean mTrueQuestion;

    public int getQuestion() {
        return mQuestion;
    }

    public void setQuestion(int Question) {
        this.mQuestion = Question;
    }

    public boolean isTrueQuestion() {
        return mTrueQuestion;
    }

    public void setTrueQuestion(boolean TrueQuestion) {
        this.mTrueQuestion = TrueQuestion;
    }

    public TrueFalse(int question, boolean trueQuestion){
        mQuestion=question;
        mTrueQuestion=trueQuestion;

    }
}
