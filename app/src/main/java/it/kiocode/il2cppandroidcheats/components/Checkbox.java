package it.kiocode.il2cppandroidcheats.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import it.kiocode.il2cppandroidcheats.Utils;

public class Checkbox extends LinearLayout {
    Context context;
    public int dpi(float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
    public TextView title;

    public boolean isChecked = false;
    public Callback callback;

    private View checkbox;

    public Checkbox(Context ctx) {
        super(ctx);
        context = ctx;

        setOrientation(LinearLayout.HORIZONTAL);

        title = new TextView(context);
        { // Checkbox text
            title.setTextSize(10.5f);
            title.setTypeface(Utils.font(context));
            title.setTextColor(Color.WHITE);
            title.setGravity(Gravity.CENTER);
            title.setPadding(0,0,0,0);

        }

        OnClickListener clck;
        { // Click lsitener
            clck = new OnClickListener() {
                public void onClick(View v) {
                    setChecked(!isChecked);
                }
            };
            title.setOnClickListener(clck);
            setOnClickListener(clck);
        }

        addView(title, -1, -1);
        setLayoutParams(new LayoutParams(-1, Utils.dp(context, 35)));
        setChecked(false);
    }

    public static interface Callback {
        public void onChanged(boolean checked);
    }

    public void setChecked(boolean isch) {
        isChecked = isch;
        if (callback != null) callback.onChanged(isChecked);

        if (isChecked) {
            Utils.anim(checkbox, 300);

            LayoutParams lp = new LayoutParams(-1, dpi(25));
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 6;
            this.setLayoutParams(lp);

            GradientDrawable design = new GradientDrawable();
            design.setCornerRadius(5f);
            design.setColor(-7722017);
            this.setBackgroundDrawable(design);
        } else {
            LayoutParams lp = new LayoutParams(-1, dpi(25));
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 6;
            this.setLayoutParams(lp);

            GradientDrawable design = new GradientDrawable();
            design.setCornerRadius(5f);
            design.setColor(-14079694);
            this.setBackgroundDrawable(design);

            Utils.disanim(checkbox, 150);
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    Utils.anim(checkbox, 250);

                }
            }, 150);
        }
    }

    public void setCallback(Callback call) {
        callback = call;
    }

    public void setText(String t) {
        title.setText(t);
    }


}



