package org.example;

import org.example.classes.Device;
import org.example.classes.Product;
import org.example.classes.Projector;

import java.time.Year;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        executeFirstTask();
//        executeSecondTask();
//        executeThirdTask();
        executeFourthTask();
    }

    public static void executeFirstTask() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите сколько чисел сгенерировать:");
        int n = sc.nextInt();
        int lowerBound = -100_000, upperBound = 100_000;
        List<Integer> randomNumbers = new Random().ints(n, lowerBound, upperBound).boxed().collect(Collectors.toList());
        long numberOfPositive = randomNumbers.stream().filter((Integer value) -> value > 0).count();
        long numberOfNegative = randomNumbers.stream().filter((Integer value) -> value < 0).count();
        long numberOfDigit = randomNumbers.stream()
                .filter((Integer value) ->
                        (value >= 10 && value <= 99) || (value <= -10 && value >= -99)
                ).count();
        long numberOfPalindromes = randomNumbers.stream()
                .filter((Integer value) -> isPalindrome(value)).count();
        System.out.println("Число позитивных:" + numberOfPositive);
        System.out.println("Число отрицательных:" + numberOfNegative);
        System.out.println("Число двухзначных:" + numberOfDigit);
        System.out.println("Число палиндромов:" + numberOfPalindromes);
        sc.close();
    }

    private static boolean isPalindrome(Integer number) {
        int numberModule = Math.abs(number);
        String numberToString = String.valueOf(numberModule);
        int length = numberToString.length();
        for(int i = 0; i < length / 2; i++) {
            if(numberToString.charAt(i) != numberToString.charAt(length - 1 - i)) return false;
        }
        return true;
    }

    public static void executeSecondTask() {
        Scanner sc = new Scanner(System.in);
        List<Product> products = Arrays.asList(
                new Product("Яблоко", "Фрукт"),
                new Product("Груша", "Фрукт"),
                new Product("Яблоко", "Фрукт"),
                new Product("Кола", "Напиток"),
                new Product("Кефир", "Молоко"),
                new Product("Шоколадный коктейль", "Молоко"),
                new Product("Сыр", "Молоко"),
                new Product("Творог", "Молоко"),
                new Product("Творог", "Молоко")
        );
        System.out.println("Все продукты:");
        products.stream().forEach(System.out::println);

        System.out.println("\nПродукты с названием меньше 5 символов:");
        products.stream().filter(product -> product.getName().length() <= 5).forEach(System.out::println);

        System.out.println("\nВведите название продукта, чтобы узнать сколько раз он встречается:");
        String productToFind = sc.nextLine();
        System.out.println("Продукт " + productToFind + " встречается " + products.stream().filter(product -> product.getName().toLowerCase().equals(productToFind.toLowerCase())).count() + " раз.");

        System.out.println("\nС какой буквы хотите продукты:");
        char letter = sc.nextLine().charAt(0);
        System.out.println("Продукты начинающиеся с буквы " + letter + ":");
        products.stream().
                filter(product -> product.getName().startsWith(String.valueOf(letter).toUpperCase()))
                .forEach(product ->
                    System.out.println("Название продукта: " + product.getName() + ", категория продукта: " + product.getCategory())
                );

        System.out.println("\n Молочные продукты:");
        products.stream().
                filter(product -> product.getCategory().equals("Молоко"))
                .forEach(System.out::println);
        sc.close();
    }

    public static void executeThirdTask() {
        Scanner sc = new Scanner(System.in);
        List<Device> devices = Arrays.asList(
                new Device("iphone 4", 2013, 200.0, "black", "smartphone"),
                new Device("iphone 7", 2014, 250.0, "white", "smartphone"),
                new Device("samsung galaxy 5", 2015, 300.0, "black", "smartphone"),
                new Device("ipad 4", 2014, 250.0, "white", "tablet"),
                new Device("ipad air", 2016, 400.0, "gray", "tablet"),
                new Device("xiaomi 6", 2017, 400.0, "green", "smartphone"),
                new Device("huawei 8", 2013, 350.0, "green", "smartphone"),
                new Device("nokia 228", 2007, 100.0, "red", "cellphone"),
                new Device("htc smth", 2008, 150.0, "red", "cellphone")
        );

        System.out.println("Все устройства:");
        devices.stream().forEach(System.out::println);

        System.out.println("\nВведите цвет устройства на английском:");
        String color = sc.nextLine();
        System.out.println("Все устройства с заданным цветом:");
        devices.stream()
                .filter(device ->
                        device.getColor().toLowerCase().equals(color.toLowerCase())
                )
                .forEach(System.out::println);

        System.out.println("\nВведите год выпуска устройства:");
        int year = sc.nextInt();
        System.out.println("Все устройства, которые были выпущены в " + year + ":");
        devices.stream()
                .filter(device ->
                        device.getYear() == year
                )
                .forEach(System.out::println);

        System.out.println("\nВведите цену:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Все устройства, которые дороже " + price + ":");
        devices.stream()
                .filter(device ->
                        device.getPrice() > price
                )
                .forEach(System.out::println);

        System.out.println("\nВведите тип устройства на английском:");
        String type = sc.nextLine();
        System.out.println("Устройства с таким типом:");
        devices.stream()
                .filter(device ->
                        device.getType().toLowerCase().equals(type.toLowerCase())
                )
                .forEach(System.out::println);


        System.out.println("\nВведите диапазон выхода устройства через пробел");
        String[] years = sc.nextLine().split(" ");
        try {
            int startYear = Integer.parseInt(years[0]);
            int endYear = Integer.parseInt(years[1]);
            System.out.println("Все устройства в диапазоне с " + startYear + " по " + endYear);
            devices.stream()
                    .filter(device ->
                            device.getYear() >= startYear && device.getYear() <= endYear
                    )
                    .forEach(System.out::println);
            sc.close();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        sc.close();
    }

    public static void executeFourthTask() {
        Scanner sc = new Scanner(System.in);
        List<Projector> projectors = Arrays.asList(
                new Projector("Проектор Wanbo New T2 Max, White", 2014, 84_990.0, "Wando"),
                new Projector("Проектор Wanbo New T2 Max", 2015, 89_990.0, "Wando"),
                new Projector("Проектор Wanbo TT", 2023, 139_990.0, "Wando"),
                new Projector("Проектор Epson EH-LS300B", 2023, 1_617_990.0, "Epson"),
                new Projector("Проектор Epson EH-TW6150", 2018, 929_990.0, "Epson"),
                new Projector("Проектор Epson EH-TW6250", 2017, 970_990.0, "Epson")
        );

        System.out.println("Все проекторы:");
        projectors.stream().forEach(System.out::println);

        List<String> manufacturers = projectors.stream()
                .map(Projector::getManufacturer)
                .distinct()
                .collect(Collectors.toList());
        manufacturers.forEach(manufacturer -> {
            System.out.println("\nВсе проекторы от производителя " + manufacturer + ":");
            projectors.stream()
                    .filter(projector ->
                            projector.getManufacturer().equals(manufacturer)
                    )
                    .forEach(System.out::println);
        });

        System.out.println("\nПроекторы текущего года:");
        projectors.stream()
                .filter(projector -> {
                    Year currentYear = Year.now();
                    int yearValue = currentYear.getValue();
                    return projector.getYear() == yearValue;
                })
                .forEach(System.out::println);

        System.out.println("\nВведите цену:");
        double price = sc.nextDouble();
        sc.nextLine();
        System.out.println("Проекторы дороже " + price + ":");
        projectors.stream()
                .filter(projector ->
                    projector.getPrice() > price
                )
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене, по возрастанию:");
        projectors.stream()
                .sorted(
                        Comparator.comparingDouble(Projector::getPrice)
                )
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по цене, по убыванию:");
        projectors.stream()
                .sorted(
                        Comparator.comparingDouble(Projector::getPrice).reversed()
                )
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по году, по возрастанию:");
        projectors.stream()
                .sorted(
                        Comparator.comparingInt(Projector::getYear)
                )
                .forEach(System.out::println);

        System.out.println("\nПроекторы, отсортированные по году, по убыванию:");
        projectors.stream()
                .sorted(
                        Comparator.comparingInt(Projector::getYear).reversed()
                )
                .forEach(System.out::println);
    }
}