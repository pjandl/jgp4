import java.awt.Color;

/**
 * Enumeração para classificar a força de senha do tipo String
 * ou char[], baseado em 4 critérios: (1) tamanho da senha; 
 * (2) presença de maiúsculas e minúsculas; (3) presença de
 * digitos; e (4) presença de símbolos.
 * 
 * Esta classe é para fins educacionais e seus resultados não 
 * devem ser tomados como uma orientação de segurança.
 */
public enum P0611PasswordStrength {
	FRACA(Color.RED), MEDIA(Color.ORANGE), ADEQUADA(Color.YELLOW), ROBUSTA(
			Color.CYAN), FORTE(Color.GREEN);

	/**
	 * Atributo de cor associada a força de uma senha.
	 */
	private Color color;

	/**
	 * Construtor.
	 */
	P0611PasswordStrength(Color color) {
		this.color = color;
	}

	/**
	 * Estima a força de uma senha fornecida como String.
	 */
	public static P0611PasswordStrength evaluateStrength(String pwd) {
		return evaluateStrength(pwd.toCharArray());
	}

	/**
	 * Estima a força de uma senha fornecida como char[].
	 */
	public static P0611PasswordStrength evaluateStrength(char[] pwd) {
		int score = 0;
		boolean upperCase = false;
		boolean lowerCase = false;
		boolean digits = false;
		boolean simbols = false;

		// Verifica tamanho da senha
		if (pwd.length > 7) {
			score++;
		}

		// Analisa caracteres da senha
		for (char c : pwd) {
			if (Character.isLetterOrDigit(c)) {
				if (Character.isDigit(c)) {
					digits=true;
				} else {
					if (Character.isLowerCase(c)) {
						lowerCase=true;
					} else {
						upperCase=true;
					}
				}
			} else {
				simbols=true;
			}
		}
		if (lowerCase && upperCase) score++;
		if (lowerCase ^ upperCase && digits) score++;
		if (lowerCase && upperCase && digits) score++;
		if (lowerCase ^ upperCase && simbols) score++;
		if (lowerCase && upperCase && simbols) score++;
		if (lowerCase ^ upperCase && simbols && digits) score++;
		if (lowerCase && upperCase && digits && simbols) score++;

		switch (score) {
		case 0:
			return FRACA;
		case 1:
			return MEDIA;
		case 2:
			return ADEQUADA;
		case 3:
			return ROBUSTA;
		default: // FORTE
		}
		return FORTE;
	}

	/**
	 * Retorna a cor associada a força de uma senha.
	 */
	public Color getColor() {
		return color;
	}

}
