package com.mlabs.bbm.firstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ImageView img = (ImageView) findViewById(R.id.img);
        final TextView inx = (TextView) findViewById(R.id.ix);
        final TextView iny = (TextView) findViewById(R.id.iy);
        final TextView fix = (TextView) findViewById(R.id.fx);
        final TextView fiy = (TextView) findViewById(R.id.fy);
        final TextView diffx = (TextView) findViewById(R.id.dx);
        final TextView diffy = (TextView) findViewById(R.id.dy);
        final TextView mo = (TextView) findViewById(R.id.motion);
        final TextView qd = (TextView) findViewById(R.id.quad);





        img.setOnTouchListener(new View.OnTouchListener() {



            float dposX = 0;
            float dposY = 0;
            float uposX = 0;
            float uposY = 0;


            @Override
            public boolean onTouch(View view, MotionEvent event) {
                int eventP = event.getAction();


                switch (eventP){
                    case MotionEvent.ACTION_DOWN:
                        dposX = event.getX();
                        dposY = event.getY();
                        inx.setText(String.valueOf(dposX));
                        iny.setText(String.valueOf(dposY));

                        break;
                    case MotionEvent.ACTION_UP :

                        uposX = event.getX();
                        uposY = event.getY();

                        fix.setText(String.valueOf(uposX));
                        fiy.setText(String.valueOf(uposY));

                        decide(dposX,dposY,uposX,uposY);
                        break;
                }

                return true;
            }


            public void decide(float dposX, float dposY, float uposX, float uposY ){

                float imgw = img.getMeasuredWidth()/2;
                float imgh = img.getMeasuredHeight()/2;

                String msg = "Swiped ";
                String msg2 = "";
                if (dposX < uposX){
                   msg = msg + "RIGHT";

                } else if (dposX > uposX){
                    msg = msg + "LEFT";
                }

                if (dposY < uposY){
                    msg = msg + "and DOWN";
                } else if (dposY > uposY){
                    msg = msg + "and UP";
                }


                if ((uposX > imgw) && (uposY < imgh)){
                    msg2 = "I";
                }else if ((uposX < imgw) && (uposY < imgh)){
                    msg2 = "II";
                }else if ((uposX < imgw) && (uposY > imgh)){
                    msg2 = "III";
                }else if ((uposX > imgw) && (uposY > imgh)){
                    msg2 = "IV";

                }


                mo.setText(msg);
                diffx.setText(String.valueOf(Math.abs(dposX-uposX)));
                diffy.setText(String.valueOf(Math.abs(dposY-uposY)));
                qd.setText(msg2);

            }

        });






    }
}
