package ru.yandex.practicum.delivery.parsel;

public class PerishableParcel extends Parcel {

    protected int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getUnitCost() {
        return ParcelType.PERISHABLE.getUnitCost();
    }

    @Override
    public String getType() {
        return ParcelType.PERISHABLE.name();
    }

    public boolean isExpired(int currentDay) {
        if ((sendDay + timeToLive) >= currentDay ) {
            return false;
        } else {
            return true;
        }
    }


    public int getTimeToLive() {
        return timeToLive;
    }

    @Override
    public String toString() {
        return "PerishableParcel{" +
                "timeToLive=" + timeToLive +
                ", description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}
