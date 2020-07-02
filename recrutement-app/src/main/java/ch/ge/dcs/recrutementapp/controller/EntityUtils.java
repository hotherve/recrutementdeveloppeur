package ch.ge.dcs.recrutementapp.controller;

import ch.ge.dcs.recrutementapp.model.SalleEvenementModel;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

/**
 * Utilitaires de manipulation
 */
public class EntityUtils {
    /**
     * Retourne le string depuis la date
     * @param localDateTime
     * @return
     */
    public static String eventDateToString(LocalDateTime localDateTime) {
        return localDateTime.format(DateTimeFormatter.ofPattern(SalleEvenementModel.TIMEFORMAT));
    }

    public static String eventDateToString(Date date) {
        return eventDateToString(convertToLocalDateTimeViaInstant(date));
    }

    public static LocalDateTime convertToLocalDateTimeViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }

    /**
     * Retourne la date depuis le string
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
