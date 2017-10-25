package intro;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class CalendarExamples {

	public static void main(String[] args) {
		Calendar myCalendar = new GregorianCalendar();
		myCalendar.setFirstDayOfWeek(GregorianCalendar.SUNDAY);
		myCalendar.setTime(new Date());
		System.out.println(new SimpleDateFormat("dd/MMM/yyyy HH:mm:ss aa").format(myCalendar.getTime()));
	}

}
