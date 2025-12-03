package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parsel.FragileParcel;
import ru.yandex.practicum.delivery.parsel.PerishableParcel;
import ru.yandex.practicum.delivery.parsel.StandardParcel;

public class DeliveryCostTest {
    FragileParcel fragileParcel;
    PerishableParcel perishableParcel;
    StandardParcel standardParcel;

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
    void CostTestWhenWeightIs0() {
        standardParcel = new StandardParcel("", 0, "", 5);
        Assertions.assertEquals((standardParcel.getWeight() * standardParcel.getUnitCost()), standardParcel.calculateDeliveryCost());
    }
}
