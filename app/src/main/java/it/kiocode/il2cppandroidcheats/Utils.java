package it.kiocode.il2cppandroidcheats;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.Settings;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class Utils {

    public static String host = "";

    public static void writeFile(Context context, File file, String text, String name) {
        try {
            file.createNewFile();
        } catch (Exception e) {}

        if (!Environment.getExternalStorageState().equals(
                Environment.MEDIA_MOUNTED)) {
            return;
        }
        File sdPath = Environment.getExternalStorageDirectory();

        sdPath = new File(sdPath.getAbsolutePath() + "/Alternative/CFG/");
        sdPath.mkdirs();
        File sdFile = new File(sdPath, name);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(sdFile));
            bw.write(text.trim());
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    public static String getHwid(Context ctx) {
        return Settings.Secure.getString(ctx.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String getUser(Context ctx) {
        String hwid = getHwid(ctx);
        String androidid = Build.VERSION.RELEASE;
        String manufacter = Build.MANUFACTURER;
        String user = Build.USER;
        String host = Build.HOST;
        String brand = Build.BRAND;

        String heading = "|" + hwid + "-" + manufacter + "-" + brand + "-" + user + "-" + androidid + "-" + host + "|";
        return heading;
    }

    public static void initRequest() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    public static void SetAssets(Context ctx, ImageView img, String path) {
        try {
            InputStream ims = ctx.getAssets().open(path);
            Drawable d = Drawable.createFromStream(ims, null);
            img.setImageDrawable(d);
            ims .close();
        }
        catch(IOException ex) {return;}
    }

    public static Typeface font(Context ctx) {
        return Typeface.createFromAsset(ctx.getAssets(), "Font.ttf");
    }

    public static int dp(Context context, float dp)
    {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public static String urlRequest(String str) {

        StringBuilder sb = new StringBuilder();
        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openConnection().getInputStream()));
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                sb.append(readLine);
                sb.append("\n");
            }
            bufferedReader.close();
        } catch (Exception e) {
            return e.toString();
        }
        return sb.toString().trim();
    }


    public static void anim(View v, int time) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(v, "alpha", 0, 1.0f);
        animation.setDuration(time);
        animation.start();
    }

    public static void disanim(View v, int time) {
        ObjectAnimator animation = ObjectAnimator.ofFloat(v, "alpha", 1.0f, 0);
        animation.setDuration(time);
        animation.start();
    }

    public static String getFileExtension(File file) {
        String fileName = file.getName();
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
            return fileName.substring(fileName.lastIndexOf(".")+1);
        else return "";
    }

    public static void log(Context ctx, String t) {
        Toast.makeText(ctx, t, Toast.LENGTH_LONG).show();
    }

    public static String readFromFile(Context context, File myFile) {
        StringBuilder aBuffer = new StringBuilder();
        try {
            FileInputStream fIn = new FileInputStream(myFile);
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
            String aDataRow = "";
            while ((aDataRow = myReader.readLine()) != null) {
                aBuffer.append(aDataRow).append("\n");
            }
            myReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aBuffer.toString();
    }
}
