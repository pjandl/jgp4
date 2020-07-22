package org.jandl.mod;

import java.util.Calendar;

public class P0325Servico {
	public static String cumprimento() {
		var cal = Calendar.getInstance();
		int hora = cal.get(Calendar.HOUR_OF_DAY);
		if (hora>18) {
			return "Boa noite";
		} else if (hora > 12) {
			return "Boa tarde";
		}
		return "Bom dia";
	}
}