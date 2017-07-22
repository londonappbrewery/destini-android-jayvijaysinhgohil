package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    TextView mStoryTextView;
    Button mButtonTop;
    Button mButtonBottom;

    StoryAnswers[] mStory = new StoryAnswers[] {
            new StoryAnswers(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryAnswers(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryAnswers(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2)
    };

    int mIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        mStoryTextView.setText(mStory[mIndex].getStory());
        mButtonTop.setText(mStory[mIndex].getButtonTop());
        mButtonBottom.setText(mStory[mIndex].getButtonBottom());

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion(mButtonTop);
            }
        });



        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateQuestion(mButtonBottom);
            }
        });

    }

    private void updateQuestion(Button button) {
        if (mIndex == 0) {
            if (button == mButtonTop) {
                setIndex(2);
            } else {
                setIndex(1);
            }
        } else if (mIndex == 1) {
            if (button == mButtonTop) {
                setIndex(2);
            } else {
                mStoryTextView.setText(R.string.T4_End);
                mButtonTop.setVisibility(View.GONE);
                mButtonBottom.setVisibility(View.GONE);
            }
        } else if (mIndex == 2) {
            if (button == mButtonTop) {
                mStoryTextView.setText(R.string.T6_End);
                mButtonTop.setVisibility(View.GONE);
                mButtonBottom.setVisibility(View.GONE);
            } else {
                mStoryTextView.setText(R.string.T5_End);
                mButtonTop.setVisibility(View.GONE);
                mButtonBottom.setVisibility(View.GONE);
            }
        }
    }

    private void setIndex (int index) {
        mIndex = index;
        mStoryTextView.setText(mStory[mIndex].getStory());
        mButtonTop.setText(mStory[mIndex].getButtonTop());
        mButtonBottom.setText(mStory[mIndex].getButtonBottom());
    }
}
