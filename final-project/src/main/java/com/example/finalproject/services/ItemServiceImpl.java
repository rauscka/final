package com.example.finalproject.services;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.finalproject.interfaces.ItemService;
import com.example.finalproject.objects.Item;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {
    private static Map<String, Item> itemRepo = new HashMap<>();
    static {
        Item sweats = new Item();
        sweats.setItemId("d83ff143-9f8b-445a-8d8f-b9b8fe0f9f29");
        sweats.setDescription("Drake Sweatpants");
        sweats.setImage("https://m.media-amazon.com/images/I/71mb8EpY2lL._SR500,500_.jpg");
        sweats.setPrice(30);
        itemRepo.put(sweats.getItemId(), sweats);

        Item sweats2 = new Item();
        sweats2.setItemId("7552a350-f498-4d17-b845-1354fbc010fb");
        sweats2.setDescription("Drake Sweatpants");
        sweats2.setImage("https://m.media-amazon.com/images/I/71mb8EpY2lL._SR500,500_.jpg");
        sweats2.setPrice(30);
        itemRepo.put(sweats2.getItemId(), sweats2);
    }
    @Override
    public void createItem(Item item) {
        itemRepo.put(item.getItemId(), item);
    }
    @Override
    public void updateItem(String id, Item item) {
        itemRepo.remove(id);
        item.setItemId(id);
        itemRepo.put(id, item);
    }
    @Override
    public void deleteItem(String id) {
        itemRepo.remove(id);

    }
    @Override
    public Collection<Item> getItems() {
        return itemRepo.values();
    }
    @Override
    public Item getItem(String id){
        return itemRepo.get(id);
    }
}
