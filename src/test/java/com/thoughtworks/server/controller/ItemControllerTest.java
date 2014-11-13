package com.thoughtworks.server.controller;

import com.thoughtworks.server.model.Category;
import com.thoughtworks.server.model.Item;
import com.thoughtworks.server.service.ItemService;
import com.thoughtworks.server.service.ItemServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ItemControllerTest {
    Item item;
    List<Item> items = new ArrayList<Item>();

    ItemService itemServiceImpl;
    ItemController itemController;

    @Before
    public void init_items(){
        Category category = new Category(1, "水果");
        item = new Item(1, "葡萄", 6.5, "斤", category);
        items.add(item);

        itemServiceImpl = mock(ItemServiceImpl.class);

        int id =1;
        when(itemServiceImpl.getItemById(id)).thenReturn(item);
        when(itemServiceImpl.getItems()).thenReturn(items);

        itemController = new ItemController();
        ReflectionTestUtils.setField(itemController, "itemServiceImpl", itemServiceImpl);
    }

    @Test
    public void can_get_item_by_id(){
        assertEquals("葡萄", itemController.getItemById(1).getName());
    }

    @Test
    public void can_get_all_items(){
        assertEquals(1, itemController.getItems().size());
    }

    @Test
    public void can_insert_item(){
        itemController.insertItem(item);
        verify(itemServiceImpl).insertItem(item);
    }

    @Test
    public void can_update_item_by_id(){
        itemController.updateItemById(item);
        verify(itemServiceImpl).updateItemById(item);
    }

    @Test
    public void can_delete_category_by_id(){
        itemController.deleteItemById(1);
        verify(itemServiceImpl).deleteItemById(1);
    }
}
