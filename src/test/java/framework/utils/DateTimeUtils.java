package framework.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateTimeUtils {
	public static String getTimeStampWithoutFormat(){
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		Date now = new Date();
		return dateFormat.format(now);
	}
	
	public static String getDateTimeFormatReport() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
        Date now = new Date();
        return dateFormat.format(now);
    }
    
	public static String getDateTimeFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy_HHmmss");
        Date now = new Date();
        return dateFormat.format(now);
    }
    
    public static String getDateFormat() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date now = new Date();
        return dateFormat.format(now);
    }

    public static String getDtTimeZoneFormatDataAtual() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        Date now = new Date();
        return dateFormat.format(now);
    }

    public static String getDtTimeZoneFormatDataFutura(Long qtdDias) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dataFutura = LocalDateTime.now().plusDays(qtdDias);
        return dataFutura.format(formatter);
    }

    public static String getDtTimeZoneFormatDataPassada(Long qtdDias) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime dataPassada = LocalDateTime.now().minusDays(qtdDias);
        return dataPassada.format(formatter);
    }

    public static Date getStringToDate(String data) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(dateFormat.parse(data).getTime());
        return date;
    }
}