package it.kiocode.il2cppandroidcheats;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import java.util.Locale;

import it.kiocode.il2cppandroidcheats.components.Checkbox;
import it.kiocode.il2cppandroidcheats.components.Menu;
import it.kiocode.il2cppandroidcheats.components.Slider;

public class Main {
    protected static Context context;

    public static native void ChangesInt(int feature, int value);
    public static native void ChangesBool(int feature, boolean value);
    public static native String[] getFeatures();

    public static void start(final Context context) {
        Main.context = context;
//        if (context.checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
//                || context.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
//            ((Activity) context).requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
//            init(context);
//        } else {
            init(context);
//        }
    }

    public static void init(final Context context) {
        Handler handler = new Handler();
        handler.postDelayed(() -> {
            System.loadLibrary("kiocode");

            try {
                new Main().MenuMain(context);
            } catch(Exception e) {
                Toast.makeText(context, e.toString(), Toast.LENGTH_LONG).show();
            }
        }, 3000);
    }

    public final void MenuMain(final Context context) {

        Main.context = context;
        final Menu menu = new Menu(context);

        String[] ft = getFeatures();
        for (String token: ft) {
            final String[] args = token.split("_");
            String text;
            int id, page, block;

            switch (args[0]) {
                case "page":
                    menu.newPage(args[1]);
                    break;
                case "BLOCK":
                    id = Integer.parseInt(args[1]);
                    String[] blockParts = args[2].split(",");

                    menu.newBlock(id, blockParts);
                    break;
                case "slider":
                    id = Integer.parseInt(args[1]);
                    page = Integer.parseInt(args[2]);
                    text = args[3];
                    int max = Integer.parseInt(args[4]);
                    int current = Integer.parseInt(args[5]);
                    
                    Slider slider = new Slider(context, text, max, current);
                    slider.setCallback(cvalue -> ChangesInt(id, cvalue));
                    menu.__pages.get(page).addView(slider);
                    break;
                case "switch":
                    id = Integer.parseInt(args[1]);
                    block = Integer.parseInt(args[2]);
                    text = args[3];

                    Checkbox button = new Checkbox(context);
                    button.setText(text);
                    button.setCallback(check -> ChangesBool(id, check));
                    menu.blocks.get(block).main.addView(button);
                    break;
            }
        }
    }

}

