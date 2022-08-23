import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class UtilsDate {
    public static Date stringToDate(String data) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        try {
            return (Date) formato.parse(data);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String dateToString(Date data) {
        Format formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        return formatter.format(data);
    }

    public static long diferencaDatasMilesegundos(Date inicio, Date fim) {
        return fim.getTime() - inicio.getTime();
    }

    public static String diferencaDatas(Date inicio, Date fim) {
		final long milliseconds = diferencaDatasMilesegundos(inicio, fim);
		final long dias = TimeUnit.MILLISECONDS.toDays(milliseconds);
		final long horas = TimeUnit.MILLISECONDS.toHours(milliseconds) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(milliseconds));
		final long minutos = TimeUnit.MILLISECONDS.toMinutes(milliseconds) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milliseconds));

		return String.format("%d Dias %d Horas %d Minutos", dias, horas, minutos);
    }
}
