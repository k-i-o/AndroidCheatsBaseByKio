package it.kiocode.il2cppandroidcheats.components;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import it.kiocode.il2cppandroidcheats.Utils;

public class PageButton extends LinearLayout {
    Context context;

    public static interface Callback {
        public void onClick();
    }
    public Callback callback;
    View __isopen;


    TextView _pagetitle;

    public void show() {
        __isopen.setVisibility(View.VISIBLE);

        {
            this.setOrientation(LinearLayout.VERTICAL);
            this.setPadding(5, 5, 5, 5);
            this.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-7722017);
            design.setCornerRadius(5f);
            design.setStroke(0, -13487809);
            this.setBackgroundDrawable(design);

            LayoutParams lp = new LayoutParams(-1, dpi(23), 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 6;
            this.setLayoutParams(lp);
        }
    }
    public int dpi(float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public void hide() {
        __isopen.setVisibility(View.GONE);

        {
            this.setOrientation(LinearLayout.VERTICAL);
            this.setPadding(5, 5, 5, 5);
            this.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-14079694);
            design.setCornerRadius(5f);
            design.setStroke(0, -13487809);
            this.setBackgroundDrawable(design);

            LayoutParams lp = new LayoutParams(-1, dpi(23), 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 6;
            this.setLayoutParams(lp);
        }
    }

    public void anim() {
        Utils.anim(this, 400);
    }

    public PageButton(Context context, String __text) {
        super(context);
        this.context = context;



        {
            this.setOrientation(LinearLayout.VERTICAL);
            this.setPadding(5, 5, 5, 5);
            this.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-14079694);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(0, -13487809);
            this.setBackgroundDrawable(design);

            LayoutParams lp = new LayoutParams(-1, dpi(23), 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 6;
            this.setLayoutParams(lp);
        }


        _pagetitle = new TextView(context);
        {
            _pagetitle.setText("TextView");
            _pagetitle.setPadding(5, 0, 5, 5);
            _pagetitle.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(0);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(1, 0);
            _pagetitle.setBackgroundDrawable(design);

            LayoutParams lp = new LayoutParams(-2, -2, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            _pagetitle.setLayoutParams(lp);
            _pagetitle.setTextColor(-1);
            _pagetitle.setTextSize(12.0f);
            _pagetitle.setTypeface(Utils.font(context));
        }
        this.addView(_pagetitle);
        LinearLayout _isopen = new LinearLayout(context);

        __isopen = _isopen;

        this.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                anim();
                if (callback != null) callback.onClick();
            }
        });
        _pagetitle.setText(__text);
    }
}
