package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import controllers.ExtendedController;
import dto.Ingrediente;
import dto.Utente;
import enumerations.TipoUtente;
import javafx.event.Event;
import javafx.fxml.LoadException;

class ExtendedControllerTests {

	@Test
	void testChangeSceneFullscreen() {
		var extendedController = new ExtendedController<>();
		
		assertThrows(NullPointerException.class, () -> extendedController.changeSceneFullscreen(new Event(null), "ciao"));
		assertThrows(LoadException.class,() -> extendedController.changeSceneFullscreen(new Event(null), "MenuScene"));
	}

	@Test
	void testAskData() throws IOException, InterruptedException {
		var extendedController = new ExtendedController<>();
		String[] array = String.valueOf(extendedController.askData("ingredienti/", "GET",
				new Ingrediente()).getJSONArray("values")).split(",");
		
		assertTrue(array.length%3==0);
		
		Ingrediente ingrediente = new Ingrediente(array[0].replace("\"", "").replace("[", ""), 
				Integer.valueOf(array[1].replace("\"", "")), Integer.valueOf(array[2].replace("\"", "").replace("]", "")));
		
		assertEquals(array[0].replace("\"", "").replace("[", ""), ingrediente.getNome());
		assertNotEquals(array[1], ingrediente.getIngredienteId());
		assertNotEquals(array[2], ingrediente.getQuantita());
		
		JSONObject json = extendedController.askData("utente/", "PUT", new Utente("q","q", 0, null, null),"q","q");
		assertDoesNotThrow(() -> TipoUtente.valueOf(json.getString("ruolo")));
	}

}
