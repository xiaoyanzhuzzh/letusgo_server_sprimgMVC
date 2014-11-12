package com.thoughtworks.server.dao;

import com.thoughtworks.server.model.CartItem;
import com.thoughtworks.server.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class CartItemDaoImpl implements CartItemDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CartItem getCartItemById(int id) {
        String sql = "SELECT * FROM cartItems, items WHERE cartItems.id = ? AND items.id = cartItems.itemId";
        return jdbcTemplate.queryForObject(sql, new RowMapper<CartItem>() {
            @Override
            public CartItem mapRow(ResultSet rs, int i) throws SQLException {
                Item item = new Item(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("unit"), rs.getInt("categoryId"));
                return new CartItem(rs.getInt("id"), item, rs.getInt("num"));
            }
        }, id);
    }

    @Override
    public List<CartItem> getCartItems() {
        String sql = "SELECT * FROM cartItems, items WHERE items.id = cartItems.itemId";
        return jdbcTemplate.query(sql, new RowMapper<CartItem>() {
            @Override
            public CartItem mapRow(ResultSet rs, int i) throws SQLException {
                Item item = new Item(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("unit"), rs.getInt("categoryId"));
                return new CartItem(rs.getInt("id"), item, rs.getInt("num"));
            }
        });
    }

    @Override
    public void insertCartItem(CartItem cartItem) {
        String sql = "INSERT INTO cartItems VALUES(null, ?, ?)";
        jdbcTemplate.update(sql, cartItem.getItemId(), cartItem.getNum());
    }

    @Override
    public void deleteCartItemById(int id) {
        String sql = "DELETE FROM cartItems WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public void updateCartItemById(CartItem cartItem) {
        String sql = "UPDATE cartItems SET itemId = ?, num = ? WHERE id = ?";
        jdbcTemplate.update(sql, cartItem.getItemId(), cartItem.getNum(), cartItem.getId());
    }
}
