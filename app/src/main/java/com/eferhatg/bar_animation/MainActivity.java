package com.eferhatg.bar_animation;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import com.eferhatg.animatedbargraph.AnimatedBarGraph;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    AnimatedBarGraph layout,layout2,layout3,layout4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int asad=((RelativeLayout) findViewById(R.id.activity_main)).getHeight();
        layout = (AnimatedBarGraph) findViewById(R.id.abg);
        layout2 = (AnimatedBarGraph) findViewById(R.id.abg2);
        layout3 = (AnimatedBarGraph) findViewById(R.id.abg3);
        layout4 = (AnimatedBarGraph) findViewById(R.id.abg4);
        Button btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                layout.AnimateBar();
                layout2.AnimateBar();
                layout3.AnimateBar();
                layout4.AnimateBar();
            }
        });


    }
}
