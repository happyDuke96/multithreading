package org.multithreading.date;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/***
 * Шпаргалка для использование даты и время
 */
public class DatePrompt {


    public static void main(String[] args) {
        /**
         * 1. Создать объект LocalDateTime, представляющий собой
         * дату 25.06.2020 19:47.Используя этот объект, создать другой объект LocalDateTime,
         * представляющий собой дату через 3 месяца после сегодняшней.
         * Вывести на консоль содержащиеся в нем объеты LocalDate and LocalTime.
         */
        LocalDateTime localDateTime = LocalDateTime.of(2020, 6, 25, 19, 47);
        LocalDateTime newLocalDateTime = localDateTime.plusMonths(3L);

        System.out.println(newLocalDateTime.toLocalDate());
        System.out.println(newLocalDateTime.toLocalTime());


//        /****************************************************************************************************/

        /**
         * 2. Создать объект LocalDate, представляющий собой сегодняшнюю
         * дату. Преобразовать дату в строку вида "05.05.2017". Вывести эту строку на
         * консоль.
         */
        LocalDateTime now = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
        String format = now.format(formatter);
        System.out.println(format);


//        /****************************************************************************************************/

        /**
         * 3. Дана строка вида "26-03-1968T09:24". Получить объект LocalDateTime, представляющий
         * собой дату, полученную из этой строки.
         */

        String formattedDate = "26-03-1968T09:24";
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime2 = LocalDateTime.parse(formattedDate, formatter2);
        System.out.println(localDateTime2);


//        /****************************************************************************************************/

        /**
         * 4. Использовать LocalDateTime из предыдущего задания, преобразовать его
         * в объект типа Instant, указав тайм зону "America/Chicago". Вывести количество
         * прошедших миллисекунд.
         */


        System.out.println("zzzzz");
        String formattedDate2 = "26-03-1968T09:24";
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("dd-MM-yyyy'T'HH:mm");
        LocalDateTime localDateTime3 = LocalDateTime.parse(formattedDate2, formatter3);
        System.out.println(localDateTime3);

        Instant instant = localDateTime3.toInstant(ZoneId.of("America/Chicago").getRules().getOffset(localDateTime3));
        System.out.println(instant);
        System.out.println(instant.toEpochMilli());


//        /****************************************************************************************************/

        /**
         * 4. Создать объект LocalDate, представляющий собой сегодняшнюю
         * дату. Создать объект LocalDate, представляющий собой дату
         * 07.07.2018. Используя созданные объекты, найти количество дней между
         * этими двумя датами.
         */
        LocalDate now2 = LocalDate.now();
        LocalDate prevDate = LocalDate.of(2018, 7, 7);

        Period period = Period.between(prevDate, now2);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        long days = ChronoUnit.DAYS.between(prevDate, now2);
        System.out.println(days);


//        /****************************************************************************************************/

        /**
         * 5. Даны два объекта LocalDate из предыдущего задания. Подсчитать количество
         * секунд между полуночью первой даты и полуночью второй даты.
         */
        LocalDate now3 = LocalDate.now();
        LocalDate prevDate2 = LocalDate.of(2018, 7, 7);

//        LocalDateTime.of(now3, LocalTime.MIDNIGHT); alternative
        LocalDateTime localDateTimeNow = now3.atStartOfDay();
        LocalDateTime localDateTimePrev = prevDate2.atStartOfDay();

        Duration duration = Duration.between(localDateTimePrev, localDateTimeNow);
        System.out.println(duration.getSeconds());


//        /****************************************************************************************************/

        /**
         * 6. Создать объект Instant. Вывести его на консоль. Затем создать
         * объект ZonedDateTime на основании предыдущего объекта с тайм зоной "Africa/Cairo".
         */

        Instant instant1 = Instant.now();
        System.out.println(instant1);

        ZonedDateTime zonedDateTime = instant1.atZone(ZoneId.of("Africa/Cairo"));
        System.out.println(zonedDateTime);

//        /****************************************************************************************************/

        /**
         * 7. Написать свою реализацию интерфейса TemporalAdjuster, которая бы
         * прибавляла к дате 42 дня
         */

        LocalDateTime now4 = LocalDateTime.now();

        LocalDateTime localDateTime4 = now4.with(temporal -> temporal.plus(42L, ChronoUnit.DAYS));
        System.out.println(localDateTime4);
    }

}
