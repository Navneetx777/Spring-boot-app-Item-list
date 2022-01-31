package com.app.demo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ItemService {

    private final ItemRepo itemRepo;

    @Autowired
    public ItemService(ItemRepo itemRepo) {
        this.itemRepo = itemRepo;
    }

    public List<Item> getItems() {
        return itemRepo.findAll();
    }

    public void addItem(Item item) {

        itemRepo.save(item);
    }

    public void deleteItem(Long itemId) {
        boolean exists = itemRepo.existsById(itemId);
        if(!exists) {
            throw new IllegalStateException("Item with id " + itemId + "does not exist");
        }
        itemRepo.deleteById(itemId);

    }

    @Transactional
    public void updateItem(Long itemId, String itemName, Integer itemQuantity) {
        Item item = itemRepo.findById(itemId).
                orElseThrow (() -> new IllegalStateException("Item with id " + itemId + "does not exist"));
        if(itemName!= null && itemName.length()>0 && !Objects.equals(item.getName(), itemName))
        {
            item.setName(itemName);
        }
        if(itemQuantity!=null && itemQuantity>0 && !Objects.equals(item.getQuantity(), itemQuantity))
        {
            item.setQuantity(itemQuantity);
        }
        itemRepo.save(item);
    }
}
