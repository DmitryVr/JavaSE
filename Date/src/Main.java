import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Date
        Date date1 = new Date(); // сегодняшняя дата
        System.out.println(date1);
        Date date2 = new Date(0); // дата создания UNIX
        System.out.println(date2);

        // Calendar (добавить к текущей дате минуты, часы...)
        Calendar calendar = Calendar.getInstance(); // конструктор у Calendar private
        calendar.setTime(date1);
        System.out.println(calendar.getTime()); // сегодняшняя дата
        calendar.add(Calendar.WEEK_OF_MONTH, 1); // добавить одну неделю в этом месяце
        System.out.println(calendar.getTime());

        // DateFormat (вывод даты в удобном формате)
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM); // конструктор private
        System.out.println(dateFormat.format(calendar.getTime()));

        // SimpleDateFormat (удобное управлление датами)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        System.out.println(simpleDateFormat.format(calendar.getTime()));

        // преобразование к объекту Date 21/07/1963
        try {
            Date newDate = simpleDateFormat.parse("21/07/1963 05:22"); // получить из строчки дату
            System.out.println(newDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
