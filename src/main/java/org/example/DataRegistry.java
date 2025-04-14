package org.example;

// Класс DataRegistry - простой реестр данных, который будет генерировать уникальные имена пользователей для реализации паттерна Data Registry.

import java.util.HashSet;
import java.util.Set;

public class DataRegistry {
    private static final Set<String> usedUsernames = new HashSet<>();
// Создаем статическое поле usedUsernames, которое является объектом типа Set<String>.
// Это поле используется для хранения уже использованных имен пользователей.
    public static String generateUniqueUsername(String baseName) {
        String uniqueUsername; // Объявление переменной:
        int counter = 1; // Объявление и инициализация счетчика
        do {
            uniqueUsername = baseName + counter;
            counter++;
        } while (usedUsernames.contains(uniqueUsername));
        // Цикл do while генерирует уникальное имя пользователя, добавляя числовой суффикс к baseName.
        // Цикл продолжается до тех пор, пока сгенерированное имя не будет уникальным
        usedUsernames.add(uniqueUsername); //Добавление в коллекцию, чтобы предотвратить повторное использование
        return uniqueUsername; //Метод возвращает сгенерированное уникальное имя пользователя.
    }
}
// Метод generateUniqueUsername генерирует уникальные имена пользователей
// на основе базового имени. Он использует HashSet для отслеживания уже использованных имен.

