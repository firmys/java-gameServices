package com.firmys.gameservices.world.location;

import com.firmys.gameservices.world.impl.Inventory;
import com.firmys.gameservices.world.impl.Item;

import java.util.Set;
import java.util.UUID;

public interface Location {

    int[] getCoordinates();
    void setCoordinates(int[] coordinates);
    String getDescription();
    String getName();
    UUID getUuid();
    void addCharacter(Character character);
    void removeCharacter(Character character);
    Set<Character> getCharacters();
    void addItem(Item item, Integer amount);
    void setDescription(String description);
    void setName(String name);
    Inventory getInventory();
}
