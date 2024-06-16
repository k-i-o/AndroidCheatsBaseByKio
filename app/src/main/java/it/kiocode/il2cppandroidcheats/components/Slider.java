package it.kiocode.il2cppandroidcheats.components;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.GradientDrawable;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import it.kiocode.il2cppandroidcheats.Utils;

public class Slider  extends LinearLayout {
    Context context;
    public TextView title, value;
    public SeekBar slider;

    public int dpi(float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public void setCallback(Callback call)
    {
    }

    public static interface Callback {
        public void onChange(int value);
    }
    public Callback callback;

    public void setValue(int v) {
        slider.setProgress(v);
        value.setText(String.valueOf(v));
        if (callback != null) callback.onChange(v);
    }

    public Slider(Context context, String text, int max, int current) {
        super(context);
        this.context = context;

        LinearLayout rightlayout = new LinearLayout(context);
        {

            slider = new SeekBar(context);
            { // SeekBar design
                slider.setMax(max);
                slider.setProgress(current);
                GradientDrawable thumb = new GradientDrawable();
                thumb.setColor(-7722017);
                thumb.setSize(dpi(8),dpi(20));
                thumb.setCornerRadius(7f);
                slider.setPadding(0,0,0,0);
                thumb.setStroke(0, Color.parseColor("#FFFFFF"));
                thumb.setTintMode(PorterDuff.Mode.MULTIPLY);
                GradientDrawable btn = new GradientDrawable();
                btn.setColor(-14079694);
                btn.setCornerRadius(6f);
                btn.setTintMode(PorterDuff.Mode.MULTIPLY);

                slider.setThumb(thumb);
                slider.setProgressDrawable(btn);

                slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar sl, int v, boolean b) {
                        setValue(v);
                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar sl) {}
                    @Override
                    public void onStartTrackingTouch(SeekBar sl) {}
                });
                rightlayout.addView(slider, dpi(180), -1);

                title = new TextView(context);
                { // Slider text
                    title.setText(text);
                    title.setTextSize(12.0f);
                    title.setTypeface(Utils.font(context));
                    title.setTextColor(Color.WHITE);
                    title.setGravity(Gravity.CENTER);
                    title.setX(dpi(2));

                    GradientDrawable design = new GradientDrawable();
                    design.setStroke(0, -1);
                    design.setColor(0);
                    design.setCornerRadius(10f);
                    setBackgroundDrawable(design);
                    setPadding(0,0,0,0);

                    rightlayout.addView(title, -2, -1);
                }

                value = new TextView(context);
                { // Slider value text
                    value.setX(dpi(-160));
                    value.setText(String.valueOf(current));
                    value.setTextSize(11f);
                    value.setTypeface(Utils.font(context));
                    value.setTextColor(Color.WHITE);
                    value.setGravity(Gravity.CENTER_VERTICAL);

                    rightlayout.addView(value, -2, -1);
                }

            }

            addView(rightlayout, new LayoutParams(-1, -1, 1));
        }

        setPadding(0,0,0,0);
        setOrientation(LinearLayout.VERTICAL);
        setLayoutParams(new LayoutParams(-1, Utils.dp(context, 20)));
    }
}


