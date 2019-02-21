package mx.tec.lab03;

import android.app.Notification;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.widget.EditText;
import android.widget.Toast;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Activity;
import android.view.GestureDetector;





public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private static final int SWIPE_THRESHOLD = 100;

    private static final int SWIPE_VELOCITY_THRESHOLD = 100;

    private GestureDetectorCompat mDetector;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Context context;
        context = getApplicationContext();

        Toast MyToast = new Toast(context);
        MyToast.makeText(context, "This is a Toast Message", Toast.LENGTH_LONG).show();

        AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);

        DialogConf.setTitle("Confirmation Dialog");
        DialogConf.setMessage("This is the Text of the Dialog");
        DialogConf.setIcon(R.mipmap.ic_launcher);

        /*

        DialogConf.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "You answered Yes.",Toast.LENGTH_LONG).show();
                    }
                });
        DialogConf.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "You answered No.",Toast.LENGTH_LONG).show();
                    }
                });

        DialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "You closed the dialog.",Toast.LENGTH_LONG).show();
                    }
        });
        */
        final EditText TextInput = new EditText(context);
        TextInput.setTextColor(Color.BLUE);
        DialogConf.setView(TextInput);

        DialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Toast.makeText(context, "You closed the dialog.",Toast.LENGTH_LONG).show();
                    }
                });
        AlertDialog MyThirdDialog = DialogConf.create();
        MyThirdDialog.show();

        int NOTIF_ID = 1234;

        Notification.Builder NotifBuilder = new Notification.Builder(this);
        NotifBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotifBuilder.setContentTitle("Important Notification");
        NotifBuilder.setContentText("This is the detail of the notification");

        Intent notificationIntent = new Intent(context, ChildActivity.class);
        notificationIntent.putExtra("myData", "This string comes from the previous activity");
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);
        NotifBuilder.setContentIntent(contentIntent);
        NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        MyNotification.notify(NOTIF_ID, NotifBuilder.build());

        mDetector = new GestureDetectorCompat(this,this);

        mDetector.setOnDoubleTapListener(this);



    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        boolean result = false;

        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                    if (diffX > 0) {
                        Toast.makeText(getApplicationContext(), "Swipe Right." , Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this,ChildActivity.class);
                        startActivity(i);
                    } else {
                        Toast.makeText(getApplicationContext(), "Swipe Left." , Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(MainActivity.this,ChildActivity2.class);
                        startActivity(i);
                    }
                    result = true;
                }
            }
            else if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                if (diffY > 0) {
                    Toast.makeText(getApplicationContext(), "Swipe Down." , Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Swipe Up." , Toast.LENGTH_SHORT).show();
                }
                result = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }
}
