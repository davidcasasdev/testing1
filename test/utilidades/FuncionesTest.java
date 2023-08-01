package utilidades;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import excepciones.DebeSerPositivoException;

class FuncionesTest {

	@Test
	void testEsBisiesto() throws DebeSerPositivoException {
		assertAll (
				()->assertFalse(Funciones.esBisiesto(2023),
				"El 2023 no es divisible por 4"),
				()->assertFalse(Funciones.esBisiesto(1900), 
				"1900 no es bisiesto porque es divisible por 100 yno es divisible por 400"),
				()->assertTrue(Funciones.esBisiesto(2024), 
				"2024 es bisiesto porque es divisible por que 4 y no por 100"),
				()->assertTrue(Funciones.esBisiesto(2000), 
				"Es bisiesto porques es divisible por 100 y 400"),
				()->assertThrows(DebeSerPositivoException.class, ()-> Funciones.esBisiesto(-200),
				"No se pueden introducir números negativos")
				);
		
	}
	
	@Test
	void testGetDiagnostico() throws DebeSerPositivoException {
		assertThrows(DebeSerPositivoException.class, ()->Funciones.getDiagnostico(-30),
				"Los imc no pueden ser negativos");
		// Casos normales
		assertEquals("Bajo Peso", Funciones.getDiagnostico(18.2f), "Debe ser Bajo Peso");
		assertEquals("Peso normal (saludable)", Funciones.getDiagnostico(24f), "Debe ser Peso normal (saludable)");
		assertEquals("Sobrepeso", Funciones.getDiagnostico(29.8f), "Debe ser Sobrepeso");
		assertEquals("Obesidad premórbida", Funciones.getDiagnostico(39.6f), "Debe ser Obesidad premórbida");
		assertEquals("Obesidad mórbida", Funciones.getDiagnostico(47f), "Debe ser Obesidad mórbida");
		
		// casos límite
		assertEquals("Bajo Peso", Funciones.getDiagnostico(18.5f), "Debe ser Bajo Peso");
		assertEquals("Peso normal (saludable)", Funciones.getDiagnostico(24.9f), "Debe ser Peso normal (saludable)");
		assertEquals("Sobrepeso", Funciones.getDiagnostico(29.9f), "Debe ser Sobrepeso");
		assertEquals("Obesidad premórbida", Funciones.getDiagnostico(40), "Debe ser Obesidad premórbida");
		assertThrows(DebeSerPositivoException.class, ()->Funciones.getDiagnostico(0),
				"Los imc no pueden ser negativos ni cero");
	} 

}
