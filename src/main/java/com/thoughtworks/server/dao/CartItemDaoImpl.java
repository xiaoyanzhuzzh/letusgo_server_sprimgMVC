package com.thoughtworks.server.dao;

import com.thoughtworks.server.model.CartItem;
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
        String sql = "SELECT * FROM cartItems WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new RowMapper<CartItem>() {
            @Override
            public CartItem mapRow(ResultSet rs, int i) throws SQLException {
                return new CartItem(rs.getInt("id"), rs.getInt("itemId"), rs.getInt("num"));
            }
        }, id);
    }

    @Override
    public List<CartItem> getCartItems() {
        String sql = "SELECT * FROM cartItems";
        return jdbcTemplate.query(sql, new RowMapper<CartItem>() {
            @Override
            public CartItem mapRow(ResultSet rs, int i) throws SQLException {
                return new CartItem(rs.getInt("id"), rs.getInt("itemId"), rs.getInt("num"));
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

    }
}
