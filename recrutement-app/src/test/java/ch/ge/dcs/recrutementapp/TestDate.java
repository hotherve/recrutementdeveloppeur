package ch.ge.dcs.recrutementapp;

import ch.ge.dcs.recrutementapp.model.SalleEvenementModel;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestDate {
    @Test
    public void testeDateString() {
        String formatedDate = "2019-07-10T16:24:32";

        LocalDateTime parsedDate = LocalDateTime.parse(formatedDate, DateTimeFormatter.ofPattern(SalleEvenementModel.TIMEFORMAT));
        System.out.println("Date depuis le formattage : "+parsedDate);
        Assert.isTrue(parsedDate instanceof LocalDateTime,"la date est bien un datetime");

        String dateNonValide="autre date";
        parsedDate = LocalDateTime.parse(dateNonValide, DateTimeFormatter.ofPattern(SalleEvenementModel.TIMEFORMAT));
        Assert.isNull(parsedDate,"La date n'est pas valide");
    }

    @Test
    public void testRexp() {
        String search = "^motion:o(n|ff)$";
        Pattern pattern = Pattern.compile(search);
        // in case you would like to ignore case sensitivity,
        // you could use this statement:
        // Pattern pattern = Pattern.compile("\\s+", Pattern.CASE_INSENSITIVE);
        CharSequence EXAMPLE_TEST = "motion:on";
        Matcher matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        if(matcher.matches()) {
            System.out.println("exemple matche: '" + EXAMPLE_TEST+"'");
        } else {
            System.out.println("exemple matche pas : '" + EXAMPLE_TEST+"'");
        }
        // check all occurance
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }


        EXAMPLE_TEST = "motion:off";
        // check all occurance
        if(matcher.matches()) {
            System.out.println("exemple : '" + EXAMPLE_TEST+"'");
        } else {
            System.out.println("exemple matche pas : '" + EXAMPLE_TEST+"'");
        }
        matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }

        EXAMPLE_TEST = "motion:off ";
        matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        if(matcher.matches()) {
            System.out.println("exemple : '" + EXAMPLE_TEST+"'");
        } else {
            System.out.println("exemple matche pas : '" + EXAMPLE_TEST+"'");
        }
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }


        EXAMPLE_TEST = " motion:on";
        matcher = pattern.matcher(EXAMPLE_TEST);
        // check all occurance
        if(matcher.matches()) {
            System.out.println("exemple : '" + EXAMPLE_TEST+"'");
        } else {
            System.out.println("exemple matche pas : '" + EXAMPLE_TEST+"'");
        }
        while (matcher.find()) {
            System.out.print("Start index: " + matcher.start());
            System.out.print(" End index: " + matcher.end() + " ");
            System.out.println(matcher.group());
        }
    }
}
