package net.vanheesch.persistence;

import net.vanheesch.domain.Item;

import java.util.List;

public interface IItemDAO {

    List<Item> getItems();
    Item findItemByName(String name);
}
