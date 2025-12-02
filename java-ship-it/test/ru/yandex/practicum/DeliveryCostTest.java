package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.box.ParcelBox;
import ru.yandex.practicum.delivery.parsel.FragileParcel;
import ru.yandex.practicum.delivery.parsel.PerishableParcel;
import ru.yandex.practicum.delivery.parsel.StandardParcel;

public class DeliveryCostTest {
    ParcelBox<FragileParcel> fragileParcelBox;
    FragileParcel fragileParcel;
    PerishableParcel perishableParcel;
    StandardParcel standardParcel;

    @BeforeEach
    void fragileBox() {
    fragileParcelBox = new ParcelBox<>(10);
    }



    @Test
    void standardCostTest() {
        standardParcel = new StandardParcel("", 10, "", 5);
        Assertions.assertEquals((standardParcel.getWeight() * standardParcel.getUnitCost()), standardParcel.calculateDeliveryCost());
    }
    @Test
    void perishableCostTest() {
        perishableParcel = new PerishableParcel("", 10, "", 5, 5);
        Assertions.assertEquals((perishableParcel.getWeight() * perishableParcel.getUnitCost()), perishableParcel.calculateDeliveryCost());
    }
    @Test
    void fragileCostTest() {
        fragileParcel = new FragileParcel("", 10, "", 5);
        Assertions.assertEquals((fragileParcel.getWeight() * fragileParcel.getUnitCost()), fragileParcel.calculateDeliveryCost());
    }
    @Test
    void isExpiredTestLowValue() {
        perishableParcel = new PerishableParcel("", 10, "", 5, 5);
        Assertions.assertFalse(perishableParcel.isExpired(7));
    }

    @Test
    void isExpiredTestLimitValue() {
        perishableParcel = new PerishableParcel("", 10, "", 5, 5);
        Assertions.assertFalse(perishableParcel.isExpired(10));
    }

    @Test
    void isExpiredTestHighValue() {
        perishableParcel = new PerishableParcel("", 10, "", 5, 5);
        Assertions.assertTrue(perishableParcel.isExpired(11));
    }

    @Test
    void add1ParcelShouldReturn() {
        fragileParcelBox.addParcelInBox(new FragileParcel("", 5, "", 5));
        Assertions.assertEquals(1, fragileParcelBox.countOfParcelsInBox());
    }

    @Test
    void add2ParcelShouldReturn() {
        fragileParcelBox.addParcelInBox(new FragileParcel("", 5, "", 5));
        fragileParcelBox.addParcelInBox(new FragileParcel("", 5, "", 5));
        Assertions.assertEquals(2, fragileParcelBox.countOfParcelsInBox());
    }

    @Test
    void add3ParcelShouldReturn() {
        fragileParcelBox.addParcelInBox(new FragileParcel("", 5, "", 5));
        fragileParcelBox.addParcelInBox(new FragileParcel("", 5, "", 5));
        fragileParcelBox.addParcelInBox(new FragileParcel("", 5, "", 5));
        Assertions.assertEquals(2, fragileParcelBox.countOfParcelsInBox());
    }
}
