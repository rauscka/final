package com.example.finalproject.interfaces;

import com.example.finalproject.objects.Item;

import java.util.Collection;

public interface ItemService {
    public abstract void createItem(Item item);
    public abstract void updateItem(String id, Item item);
    public abstract void deleteItem(String id);
    public abstract Collection<Item> getItems();
    public abstract Item getItem(String id);
}
