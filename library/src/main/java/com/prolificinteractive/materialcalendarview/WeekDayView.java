package com.prolificinteractive.materialcalendarview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;

import com.prolificinteractive.materialcalendarview.format.WeekDayColorFormatter;
import com.prolificinteractive.materialcalendarview.format.WeekDayFormatter;

import org.threeten.bp.DayOfWeek;

/**
 * Display a day of the week
 */
@SuppressLint("ViewConstructor")
class WeekDayView extends AppCompatTextView {

    private WeekDayFormatter formatter = WeekDayFormatter.DEFAULT;
    private WeekDayColorFormatter colorFormatter = WeekDayColorFormatter.DEFAULT;
    private DayOfWeek dayOfWeek;
    private Context context;

    public WeekDayView(final Context context, final DayOfWeek dayOfWeek) {
        super(context);
        this.context = context;
        setGravity(Gravity.CENTER);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            setTextAlignment(TEXT_ALIGNMENT_CENTER);
        }

        setDayOfWeek(dayOfWeek);
    }

    public void setWeekDayFormatter(@Nullable final WeekDayFormatter formatter) {
        this.formatter = formatter == null ? WeekDayFormatter.DEFAULT : formatter;
        setDayOfWeek(dayOfWeek);
    }

    public void setWeekDayColorFormatter(@Nullable final WeekDayColorFormatter colorFormatter) {
        this.colorFormatter = colorFormatter;
        setDayOfWeek(dayOfWeek);
    }

    public void setDayOfWeek(final DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
        CharSequence text = formatter.format(dayOfWeek);
        String color = colorFormatter.format(context, dayOfWeek);
        Spannable wordtoSpan = new SpannableString(text.toString());
        wordtoSpan.setSpan(new ForegroundColorSpan(Color.parseColor(color)), 0, text.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        setText(wordtoSpan);
    }
}
