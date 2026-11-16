package com.maktabati.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class SaveActivity extends Activity {
    @Override
    protected void onCreate(Bundle b) {
        super.onCreate(b);
        Intent i = getIntent();
        String text = null, title = null;
        if (Intent.ACTION_PROCESS_TEXT.equals(i.getAction())) {
            CharSequence c = i.getCharSequenceExtra(Intent.EXTRA_PROCESS_TEXT);
            if (c != null) text = c.toString();
        } else if (Intent.ACTION_SEND.equals(i.getAction())) {
            text = i.getStringExtra(Intent.EXTRA_TEXT);
            title = i.getStringExtra(Intent.EXTRA_SUBJECT);
        }
        if (text != null && text.trim().length() > 0) {
            Pending.add(this, title, text.trim());
            Toast.makeText(this, getString(R.string.saved), Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
