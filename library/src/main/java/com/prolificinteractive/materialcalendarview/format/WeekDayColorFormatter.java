package com.prolificinteractive.materialcalendarview.format;

import android.content.Context;

import org.threeten.bp.DayOfWeek;

public interface WeekDayColorFormatter {

    String format(Context context, DayOfWeek dayOfWeek);

    WeekDayColorFormatter DEFAULT = new CalendarWeekDayColorFormatter();
}
