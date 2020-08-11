package com.mystartup.lionortigeranimation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    String playerOne;
    String playerTwo;
    enum Player{

        ONE, TWO
    }
    TextView winnerText;

    Player currentPlayer = Player.ONE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        winnerText = findViewById(R.id.winnerText);


    }

    public void imageIsTapped(View view){

        ImageView img = (ImageView) view;
        if(currentPlayer == Player.ONE){
            img.setImageResource(R.drawable.tiger);
            img.animate().rotation(360f).setDuration(2000);
            String tag = img.getTag().toString();
            checkIfPlayerOneWins(tag);
            currentPlayer = Player.TWO;
        }
        else  if( currentPlayer == Player.TWO){


            img.setImageResource(R.drawable.lion);
            img.animate().rotation(360f).setDuration(2000);
            String tag = img.getTag().toString();
            checkIfPlayerTwoWins(tag);
            currentPlayer = Player.ONE;
        }


    }

    public void checkIfPlayerOneWins(String tag) {
        playerOne += tag;

        if ((playerOne.contains("a") && playerOne.contains("b") && playerOne.contains("c"))
                || (playerOne.contains("a") && playerOne.contains("d") && playerOne.contains("g"))
                || (playerOne.contains("b") && playerOne.contains("e") && playerOne.contains("h"))
                || (playerOne.contains("c") && playerOne.contains("f") && playerOne.contains("i"))
                || (playerOne.contains("d") && playerOne.contains("e") && playerOne.contains("f"))
                || (playerOne.contains("g") && playerOne.contains("h") && playerOne.contains("i"))
        ) {
            if (winnerText.getText() == "") {
                winnerText.setText(R.string.playerOneWins);
            }


        }
    }

    public void checkIfPlayerTwoWins(String tag){
        playerTwo += tag;

        if((playerTwo.contains("a")&&playerTwo.contains("b")&&playerTwo.contains("c"))
                ||(playerTwo.contains("a")&&playerTwo.contains("d")&&playerTwo.contains("g"))
                ||(playerTwo.contains("b")&&playerTwo.contains("e")&&playerTwo.contains("h"))
                ||(playerTwo.contains("c")&&playerTwo.contains("f")&&playerTwo.contains("i"))
                ||(playerTwo.contains("d")&&playerTwo.contains("e")&&playerTwo.contains("f"))
                ||(playerTwo.contains("g")&&playerTwo.contains("h")&&playerTwo.contains("i"))
        )

        {
            if (winnerText.getText() == "") {
                winnerText.setText(R.string.playerTwoWins);
            }
        }


    }

}