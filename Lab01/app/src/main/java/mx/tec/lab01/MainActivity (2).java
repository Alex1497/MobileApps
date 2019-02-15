package mx.tec.lab01;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button buttonNewAct;
    EditText editText;
    String word;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        editText = findViewById(R.id.editText);
        buttonNewAct = findViewById(R.id.button);
        buttonNewAct.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
             Intent myIntent = new Intent(MainActivity.this, TargetActivity.class);

             //word = editText.getText().toString();

             myIntent.putExtra("dato",  editText.getText().toString());
             //myIntent.putExtra("myInteger",  2);

             startActivity(myIntent);
            }
        });

    }
}
