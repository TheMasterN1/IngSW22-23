package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import application.Translator;

class TranslatorTests {

	@Test
	void testTranslate() throws IOException {
		assertEquals("the eggs", Translator.Translate("", "en", "le uova"));
		
		assertEquals("bistecca", Translator.Translate("", "it", "steak"));
		
		assertNotEquals("on the tables", Translator.Translate("", "en", "sul tavolo"));
		
		assertEquals("il gatto era sul tavolo", Translator.Translate("", "it", "the cat was on the table"));
		
		assertNotEquals("dogs", Translator.Translate("", "en", "cane"));		
	}
}
