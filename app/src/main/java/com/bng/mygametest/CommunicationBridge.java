package com.bng.mygametest;

import android.util.Log;

import java.time.LocalDateTime;

public class CommunicationBridge {

    private static CommunicationBridge bridgeInstance;

    public static CommunicationBridge getInstance(){
        if (bridgeInstance == null){
            bridgeInstance = new CommunicationBridge();
        }
        return bridgeInstance;
    }

    private CommunicationBridge(){

    }


    public String updateScore(String score){
        Log.d("CommunicationBridge", "MyScore " + score);
        return score;
    }

    public double gameStart(){
        Log.d("CommunicationBridge", "startGame() ");
        return System.currentTimeMillis();
    }





    public String getMessage(String mansi){
        Log.d("CommunicationBridge", "getMessage() " + mansi);
        return System.currentTimeMillis() + "";
    }


    public void gameStartParam(String param){
        Log.d("CommunicationBridge", "gameStartParam() " + param);
    }


    public void gameSendScore(String score){
        PlayerFragment.updateText.setText(score);
        Log.d("CommunicationBridge", "gameSendScore() " + score);
    }

    public double gameEnd(){
        Log.d("CommunicationBridge", "gameOver() ");
        return System.currentTimeMillis();
    }

}
