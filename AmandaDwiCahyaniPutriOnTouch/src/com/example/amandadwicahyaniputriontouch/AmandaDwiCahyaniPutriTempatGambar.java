package com.example.amandadwicahyaniputriontouch;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class AmandaDwiCahyaniPutriTempatGambar extends View implements OnTouchListener {
	List<Titik> lokasiTitik = new ArrayList<Titik>();
    Paint paint = new Paint();

    public AmandaDwiCahyaniPutriTempatGambar(Context context) {
        super(context);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setOnTouchListener(this);
        paint.setColor(Color.BLACK);
    }

    @Override
    public void onDraw(Canvas canvas) {
        for (Titik titik : lokasiTitik) {
            canvas.drawCircle(titik.x, titik.y, 2, paint);
        }
    }

    public boolean onTouch(View view, MotionEvent event) {
        Titik titik = new Titik();
        titik.x = event.getX();
        titik.y = event.getY();
        lokasiTitik.add(titik);
        invalidate();
        return true;
    }
}


class Titik {
    float x, y;
}

