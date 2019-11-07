package ru.netology.patterns;

import com.github.javafaker.Faker;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import java.text.SimpleDateFormat;
import java.util.*;


public class DataGenerator{
        private DataGenerator(){}

    @Value
    @Data
    @RequiredArgsConstructor
    public static class User {
            private final String fullName;
            private final String phone;
        }

    public static User getUserInfo(){
         Faker faker = new Faker(new Locale("RU"));
         return new User(
         faker.name().fullName(),
         faker.numerify("+7### ### ####")
         );
    }
    public static String getNextDate(String plusDays, String formatDate) {
        int plusDaysInt = Integer.parseInt(plusDays);
        Calendar c = new GregorianCalendar();
        c.add(Calendar.DAY_OF_YEAR, plusDaysInt);
        SimpleDateFormat format = new SimpleDateFormat(formatDate);
        String dateOfMeeting = format.format(c.getTime());
        return dateOfMeeting;
    }

    public static String getCity() {
        List<String> cities = new ArrayList<>();
        cities.add("Великий Новгород");
        cities.add("Горно-Алтайск");
        cities.add("Иваново");
        cities.add("Краснодар");
        cities.add("Красноярск");
        cities.add("Нижний Новгород");
        cities.add("Новосибирск");
        cities.add("Ростов-на-Дону");
        cities.add("Ульяновск");
        cities.add("Южно-Сахалинск");

        Random random = new Random();
        int i = random.nextInt(cities.size());
        return cities.get(i);
    }
}


