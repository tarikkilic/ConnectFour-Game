package com.tarikkilic.connectfour;

import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.GridLayout;
import android.widget.TextView;
import android.view.View;

public class Pvp extends AppCompatActivity{
    int boardSize;
    GridLayout gridLayout;
    imageViews cell[][];
    Logic gameBoard;
    int timing;
    int undo[];
    int ctUndo;
    CountDownTimer cdt;
    boolean player1 = true;
    boolean player2 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pvp);
        final Context c = getApplicationContext();
        Intent intend = getIntent();
        cdt = null;
        ctUndo = 1;
        boardSize = Integer.parseInt(intend.getStringExtra("input"));
        timing = Integer.parseInt(intend.getStringExtra("time"));
        gameBoard = new Logic(boardSize);
        undo = new int[boardSize*boardSize + 1];
        gridLayout = (GridLayout) findViewById(R.id.board);
        gridLayout.setColumnCount(boardSize);
        gridLayout.setRowCount(boardSize);
        cell = new imageViews[boardSize][boardSize];
        for (int k = 0;k  < boardSize; k++){
            for (int l = 0; l  < boardSize;l++){
                cell[k][l] = new imageViews(this,k,l);
                gridLayout.addView(cell[k][l]);
            }
        }

        for(int i = 0;i < boardSize;i++){
            for(int j = 0;j < boardSize;j++)
                cell[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        imageViews v = (imageViews) view;
                        int status = 1;
                        for (int row = 0; row < boardSize; row++) {
                            if (status == 1) {
                                if(timing != 0){
                                    if(cdt != null){
                                        cdt.cancel();
                                        MyCounter1();
                                    }
                                    else
                                        MyCounter1();
                                }
                                if (player1) {
                                    if (gameBoard.get(boardSize - row - 1,v.getJ()) == 0) {
                                        cell[boardSize - row - 1][v.getJ()].setBlue();
                                        gameBoard.setMavi(boardSize - row - 1, v.getJ());
                                        player1 = false;
                                        player2 = true;
                                        undo[ctUndo] = v.getJ();
                                        ctUndo++;
                                        status = 0;
                                    }
                                } else if (player2) {
                                    if (gameBoard.get(boardSize - row - 1, v.getJ()) == 0) {
                                        cell[boardSize - row - 1][v.getJ()].setYellow();
                                        gameBoard.setSari(boardSize - row - 1, v.getJ());
                                        player1 = true;
                                        player2 = false;
                                        undo[ctUndo] = v.getJ();
                                        ctUndo++;
                                        status = 0;
                                    }
                                }
                            }
                        }
                        //Oyun bitis icin gerekli kontroller
                        if(gameBoard.isFinishedMavi() == 1 || gameBoard.crossFinishedMavi() == 1){
                            Intent intent =  new Intent(getApplicationContext(),player1.class);
                            startActivity(intent);
                        }
                        else if(gameBoard.isFinishedSari() == 2 || gameBoard.crossFinishedSari() == 2){
                            Intent intent =  new Intent(getApplicationContext(),player2.class);
                            startActivity(intent);
                        }
                        else if(gameBoard.isFilled() == 1){
                            Intent intent =  new Intent(getApplicationContext(),draw.class);
                            startActivity(intent);
                        }
                    }
                });
            }
    }

    public void MyCounter1() {
        cdt = new CountDownTimer(timing * 1000, 1000) {
            @Override
            public void onTick(long mill) {
                TextView left = (TextView) findViewById(R.id.leftTime);
                left.setText("Left: " + mill / 1000);
            }

            public void onFinish() {
                TextView left = (TextView) findViewById(R.id.leftTime);
                left.setText("Left: 0");
                if(player1){
                    gameBoard.randMavi(cell);
                    player1 = false;
                    player2 = true;
                    undo[ctUndo] = gameBoard.getLastJ();
                    ctUndo++;
                    cdt.start();
                }
                else if(player2){
                    gameBoard.randSari(cell);
                    player1 = true;
                    player2 = false;
                    undo[ctUndo] = gameBoard.getLastJ();
                    ctUndo++;
                    cdt.start();
                }
                //Oyun bitis icin gerekli kontroller
                if(gameBoard.isFinishedMavi() == 1 || gameBoard.crossFinishedMavi() == 1){
                    Intent intent =  new Intent(getApplicationContext(),player1.class);
                    startActivity(intent);
                }
                else if(gameBoard.isFinishedSari() == 2 || gameBoard.crossFinishedSari() == 2){
                    Intent intent =  new Intent(getApplicationContext(),player2.class);
                    startActivity(intent);
                }
                else if(gameBoard.isFilled() == 1){
                    Intent intent =  new Intent(getApplicationContext(),draw.class);
                    startActivity(intent);
                }
            }
        };
        cdt.start();
    }

    public void Undo(View v){
        boolean status = true;
        if(ctUndo > 0){
            for(int i = 0;i < boardSize;++i){
                if(undo[ctUndo - 1] == i){
                    for(int j = 0;j < boardSize;j++){
                        if(gameBoard.get(j,i) != 0){
                            if(status){
                                if(timing != 0){
                                    if(cdt != null){
                                        cdt.cancel();
                                        MyCounter1();
                                    }
                                    else
                                        MyCounter1();
                                }
                                if(player1){
                                    cell[j][i].setEmpty();
                                    gameBoard.setBosluk(j, i);
                                    player1 = false;
                                    player2 = true;
                                    ctUndo--;
                                    status = false;
                                }
                                else if(player2){
                                    cell[j][i].setEmpty();
                                    gameBoard.setBosluk(j, i);
                                    player1 = true;
                                    player2 = false;
                                    ctUndo--;
                                    status = false;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
