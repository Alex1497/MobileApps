package mx.tec.lab01;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button buttonNewAct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        buttonNewAct = findViewById(R.id.button);
        buttonNewAct.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
             Intent myIntent = new Intent(MainActivity.this, TargetActivity.class);
             myIntent.putExtra("stringToSend",  "Hello World");
             myIntent.putExtra("myInteger",  2);

             startActivity(myIntent);
            }
        });

    }
}
