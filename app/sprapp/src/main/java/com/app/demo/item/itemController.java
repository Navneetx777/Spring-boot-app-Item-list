package com.app.demo.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/items")
public class itemController {

    private final ItemService itemService;

    @Autowired
    public itemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getItems() {
        return itemService.getItems();
    }

    @PostMapping
    public void newItem(@RequestBody Item item)
    {
        itemService.addItem(item);
    }

    @DeleteMapping(path = "{itemId}")
    public void deleteItem(@PathVariable("itemId") Long itemId) {
        itemService.deleteItem(itemId);
    }

    @PutMapping(path = "{itemId}")
    public void updateItem(
            @PathVariable("itemId") Long itemId,
            @RequestParam(name = "name", required = false) String itemName,
            @RequestParam(name = "quantity", required = false) Integer itemQuantity
    ){
        itemService.updateItem(itemId, itemName, itemQuantity);
    }

}
