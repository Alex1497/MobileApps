package mx.tec.lab01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class TargetActivity extends AppCompatActivity {
    TextView myTextView;
    Intent currentIntent;
    String myStringExtra;
    int myIntegerExtra;
    Button buttonR;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_target);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        currentIntent = getIntent();

        myStringExtra = currentIntent.getStringExtra("stringToSend");
        myIntegerExtra = currentIntent.getIntExtra("integerToSend", 0);
        myTextView = findViewById(R.id.tv5);
        //myTextView.setText(myStringExtra);
        String dato = getIntent().getStringExtra("dato");
        myTextView.setText("Hello there "+dato);

        buttonR = findViewById(R.id.b2);
        buttonR.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Intent myIntent = new Intent(TargetActivity.this, MainActivity.class);
                startActivity(myIntent);
            }
        });
    }

}
