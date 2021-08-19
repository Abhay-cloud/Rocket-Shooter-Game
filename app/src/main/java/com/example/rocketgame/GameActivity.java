package com.example.rocketgame;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Getting display object
        Display display = getWindowManager().getDefaultDisplay();
        //Getting the screen resolution into point object
        Point size = new Point();
        display.getSize(size);
        //Initializing game view object
        //this time we are also passing the screen size to the GameView constructor
        gameView = new GameView(this, size.x, size.y);

        setContentView(gameView);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

    }

    //pausing the game when activity is paused

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    //running the game when activity is resumed

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }


}