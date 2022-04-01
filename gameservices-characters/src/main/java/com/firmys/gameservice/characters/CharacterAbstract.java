package com.firmys.gameservice.characters;

import com.firmys.gameservice.inventory.impl.PlayerCharacterInventory;

import java.util.UUID;

public class CharacterAbstract {
    private final UUID uuid;
    private final String name;
    private final String description;
    private final Gender gender;
    private final int height;
    private final int weight;
    private final PlayerCharacterInventory inventory;

    public CharacterAbstract(UUID uuid, String name,
                             String description, Gender gender,
                             int height, int weight,
                             PlayerCharacterInventory inventory) {
        this.uuid = uuid;
        this.name = name;
        this.description = description;
        this.gender = gender;

        this.height = height;
        this.weight = weight;
        this.inventory = inventory;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Gender getGender() {
        return gender;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public PlayerCharacterInventory getInventory() {
        return inventory;
    }
}