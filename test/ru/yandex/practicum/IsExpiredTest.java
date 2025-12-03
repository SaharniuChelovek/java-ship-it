package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parsel.PerishableParcel;

public class IsExpiredTest {
    PerishableParcel perishableParcel;

    @Test
    void isExpiredTestLowValue() {
        perishableParcel = new PerishableParcel("", 10, "", 5, 5);
        Assertions.assertFalse(perishableParcel.isExpired((perishableParcel.getSendDay() + perishableParcel.getTimeToLive()-1)));
    }
    //currentDay < (sendDay + timeToLive)

    @Test
    void isExpiredTestLimitValue() {
        perishableParcel = new PerishableParcel("", 10, "", 5, 5);
        Assertions.assertFalse(perishableParcel.isExpired((perishableParcel.getSendDay() + perishableParcel.getTimeToLive())));
    }
    //currentDay == (sendDay + timeToLive)

    @Test
    void isExpiredTestHighValue() {
        perishableParcel = new PerishableParcel("", 10, "", 5, 5);
        Assertions.assertTrue(perishableParcel.isExpired((perishableParcel.getSendDay() + perishableParcel.getTimeToLive()+1)));
    }
    //currentDay > (sendDay + timeToLive)
}
