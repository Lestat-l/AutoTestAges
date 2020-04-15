import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EighteenYearVerification {

    public boolean CheckingEighteenYear(String in_sEnteredDate) {
        boolean l_bResult = false;
        in_sEnteredDate = in_sEnteredDate.replaceAll("[OОоo]", "0");
        String[] l_aDate = in_sEnteredDate.split("-");

        if((l_aDate.length > 2) && (l_aDate[0].length() == 4) && (l_aDate[1].length() == 2) && (l_aDate[2].length() == 2)) {

            SimpleDateFormat l_cEnteredDate = new SimpleDateFormat("yyyy-MM-dd");
            try {
                int l_iYear = Integer.parseInt(l_aDate[0].replaceAll("[^0-9]", ""));
                int l_iMonth = Integer.parseInt(l_aDate[1].replaceAll("[^0-9]", ""));
                int l_iDay = Integer.parseInt(l_aDate[2].replaceAll("[^0-9]", ""));

                GregorianCalendar l_dEnteredDate = new GregorianCalendar();
                l_dEnteredDate.setTime(l_cEnteredDate.parse(in_sEnteredDate));
                GregorianCalendar l_dCurrentDate = new GregorianCalendar();
                l_dCurrentDate.set(Calendar.YEAR, l_dCurrentDate.get(Calendar.YEAR) - 18);

                // -1 месяц так как счет идёт с 0 (январь - 0)
                if((l_dEnteredDate.get(Calendar.YEAR) == l_iYear) && (l_dEnteredDate.get(Calendar.MONTH) == l_iMonth - 1) && (l_dEnteredDate.get(Calendar.DAY_OF_MONTH) == l_iDay)) {
                    if (l_dEnteredDate.before(l_dCurrentDate))
                        l_bResult = true;
                }
                else {
                    System.out.println("Incorrect date: " + in_sEnteredDate);
                }
            } catch (ParseException e) {
                System.out.println("Incorrect date: " + in_sEnteredDate);
            }
        }

        return l_bResult;
    }

}
