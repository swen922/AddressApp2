package ch.makery.address.util;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Вспомогательные функции для работы с датами.
 *
 * @author Marco Jakob
 */

public class DateUtil {
    /** Шаблон даты, используемый для преобразования. Можно поменять на свой. */
    private static final String DATE_PATTERN = "d.M.yyyy";

    /** Форматировщик даты. */
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

    /**
     * Возвращает полученную дату в виде хорошо отформатированной строки.
     * Используется определённый выше {@link DateUtil#DATE_PATTERN}.
     *
     * @param date - дата, которая будет возвращена в виде строки
     * @return отформатированную строку
     */
    public static String format(LocalDate date) {
        if (date == null) {
            return null;
        }
        return DATE_FORMATTER.format(date);
    }

    /**
     * Преобразует строку, которая отформатирована по правилам
     * шаблона {@link DateUtil#DATE_PATTERN} в объект {@link LocalDate}.
     *
     * Возвращает null, если строка не может быть преобразована.
     *
     * @param dateString - дата в виде String
     * @return объект даты или null, если строка не может быть преобразована
     */
    public static LocalDate parse(String dateString) {
        try {
            return DATE_FORMATTER.parse(dateString, LocalDate::from);
        } catch (Exception e) {
            return null;
        }
    }


    public static boolean validDate(String dateString) {
        return DateUtil.parse(dateString) != null;
    }

}
