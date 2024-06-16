package it.kiocode.il2cppandroidcheats.components;

// shitty code that i should rewrite

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

import it.kiocode.il2cppandroidcheats.Utils;

class ColorList {
    public static int get_colorWhite() {
        return Color.WHITE;
    }

    public static int get_colorLeft() {
        return Color.parseColor("#1F1F1D");
    }

    public static int get_colorBlue() {
        return Color.parseColor("#1F1F1D");
    }

    public static int get_colorBlack() {
        return Color.parseColor("#1F1F1D");
    }

    public static int get_colorGray() {
        return Color.parseColor("#1F1F1D");
    }

    public static int get_colorHeader() {
        return Color.parseColor("#1F1F1D");
    }

}

public class Menu
{
    protected int WIDTH,HEIGHT;

    public Typeface google(Context yes) {return Typeface.createFromAsset(yes.getAssets(), "Font.ttf");}

    protected Context context;
    public FrameLayout _parentBox;
    protected LinearLayout __page;
    protected ScrollView __scroll;

    private static native String name();
    private static native String name2();

    public ArrayList<LinearLayout> pages = new ArrayList<>();

    public ArrayList<Block> blocks = new ArrayList<>();
    public ArrayList<PageButton> _pagebuttons = new ArrayList<>();
    public ArrayList<LinearLayout> __pages = new ArrayList<>();

    public TextView __pagetitle;
    public ImageView __pagesrc;
    boolean _isShow = false;
    public boolean _isShow2 = false;
    public ImageView _icon;

    public LinearLayout menulayout,linear7,_close,linear8,_pages,_scroll,l1;
    public TextView textview12,textview13,close,name2;


    protected WindowManager wmManager;
    protected WindowManager.LayoutParams wmParams;

