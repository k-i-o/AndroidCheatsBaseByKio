package it.kiocode.il2cppandroidcheats;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends Activity implements KeyEvent.Callback {

    public static native void OnKeyUp();
    public static native void OnKeyDown();

    static {
        System.loadLibrary("kiocode"); // load the native module generated with cmake
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Main.start(this);
        LinearLayout lt = new LinearLayout(this);
        lt.setBackgroundColor(Color.parseColor("#FD7600"));
        setContentView(lt);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        super.onKeyUp(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_VOLUME_UP)
        {
            Toast.makeText(MainActivity.this,"Up working",Toast.LENGTH_SHORT).show();
            OnKeyUp();
            return true;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)
        {
            Toast.makeText(MainActivity.this,"Down working", Toast.LENGTH_SHORT).show();
            OnKeyDown();
            return true;
        }
        return false;
    }
}