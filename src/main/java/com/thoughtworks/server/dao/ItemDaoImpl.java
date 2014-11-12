package com.thoughtworks.server.dao;

import com.thoughtworks.server.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Item getItemById(int id) {
        String sql = "SELECT * FROM items WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int i) throws SQLException {
                return new Item(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("unit"), rs.getInt("categoryId"));
            }
        }, id);
    }

    @Override
    public void deleteItemById(int id) {
        String sql = "DELETE FROM items WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public List<Item> getItems() {
        String sql = "SELECT * FROM items";

        return jdbcTemplate.query(sql, new RowMapper<Item>() {
            @Override
            public Item mapRow(ResultSet rs, int i) throws SQLException {
                return new Item(rs.getInt("id"), rs.getString("name"), rs.getDouble("price"),
                        rs.getString("unit"), rs.getInt("categoryId"));
            }
        });
    }
}
