package ru.yandex.practicum.delivery.parsel;

public class StandardParcel extends Parcel {

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getUnitCost() {
        return ParcelType.STANDARD.getUnitCost();
    }

    @Override
    public String getType() {
        return ParcelType.STANDARD.name();
    }
}
