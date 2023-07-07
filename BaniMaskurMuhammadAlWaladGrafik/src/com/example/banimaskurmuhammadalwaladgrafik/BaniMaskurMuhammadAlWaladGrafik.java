package com.example.banimaskurmuhammadalwaladgrafik;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.Menu;
import android.view.View;
import android.app.Activity;
import android.view.Menu;

public class BaniMaskurMuhammadAlWaladGrafik extends Activity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MediaGambar(this));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_bani_maskur_muhammad_al_walad_grafik, menu);
        return true;
    }

    private static class MediaGambar extends View {
        private Paint areaPaint = new Paint();

        public MediaGambar(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas) {
            Paint paint = areaPaint;
            int x, y;

            canvas.drawColor(Color.WHITE);
            paint.setColor(Color.MAGENTA);
            canvas.drawCircle(60, 60, 50, paint);
            paint.setColor(Color.BLUE);
            paint.setStrokeWidth(3);
            canvas.drawPoint(60, 60, paint);
            canvas.drawRect(180, 20, 260, 70, paint);
            paint.setStrokeWidth(1);
            paint.setColor(Color.RED);
            x = 0;
            canvas.drawLine(x + 10, 80, x + 10, 320, paint);
            y = 0;
            canvas.drawLine(0, y + 200, 400, y + 200, paint);
            paint.setColor(Color.BLUE);
            for (x = 0; x <= 360; x++) {
                y = (int) (Math.sin(x * Math.PI / 180) * 100);
                canvas.drawPoint(x + 10, y + 200, paint);
                if ((x % 90) == 0) {
                    canvas.drawText(Integer.toString(x), x + 10, 215, paint);
                    paint.setStrokeWidth(3);
                    canvas.drawPoint(x + 10, 200, paint);
                    paint.setStrokeWidth(1);
                }
            }
        }
    }
}
