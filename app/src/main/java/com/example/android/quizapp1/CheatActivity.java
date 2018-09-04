package com.example.android.quizapp1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private static final String EXTRA_ANSWER_IS_TRUE = "com.example.android.quizapp1.answer_is_true";
    private static final String EXTRA_ANSWER_SHOWN = "com.example.android.quizapp1.answer_shown";
    private boolean mAnswerIsTrue;
    private TextView mAnswerTextView;
    private int mTextResId;
    private Button mShowAnswer;
    private final static String TAG = "CheatActivity";
    private final static String KEY_RESID = "resid";

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        Log.w(TAG, getString(R.string.on_saved_instance_state));
        savedInstanceState.putInt(KEY_RESID, mTextResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_cheat);
        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);

        mAnswerTextView = findViewById(R.id.answer_text_view);
        mShowAnswer = findViewById(R.id.show_answer_button);

        mTextResId = R.string.default_string;

        if (savedInstanceState != null){
            mTextResId = savedInstanceState.getInt(KEY_RESID,0);
            mAnswerTextView.setText(mTextResId);
        }

        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mAnswerIsTrue) {
                    mAnswerTextView.setText(R.string.true_button);
                    mTextResId = R.string.true_button;
                } else {
                    mAnswerTextView.setText(R.string.false_button);
                    mTextResId = R.string.false_button;
                }

                setAnswerShownResult(true);

            }
        });
    }

    public static boolean wasAnswerShown (Intent result){

        return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
    }

    private void setAnswerShownResult(boolean isAnswerShown){

        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        setResult(RESULT_OK, data);
    }

    public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
        Intent i = new Intent(packageContext, CheatActivity.class);
        i.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
        return i;
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.w(TAG, getString(R.string.on_pause_log));
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.w(TAG, getString(R.string.on_start_log));
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.w(TAG, getString(R.string.on_stop_log));
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.w(TAG, getString(R.string.on_resume_log));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.w(TAG, getString(R.string.on_destroy_log));
    }
}
