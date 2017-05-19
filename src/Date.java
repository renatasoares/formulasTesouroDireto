
public class Date {

	public int formactDate(String initialDate, String finalDate) {
		String date1[] = initialDate.split("/");
		int initialDay = Integer.parseInt(date1[0]);
		int initialMonth = Integer.parseInt(date1[1]);
		int initialYear = Integer.parseInt(date1[2]);
		int secondsInitialDate = initialDay * 24 + (initialMonth - 1) * 24 * 30 + (initialYear - 1) * 24 * 360;

		String date2[] = finalDate.split("/");
		int finalDay = Integer.parseInt(date2[0]);
		int finalMonth = Integer.parseInt(date2[1]);
		int finalYear = Integer.parseInt(date2[2]);
		int secondsFinalDate = finalDay * 24 + (finalMonth - 1) * 24 * 30 + (finalYear - 1) * 24 * 360;

		int differenceDays = (secondsFinalDate - secondsInitialDate) / 24;
		return Math.abs(differenceDays);
	}
}