    protected void init(Context context) {

        this.context = context;

        _parentBox = new FrameLayout(context);

        _parentBox.setOnTouchListener(handleMotionTouch);
        wmManager = ((Activity)context).getWindowManager();
        int aditionalFlags=0;
        if (Build.VERSION.SDK_INT >= 11)
            aditionalFlags = WindowManager.LayoutParams.FLAG_SPLIT_TOUCH;
        if (Build.VERSION.SDK_INT >=  3)
            aditionalFlags = aditionalFlags | WindowManager.LayoutParams.FLAG_ALT_FOCUSABLE_IM;
        wmParams = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                0,//initialX
                0,//initialy
                WindowManager.LayoutParams.TYPE_APPLICATION,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_OVERSCAN |
                        WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN |
                        aditionalFlags,
                PixelFormat.TRANSPARENT
        );
        wmParams.gravity = Gravity.CENTER;
    }

    public int dpi(float dp) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    public void showMenu() {
        _close.setRotation(0);
        _isShow = true;
        _parentBox.removeAllViews();
        _parentBox.addView(menulayout, dpi(450), dpi(21));
    }

    public void hideMenu() {
        _isShow = false;
        new Handler().postDelayed(() -> {
            _parentBox.removeAllViews();
            _parentBox.addView(_icon, dpi(80), dpi(80));
            Utils.anim(_icon, 400);
        }, 0);
    }

    public void showMenu22() {
        _isShow2 = false;
        _close.setRotation(-270);
        _parentBox.removeAllViews();
        _parentBox.addView(menulayout, dpi(450), dpi(260));

    }

    public void hideMenu22() {
        _isShow2 = true;
        _close.setRotation(0);
        _parentBox.removeAllViews();
        _parentBox.addView(menulayout, dpi(450), dpi(21));
    }
    public void newPage(final String nm) {
        LinearLayout _page = new LinearLayout(context);
        PageButton _butt = new PageButton(context, nm);
        final int pageid = __pages.size();
        __page.setOrientation(LinearLayout.VERTICAL);
        _page.setOrientation(LinearLayout.VERTICAL);
        __page.addView(_page, -1, -1);
        _page.setVisibility(View.GONE);
        __pages.add(_page);
        _butt.callback = new PageButton.Callback() {
            public void onClick() {
                __pagetitle.setText(nm);
                showPage(pageid);
            }
        };

        _pagebuttons.add(_butt);
        _pages.addView(_butt);
    }

    public void showPage(final int id) {
        for (PageButton pg: _pagebuttons) {
            pg.hide();
        }
        for (LinearLayout layout: __pages) {
            layout.setVisibility(View.GONE);
        }
        __pages.get(id).setVisibility(View.VISIBLE);
        _pagebuttons.get(id).show();
        Utils.anim(__pages.get(id), 400);
    }

    public int newBlock(int pageid, String[] names) {
        final int blockid = blocks.size();

        LinearLayout blockline = new LinearLayout(context);
        blockline.setOrientation(LinearLayout.HORIZONTAL);

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            Block block = new Block(context, name);
            blocks.add(block);

            if (names.length > 1) {
                if ((i != 0)) {
                    LinearLayout expand = new LinearLayout(context);
                    blockline.addView(expand, dpi(5), -1);
                }
            }
            blockline.addView(block, new LinearLayout.LayoutParams(-1, -1, 1));

        }
        __pages.get(pageid).addView(blockline, -1, -2);
        return blockid;
    }

    @SuppressLint("SetTextI18n")
    public Menu(Context context)
    {
        init(context);

        _icon = new ImageView(context);
        {
            Utils.SetAssets(context,_icon, "icon.png");
        }

        menulayout = new LinearLayout(context);
        {
            menulayout.setOrientation(LinearLayout.VERTICAL);
            menulayout.setPadding(0, 0, 0, 0);
            menulayout.setGravity(51);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-13487809);
            design.setCornerRadius(5f);
            design.setStroke(0, -16777216);
            menulayout.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dpi(450), dpi(260), 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            menulayout.setLayoutParams(lp);
        }

        linear7 = new LinearLayout(context);
        {
            linear7.setOrientation(LinearLayout.HORIZONTAL);
            linear7.setPadding(0, 0, 0, 0);
            linear7.setGravity(19);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-14079694);
            design.setCornerRadii(new float[] { 5.0f, 5.0f, 5.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(0, -16777216);
            linear7.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, dpi(21), 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            linear7.setLayoutParams(lp);
        }
        menulayout.addView(linear7);

        _close = new LinearLayout(context);
        {
            _close.setOrientation(LinearLayout.HORIZONTAL);
            _close.setPadding(0, 0, 0, 0);
            _close.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(0);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(0, -16777216);
            _close.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dpi(27), -1, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            _close.setLayoutParams(lp);
            _close.setOnClickListener(p1 -> {
                _close.setRotation(-270);
                _parentBox.removeAllViews();
                _parentBox.addView(menulayout, dpi(450), dpi(260));
            });
        }
        linear7.addView(_close);

        textview12 = new TextView(context);
        {
            textview12.setText(">");
            textview12.setPadding(0, 0, 0, 0);
            textview12.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(0);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(1, 0);
            textview12.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -1, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            textview12.setLayoutParams(lp);
            textview12.setTextColor(-1);
            textview12.setTextSize(13.0f);
            textview12.setTypeface(Utils.font(context));
        }
        _close.addView(textview12);

        textview13 = new TextView(context);
        {
            textview13.setText(name());
            textview13.setPadding(0, 0, 0, 0);
            textview13.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(0);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(1, 0);
            textview13.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dpi(413), -1, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            textview13.setLayoutParams(lp);
            textview13.setTextColor(-1);
            textview13.setTextSize(12.0f);
            textview13.setTypeface(Utils.font(context));
        }
        linear7.addView(textview13);

        linear8 = new LinearLayout(context);
        {
            linear8.setOrientation(LinearLayout.HORIZONTAL);
            linear8.setPadding(0, 0, 0, 0);
            linear8.setGravity(51);

            GradientDrawable design = new GradientDrawable();
            design.setColor(0);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(1, -16777216);
            linear8.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -1, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            linear8.setLayoutParams(lp);
        }
        menulayout.addView(linear8);

        l1 = new LinearLayout(context);
        {
            l1.setOrientation(LinearLayout.VERTICAL);
            l1.setPadding(5,5,5,5);
            l1.setGravity(51);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-15066336);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 5.0f, 0.0f, 0.0f });
            design.setStroke(0, -16777216);
            l1.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dpi(110), -1, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 6;
            lp.bottomMargin = 0;
            l1.setLayoutParams(lp);
        }
        linear8.addView(l1);

        _pages = new LinearLayout(context);
        {
            _pages.setOrientation(LinearLayout.VERTICAL);
            _pages.setPadding(5,5,5,5);
            _pages.setGravity(51);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-15066336);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 5.0f, 0.0f, 0.0f });
            design.setStroke(0, -16777216);
            _pages.setBackgroundDrawable(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(dpi(110), dpi(195), 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 6;
            lp.bottomMargin = 0;
            _pages.setLayoutParams(lp);
        }
        l1.addView(_pages);

        name2 = new TextView(context);
        {
            name2.setText(name2());
            name2.setPadding(0, 0, 0, 0);
            name2.setGravity(17 | Gravity.BOTTOM);

            GradientDrawable design = new GradientDrawable();
            design.setColor(0);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f });
            design.setStroke(1, 0);
            name2.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -2, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            name2.setLayoutParams(lp);
            name2.setTextColor(-1);
            name2.setTextSize(8.0f);
            name2.setTypeface(Utils.font(context));
        }
        l1.addView(name2);

        close = new TextView(context);
        {
            close.setText("Close");
            close.setPadding(0, 0, 0, 0);
            close.setGravity(17);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-14079694);
            design.setCornerRadius(5f);
            design.setStroke(0, -13487809);
            close.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, dpi(23), 0);
            lp.leftMargin   = 2;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            close.setLayoutParams(lp);
            close.setTextColor(-1);
            close.setTextSize(12.0f);
            close.setTypeface(Utils.font(context));
            close.setOnClickListener(v1 -> hideMenu());
        }
        l1.addView(close);

        _scroll = new LinearLayout(context);
        {
            _scroll.setOrientation(LinearLayout.VERTICAL);
            _scroll.setPadding(5,5,5,5);
            _scroll.setGravity(51);

            GradientDrawable design = new GradientDrawable();
            design.setColor(-15066336);
            design.setCornerRadii(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 5.0f, 5.0f });
            design.setStroke(0, -16777216);
            _scroll.setBackground(design);

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(-1, -1, 0);
            lp.leftMargin   = 0;
            lp.topMargin    = 0;
            lp.rightMargin  = 0;
            lp.bottomMargin = 0;
            _scroll.setLayoutParams(lp);
        }
        linear8.addView(_scroll);

        TextView _pagetitle = new TextView(context);

        ImageView _pagesrc = new ImageView(context);

        __pagetitle = _pagetitle;
        __pagesrc = _pagesrc;

        _close.setOnClickListener(v -> {
            if (_isShow2) {
                showMenu22();
            } else {
                hideMenu22();
            }
        });

        __scroll = new ScrollView(context);
        __scroll.setFillViewport(true);

        __page = new LinearLayout(context);
        __page.setOrientation(LinearLayout.VERTICAL);

        __scroll.addView(__page, -1, -1);
        _scroll.addView(__scroll, -1, -1);

        hideMenu();
        wmManager.addView(_parentBox, wmParams);
    }

    View.OnTouchListener handleMotionTouch = new View.OnTouchListener()
    {
        private float initX;
        private float initY;
        private float touchX;
        private float touchY;

        double clock=0;

        @Override
        public boolean onTouch(View vw, MotionEvent ev)
        {

            switch (ev.getAction())
            {
                case MotionEvent.ACTION_DOWN:

                    initX = wmParams.x;
                    initY = wmParams.y;
                    touchX = ev.getRawX();
                    touchY = ev.getRawY();
                    clock = System.currentTimeMillis();
                    break;

                case MotionEvent.ACTION_MOVE:
                    wmParams.x = (int)initX + (int)(ev.getRawX() - touchX);

                    wmParams.y = (int)initY + (int)(ev.getRawY() - touchY);


                    wmManager.updateViewLayout(vw, wmParams);
                    break;

                case MotionEvent.ACTION_UP:
                    if (!_isShow && (System.currentTimeMillis() < (clock + 200)))
                    {
                        showMenu();
                    }
                    break;
            }
            return true;
        }
    };
}
