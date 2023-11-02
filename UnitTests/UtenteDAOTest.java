package com.example.backendingsw.dao;

import com.example.backendingsw.dto.Utente;
import com.example.backendingsw.enumerations.TipoUtente;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtenteDAOTest {

    @Test
    void autentificazioneUtente() throws Exception {
        UtenteDAO utenteDAO = new UtenteDAO();
        Utente utente = new Utente("q","q",2, TipoUtente.Amministratore.toString(),0);

        assertEquals(utente, utenteDAO.autentificazioneUtente("q", "q"));

        assertThrows(NullPointerException.class, () -> utenteDAO.autentificazioneUtente("dsaf","sdf").getId());
        assertThrows(NullPointerException.class, () -> utenteDAO.autentificazioneUtente("","").getId());
    }
}