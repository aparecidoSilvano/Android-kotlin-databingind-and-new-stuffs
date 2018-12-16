package com.example.silva.myapplication;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String DEBUG_TAG = "TESTE";
    private boolean isExpanded;

    private RelativeLayout expandableViewContainer;
    private ImageButton btExpandView;
    private TextView viewContent;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableViewContainer = findViewById(R.id.expandible_view_container);
        btExpandView = findViewById(R.id.bt_expand_layout);
        viewContent = findViewById(R.id.view_content);

        gestureDetector = new GestureDetector(this, new MyGestureDetector());

        View.OnTouchListener touchEventListener = new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                gestureDetector.onTouchEvent(event);
                return false;
            }
        };

        expandableViewContainer.setOnTouchListener(touchEventListener);
        btExpandView.setOnTouchListener(touchEventListener);

        applyFadeAnimation(10, 100);
    }

    private void applyFadeAnimation(int initialPosition, int finalPosition) {
        ValueAnimator widthAnimator = ValueAnimator.ofInt(initialPosition, finalPosition);
        widthAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                expandableViewContainer.getLayoutParams().width = (int) animation.getAnimatedValue();
                expandableViewContainer.requestLayout();
            }
        });

        widthAnimator.start();
    }

    public void expandFragment(View view) {
        if (isExpanded) {
            collapseView();
        } else {
            expandView();
        }
    }

    private void collapseView() {
        applyFadeAnimation(900, 100);
        btExpandView.setImageResource(R.drawable.ic_expand_fragment);
        viewContent.setVisibility(View.GONE);
        isExpanded = false;
    }

    private void expandView() {
        applyFadeAnimation(100, 900);
        btExpandView.setImageResource(R.drawable.ic_colapse_fragment);
        viewContent.setVisibility(View.VISIBLE);
        isExpanded = true;
    }

    private void onSwipeRight() {
        expandView();
    }

    private void onSwipeLeft() {
        collapseView();
    }

    private class MyGestureDetector implements GestureDetector.OnGestureListener {

        static final int SWIPE_THRESHOLD = 100;
        static final int SWIPE_VELOCITY_THRESHOLD = 100;

        @Override
        public boolean onDown(MotionEvent e) {
            Log.d(DEBUG_TAG, "onDown: ");
            // don't return false here or else none of the other
            // gestures will work
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {

        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            Log.i(DEBUG_TAG, "onSingleTapConfirmed: ");
            return false;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            return false;
        }

        @Override
        public void onLongPress(MotionEvent e) {

        }

        @Override
        public boolean onFling(MotionEvent downEvent, MotionEvent moveEvent, float velocityX, float velocityY) {
            boolean result = false;
            float diffX = moveEvent.getX() - downEvent.getX();
            float diffY = moveEvent.getY() - downEvent.getY();

            if (Math.abs(diffX) > Math.abs(diffY)) {
                // right or left swipe
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        onSwipeRight();
                    } else {
                        onSwipeLeft();
                    }
                    result = true;
                }
            }

            return result;
        }
    }
}
