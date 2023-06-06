package com.test.easybot.entity;

public enum ProductTypeEnum {
    PC("Ноутбуки"), LAPTOP("Настольные компьютеры"), MONITOR("Мониторы"), HARD_DRIVE("Жесткие диски");
    private final String name;

    ProductTypeEnum(String name) {
        this.name =name;
    }
    public String getName() {
        return name;
    }
}
