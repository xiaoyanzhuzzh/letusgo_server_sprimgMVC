package com.thoughtworks.server.controller;

import com.thoughtworks.server.model.Category;
import com.thoughtworks.server.service.CategoryService;
import com.thoughtworks.server.service.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class CategoryControllerTest {
    Category category;
    List<Category> categories = new ArrayList<Category>();

    @Before
    public void init_category(){
        category = new Category(1, "水果");
        categories.add(category);
    }

    @Test
    public void can_get_category_by_id(){
        CategoryService categoryServiceImpl = mock(CategoryServiceImpl.class);
        int id = 1;
        when(categoryServiceImpl.getCategoryById(id)).thenReturn(category);

        CategoryController categoryController = new CategoryController();
        ReflectionTestUtils.setField(categoryController, "categoryServiceImpl", categoryServiceImpl);

        assertEquals("水果", categoryController.getCategoryById(1).getName());
    }
}
