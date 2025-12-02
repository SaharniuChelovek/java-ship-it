package ru.yandex.practicum.delivery.parsel;

public enum ParcelType {
    STANDARD(2),
    FRAGILE(4),
    PERISHABLE(3);

    private Integer unitCost;

    ParcelType(Integer unitCost) {
        this.unitCost = unitCost;
    }
    public int getUnitCost() {
        return unitCost;
    }
}
