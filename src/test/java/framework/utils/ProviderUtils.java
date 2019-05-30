package framework.utils;

import java.text.DecimalFormat;
import java.util.Random;

public class ProviderUtils {
	private static final Random GENERATOR = new Random();
	
	public static int getInt() {
		return GENERATOR.nextInt();
	}
	
	public static int getInt(int max) {
		return GENERATOR.nextInt(max);
	}
	
	public static int getInt(int min, int max) {
		int num = GENERATOR.nextInt(max);
		if(num < min) {
			num = min + (num % (max - min));
		}
		return num;
	}

	public static double getDouble(int tamanho) {
		if(tamanho == 0) {
			return GENERATOR.nextDouble();
		}
		return GENERATOR.nextDouble() * (tamanho * 10) ;
	}
	
	public static String completeWithLeftZeros(String number, int size) {
		StringBuilder pattern = new StringBuilder();
	    for(int i = 0; i < size; i++) {
	        pattern.append("0");
	    }
		DecimalFormat formatter = new DecimalFormat(pattern.toString());
	    return formatter.format(Integer.parseInt(number));
	} 
	
	public static int mod(int dividendo, int divisor) {
		return (int) Math.round(dividendo - (Math.floor(dividendo / divisor) * divisor));
	}	
	
    public static Double convertCurrency(String value) {
    	return Double.parseDouble(value.replace("R$", "").replace(".", "").replace(",", "."));
    }

	public static String cleanString(String targetStr) {
		return targetStr.replace("/", "")
					    .replace(".", "")
					    .replace("-", "")
					    .replace(" ", "")
					    .replace(",", "");
	}
	
}
