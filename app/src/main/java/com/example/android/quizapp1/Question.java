package com.example.android.quizapp1;

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public Question(int textResId, boolean answerTrue){

        mTextResId = textResId;
        mAnswerTrue = answerTrue;

    }

    public boolean isAnswertrue(){
        return mAnswerTrue;
    }

    public int getmTextResId() {
        return mTextResId;
    }

}
