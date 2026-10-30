package com.agah.sarkhati;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class MainActivity extends Activity {

    EditText hour, count, interval;
    TextView status;
    Button start, stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(25, 30, 25, 25);

        TextView title = new TextView(this);
        title.setText("ربات سرخطی کارگزاری آگاه");
        title.setTextSize(23);
        layout.addView(title);

        hour = field(layout, "ساعت اجرا مثال 08:44:59");
        count = field(layout, "تعداد دفعات");
        interval = field(layout, "فاصله زمانی میلی ثانیه");

        start = new Button(this);
        start.setText("شروع");
        layout.addView(start);

        stop = new Button(this);
        stop.setText("توقف");
        layout.addView(stop);

        status = new TextView(this);
        status.setText("وضعیت: آماده");
        layout.addView(status);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status.setText("تنظیمات ثبت شد؛ اتصال به آگاه هنوز فعال نیست.");
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                status.setText("برنامه متوقف شد.");
            }
        });

        setContentView(layout);
    }

    private EditText field(LinearLayout layout, String hint) {
        EditText e = new EditText(this);
        e.setHint(hint);
        layout.addView(e);
        return e;
    }
}