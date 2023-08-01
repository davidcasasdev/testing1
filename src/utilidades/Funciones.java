package utilidades;

import excepciones.DebeSerPositivoException;

/**
 * Clase que se usará en forma estática y que conetiene una serie de métodos
 * de utilidades
 * @author David 
 *
 */
public class Funciones {

	/**
	 * Método que calcula si el año pasado como parámetro es o no bisiesto.
	 * El año pasado debe ser un entero positivo
	 * @param anio int con el año a comprobar
	 * @return true en caso de que el año sea bisiesto y false en caso contrario
	 * @throws DebeSerPositivoException cuando el año pasado como parámetro sea negativo
	 */
	public static boolean esBisiesto(int anio) 
			throws DebeSerPositivoException {
		if (anio<0) {
			throw new DebeSerPositivoException();
		}

		if (anio%4 !=0 ) {
			return false;
		} else {
			if (anio%100==0 && anio%400!=0) {
				return false;
			} else {
				return true;
			}
		}
	}
	
	/**
	 * Método que calcula el diagnóstico de un paciente a traves de su imc 
	 * o índice de masa coroporal
	 * @param imc float el índice de masa corporal del paciente
	 * @return String con el diagnóstico del paciente que puede ser uno de los siguientes:
	 * 		<ul>
	 * 			<li>Bajo peso</li>
	 * 			<li>Peso normal (saludable)</li>
	 * 			<li>Sobrepeso</li>
	 * 			<li>Obesidad premórbida</li>
	 * 			<li>Obesidad mórbida</li>
	 *		</ul>
	 * @throws DebeSerPositivoException Se lanzará cuando se pasa como parámetro un 
	 * argumento negativo
	 */
	public static String getDiagnostico(float imc) 
			throws DebeSerPositivoException {
		String diagnostico="";
		if (imc<=0) throw new DebeSerPositivoException();
		if (imc<=18.5) {
			diagnostico="Bajo Peso";
		} else if (imc<=24.9) {
			diagnostico="Peso normal (saludable)";
		} else if(imc<=29.9) {
			diagnostico="Sobrepeso";
		} else if (imc<=40) {
			diagnostico="Obesidad premórbida";
		} else {
			diagnostico="Obesidad mórbida";
		}
		return diagnostico;
	}


}

