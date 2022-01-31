package com.app.demo.item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long>
{
    Optional<Item> findItemById(Long itemId);
    Optional<Item> findItemByName(String itemName);
}