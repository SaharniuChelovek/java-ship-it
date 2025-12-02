package ru.yandex.practicum.delivery.box;

import ru.yandex.practicum.delivery.parsel.Parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {

    private List<T> parcels = new ArrayList<>();
    private int totalWeight = 0;
    private int maximumWeight;

    public ParcelBox(int maximumWeight) {
        this.maximumWeight = maximumWeight;

    }


    public void addParcelInBox(T parcel) {
        if ((totalWeight + parcel.getWeight()) > maximumWeight) {
            System.out.println("Лимит по весу превышен, добавить посылку " + parcel.getDescription() + " невозможно.");
            return;
        } else {
            parcels.add(parcel);
            totalWeight += parcel.getWeight();
        }

    }

    public List<T> getParcels() {
        return parcels;
    }

    public int countOfParcelsInBox() {

        return parcels.size();
    }
}
