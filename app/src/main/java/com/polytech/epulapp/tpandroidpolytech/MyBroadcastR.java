package com.polytech.epulapp.tpandroidpolytech;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import static android.content.Context.NOTIFICATION_SERVICE;

/**
 * Created by Epulapp on 29/11/2017.
 */

public class MyBroadcastR extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extra = intent.getExtras();

            NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context);
            mBuilder.setSmallIcon(R.drawable.notification_icon);
            mBuilder.setContentTitle("My notification");
            mBuilder.setContentText("Hello World!");

            Intent resultIntent = new Intent(context, MainActivity.class);
            TaskStackBuilder staskBuilder = TaskStackBuilder.create(context);
            staskBuilder.addParentStack(MainActivity.class);
            staskBuilder.addNextIntent(resultIntent);
            PendingIntent resultPendingIntent =
                    staskBuilder.getPendingIntent(

                            0,
                            PendingIntent.FLAG_UPDATE_CURRENT
                    );
            mBuilder.setContentIntent(resultPendingIntent);
            NotificationManager mNotifyMgr =
                    (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);

            mNotifyMgr.notify(001, mBuilder.build());
        }

}
