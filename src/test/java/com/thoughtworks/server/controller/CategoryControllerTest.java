package com.thoughtworks.server.controller;

import com.thoughtworks.server.model.Category;
import com.thoughtworks.server.service.CategoryService;
import com.thoughtworks.server.service.CategoryServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class CategoryControllerTest {
    Category category;
    List<Category> categories = new ArrayList<Category>();

    CategoryService categoryServiceImpl;
    CategoryController categoryController;

    @Before
    public void init_category(){
        category = new Category(1, "水果");
        categories.add(category);

        categoryServiceImpl = mock(CategoryServiceImpl.class);

        int id = 1;
        when(categoryServiceImpl.getCategoryById(id)).thenReturn(category);
        when(categoryServiceImpl.getCategories()).thenReturn(categories);

        categoryController = new CategoryController();
        ReflectionTestUtils.setField(categoryController, "categoryServiceImpl", categoryServiceImpl);
    }

    @Test
    public void can_get_category_by_id(){
        assertEquals("水果", categoryController.getCategoryById(1).getName());
    }

    @Test
    public void can_get_all_categories(){
        assertEquals(1, categoryController.getCategories().size());
    }

    @Test
    public void can_insert_category(){
        categoryController.insertCategory(category);
        verify(categoryServiceImpl).insertCategory(category);
    }

    @Test
    public void can_update_category_by_id(){
        categoryController.updateCategory(category);
        verify(categoryServiceImpl).updateCategoryById(category);
    }

    @Test
    public void can_delete_category_by_id(){
        categoryController.deleteCategoryById(1);
        verify(categoryServiceImpl).deleteCategoryById(1);
    }
}
