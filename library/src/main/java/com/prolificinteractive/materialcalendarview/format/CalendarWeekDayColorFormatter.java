package com.prolificinteractive.materialcalendarview.format;

import android.content.Context;

import org.threeten.bp.DayOfWeek;

public class CalendarWeekDayColorFormatter implements WeekDayColorFormatter {

    CharSequence[] mColors;

    public CalendarWeekDayColorFormatter() {
        mColors = new String[]{"#797979", "#797979", "#797979", "#797979", "#797979", "#797979", "#797979"};
    }


    public CalendarWeekDayColorFormatter(CharSequence[] colors) {
        this.mColors = colors;
    }

    @Override
    public String format(Context context, DayOfWeek dayOfWeek) {
        return mColors[dayOfWeek.getValue() - 1].toString();
    }
}
