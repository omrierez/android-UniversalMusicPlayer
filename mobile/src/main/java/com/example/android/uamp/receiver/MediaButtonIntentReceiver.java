package com.example.android.uamp.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.KeyEvent;

/**
 * Created by omrierez on 3/8/16.
 */
public class MediaButtonIntentReceiver extends BroadcastReceiver {
    private static final String TAG=MediaButtonIntentReceiver.class.getSimpleName();
    public MediaButtonIntentReceiver() {
        super();
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction();
        if (Intent.ACTION_MEDIA_BUTTON.equals(intentAction)) {
            KeyEvent event = intent
                    .getParcelableExtra(Intent.EXTRA_KEY_EVENT);
            int action = event.getAction();
            if (action == KeyEvent.ACTION_DOWN) {
                Log.i(TAG, "media button pressed "+event);
            }

        }

        if (isOrderedBroadcast()) {
            abortBroadcast();
        }
    }
}