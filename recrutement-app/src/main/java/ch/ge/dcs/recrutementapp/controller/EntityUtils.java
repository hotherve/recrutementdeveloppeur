package ch.ge.dcs.recrutementapp.controller;

import ch.ge.dcs.recrutementapp.model.SalleEvenementModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Utilitaires de manipulation des beans
 */
public class EntityUtils {

    /**
     * Retourne la date depuis le string
     *
     * @param dateString
     * @return
     */
    public static LocalDateTime eventStringToDate(String dateString) {
        LocalDateTime dateOutput = null;
        try {
            dateOutput = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern(SalleEvenementModel.TIMEFORMAT));
        } catch (DateTimeParseException e) {
            // rien a faire la date n'est pas bonne la sortie reste nulle
        }
        return dateOutput;
    }
}
