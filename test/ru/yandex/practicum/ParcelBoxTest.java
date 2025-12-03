package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.box.ParcelBox;
import ru.yandex.practicum.delivery.parsel.FragileParcel;

public class ParcelBoxTest {

    ParcelBox<FragileParcel> fragileParcelBox;

    @BeforeEach
    void fragileBox() {
        fragileParcelBox = new ParcelBox<>(10);
    }

    @Test
    void addParcelWithLowWeight() {
        fragileParcelBox.addParcelInBox(new FragileParcel("", 9, "", 5));
        Assertions.assertEquals(1, fragileParcelBox.countOfParcelsInBox());
    }
    //вес посылки меньше лимита коробки

    @Test
    void addParcelWithLimitWeight() {
        fragileParcelBox.addParcelInBox(new FragileParcel("", 10, "", 5));
        Assertions.assertEquals(1, fragileParcelBox.countOfParcelsInBox());
    }
    //вес посылки равен лимиту коробки

    @Test
    void addParcelWithHighWeight() {
        fragileParcelBox.addParcelInBox(new FragileParcel("", 11, "", 5));
        Assertions.assertEquals(0, fragileParcelBox.countOfParcelsInBox());
    }
    //вес посылки больше лимита коробки
}
