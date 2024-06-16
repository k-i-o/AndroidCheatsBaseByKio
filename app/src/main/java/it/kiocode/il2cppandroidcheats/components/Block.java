package it.kiocode.il2cppandroidcheats.components;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import it.kiocode.il2cppandroidcheats.Utils;

public class Block extends LinearLayout {
    Context context;

    public LinearLayout main;
    public ScrollView scrl;

    public float corner = 1;
    public Block(Context ctx, String name) {
        super(ctx);
        context = ctx;

        setOrientation(LinearLayout.VERTICAL);

        main = new LinearLayout(context);
        main.setOrientation(LinearLayout.VERTICAL);
        { // Main content view
            GradientDrawable menu = new GradientDrawable();
            menu.setCornerRadii(new float[] {0,0,0,0, corner, corner, corner, corner});
            menu.setColor(0);
            main.setBackgroundDrawable(menu);

            main.setPadding(0, 0, 0, 0);

            main.setMinimumHeight(Utils.dp(context, 20));
        }

        scrl = new ScrollView(context);
        scrl.addView(main, -1, -1);
        scrl.setFillViewport(true);

        addView(scrl, new LayoutParams(-1, -1));
    }
}
