package karolina.com;

import java.text.DateFormatSymbols;
import java.util.*;
//import org.apache.commons.lang3.StringUtils;

public class MyCalendar {

	public static void main(String[] args) {
		Locale newLocale = new Locale("pl", "PL");
		Locale.setDefault(newLocale);

		GregorianCalendar date = new GregorianCalendar();
		int thisMonth = date.get(Calendar.MONTH);
		int today = date.get(Calendar.DAY_OF_MONTH);

		
		Date now = date.getTime();
		System.out.println(now);

		// Ustawiamy zmienną date na pierwszy dzień miesiąca i pobieramy dzień
		// tygodnia dla tej daty
		date.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = date.get(Calendar.DAY_OF_WEEK);

		// Pobieram pierwszy dzień tygodnia w mojej lokalizacji
		int firstDayOfWeek = date.getFirstDayOfWeek();

		// Określam wcięcie pierwszego wiersza
		int indent = 0;
		while (weekday != firstDayOfWeek) {
			indent++;
			date.add(Calendar.DAY_OF_MONTH, -1);
			weekday = date.get(Calendar.DAY_OF_WEEK);
		}

	
		String[] weekdayNames = new DateFormatSymbols().getWeekdays();

		do {
			System.out.printf("%12s", weekdayNames[weekday]);

			date.add(Calendar.DAY_OF_MONTH, 1);
			weekday = date.get(Calendar.DAY_OF_WEEK);

		} while (weekday != firstDayOfWeek);
	
		
		System.out.println();

		for (int i = 1; i <= indent; i++)
		System.out.print("            "); // tyle, ile pól dla każdego dnia

		date.set(Calendar.DAY_OF_MONTH, 1);

			
			do {
			
			int day = date.get(Calendar.DAY_OF_MONTH);

			
			if (day == today) 
				System.out.print("    *" + day + "*    ");
			else 
				System.out.print("    ");
			
		//	System.out.printf("%2d", day);
			
		//	if (day == today)
		//		System.out.print("*    ");
			//else
				// System.out.print("    ");
			
			
		// Ustawienie date na kolejny dzień
			date.add(Calendar.DAY_OF_MONTH, 1);
			weekday = date.get(Calendar.DAY_OF_WEEK);
			
			// Rozpoczęcie nowego wiersza na początku tygodnia
			if (weekday == firstDayOfWeek)
				System.out.println();

			date.add(Calendar.DAY_OF_MONTH, 1);
			weekday = date.get(Calendar.DAY_OF_WEEK);

			if (weekday == firstDayOfWeek)
				System.out.println();
		

		} while (date.get(Calendar.MONTH)== thisMonth);
		// Pętla kończy działanie, jeśli date jest pierwszym dniem następnego
		// miesiąca

		// Wydruk końcowego znaku nowego wiersza w razie potrzeby
		if (weekday != firstDayOfWeek)
			System.out.println();

	}
}
