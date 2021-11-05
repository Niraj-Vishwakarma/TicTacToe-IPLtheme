package com.madebyniraj.ipltictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int counterDraw=0;
    int csk=0;
    int mi=0;
    int hold = 0;
    //0-CSK
    //1-Mi
    //2-null
    int activePlayer=0;

    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int [][] winPos = {  {0,1,2}, {3,4,5}, {6,7,8},
                        {0,3,6}, {1,4,7}, {2,5,8},
                        {0,4,8}, {2,4,6}
                       };
    //When player tap a box area
    public void playerTap(View view)
    {
        if(hold==1)
        {
            gamereset();
            return;
        }
        ImageView img  = (ImageView) view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(gamestate[tappedImage]==2)
        {
            gamestate[tappedImage] = activePlayer;
            if(activePlayer==0)
            {
                img.setImageResource(R.drawable.cskresize);
                activePlayer=1;
            }else{
                img.setImageResource(R.drawable.miresize);
                activePlayer=0;
                 }
        }
        counterDraw ++;


        for(int[] winPostion : winPos )
        {
             if(  gamestate[winPostion[0]]!=2 && gamestate[winPostion[0]]==gamestate[winPostion[1]] && gamestate[winPostion[1]]==gamestate[winPostion[2]] )
             {
                 String winner;
                 hold =1;
                 if(gamestate[winPostion[0]]==0)
                 {
                     winner= "CSK IS THE KING ";
                     csk++;
                     String cskstring = String.valueOf(csk);
                     TextView cskscore = (TextView)findViewById(R.id.scsk);
                     cskscore.setText(cskstring);


                 }else {
                     winner="MI IS THE CHAMP";
                     mi++;
                     String mistring = String.valueOf(mi);
                     TextView miscore = (TextView)findViewById(R.id.smi);
                     miscore.setText(mistring);

                 }
                 Toast.makeText(this, winner, Toast.LENGTH_SHORT).show();


             }

        }
        if(counterDraw >= 10)
        {
            Toast.makeText(this, "DRAW", Toast.LENGTH_SHORT).show();
            gamereset();


        }


    }
public void gamereset()
{
    activePlayer=1;
    counterDraw=0;
    hold =0;
    for(int i=0; i<gamestate.length; i++){
        gamestate[i] = 2;
    }
    ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
    ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);


}




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}