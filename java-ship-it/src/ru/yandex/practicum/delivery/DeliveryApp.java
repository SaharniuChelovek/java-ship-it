package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.box.ParcelBox;
import ru.yandex.practicum.delivery.parsel.FragileParcel;
import ru.yandex.practicum.delivery.parsel.Parcel;
import ru.yandex.practicum.delivery.parsel.PerishableParcel;
import ru.yandex.practicum.delivery.parsel.StandardParcel;
import ru.yandex.practicum.delivery.tracking.Trackable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<Trackable> trackLocation = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox = new ParcelBox(456);
    private static ParcelBox<FragileParcel> fragileBox = new ParcelBox(157);
    private static ParcelBox<PerishableParcel> perishableBox = new ParcelBox(245);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    locationReport();
                    break;
                case 5:
                    getParcelsFromTheBox();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — обновить статус всех отслеживаемых посылок");
        System.out.println("5 — показать содержимое коробки");
        System.out.println("0 — Завершить");
    }
    // реализуйте методы ниже
    private static void addParcel() {

        System.out.println("Введите описание посылки");
        String description = scanner.nextLine();
        System.out.println("Введите вес посылки в килограммах");
        int weight = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Введите адрес отправления");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Введите день отправления");
        int sendDay = scanner.nextInt();
        scanner.nextLine();
        boolean running = true;
        while (running) {
            System.out.println("Укажите тип посылки:");
            parcelTypeMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    StandardParcel standardParcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
                    allParcels.add(standardParcel);
                    standardBox.addParcelInBox(standardParcel);
                    running = false;
                    break;
                case 2:
                    System.out.println("Сколько дней посылка будет свежей:");
                    int timeToLive = scanner.nextInt();
                    scanner.nextLine();
                    PerishableParcel perishableParcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
                    allParcels.add(perishableParcel);
                    perishableBox.addParcelInBox(perishableParcel);
                    running = false;
                    break;
                case 3:
                    FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
                    allParcels.add(fragileParcel);
                    trackLocation.add(fragileParcel);
                    fragileBox.addParcelInBox(fragileParcel);
                    running = false;
                    break;
                default:
                    System.out.println("Выбран несуществующий тип посылки.");
                    break;
            }
        }
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
    }

    private static void sendParcels() {
        for ( Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();// Пройти по allParcels, вызвать packageItem() и deliver()
        }
    }

    private static void calculateCosts() {
        int finalCost = 0;
        for (Parcel parcel : allParcels) {
            finalCost += parcel.calculateDeliveryCost();// Посчитать общую стоимость всех доставок и вывести на экран
        }
        System.out.println("Общая стоимость всех посылок: " + finalCost);
    }

    private static void parcelTypeMenu() {
        System.out.println("1 —  стандартная");
        System.out.println("2 — быстропортящиеся");
        System.out.println("3 — хрупкая");
    }

    private static void locationReport() {
        System.out.println("Новое положение посылок: ");
        String newLocation = scanner.nextLine();
        for (Trackable parcel : trackLocation) {
            parcel.reportStatus(newLocation);
        }
    }

    private static void getParcelsFromTheBox() {
        boolean running = true;
        while (running) {
            System.out.println("Укажите тип коробки:");
            parcelTypeMenu();
            int boxType = scanner.nextInt();
            scanner.nextLine();
            switch (boxType) {
                case 1:
                    System.out.println(standardBox.getParcels());
                    running = false;
                    break;
                case 2:
                    System.out.println(perishableBox.getParcels());
                    running = false;
                    break;
                case 3:
                    System.out.println(fragileBox.getParcels());
                    running = false;
                    break;
                default:
                    System.out.println("Такого вида коробки не существует.");
                    break;

            }

        }
    }
}

