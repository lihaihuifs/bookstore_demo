package com.haihui.book.bookstore_demo.entity;
/**
 * @author : lihai
 * @mailto : lihaihuifs@outlook.com
 * @created : 2022/5/8, 星期日
 * @version : 1.0
 **/

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @version : [v1.0]
 * @description :
 */
public class Cart {
    private Map<Integer, CartItem> items = new LinkedHashMap<Integer, CartItem>();

    public void addItem(CartItem item) {
        Integer id = item.getId();
        CartItem cartItem = items.get(id); // Check if already in cart
        if (cartItem != null) { // If exists, update fields
            cartItem.setCount(cartItem.getCount() + 1); // Add count
            cartItem.setTotalPrice(cartItem.getTotalPrice().add(cartItem.getPrice()));
        } else { // If not exists, add to cart
            items.put(id, item);
        }
    }

    public void deleteItem(Integer id) {
        items.remove(id);
    }

    public void clear() {
        items.clear();
    }

    /**
     * Update item's count
     */
    public void updateCount(Integer id, Integer count) {
        CartItem cartItem = items.get(id);
        if (cartItem != null) {
            cartItem.setCount(count);
            cartItem.setTotalPrice(cartItem.getPrice().multiply(new
                    BigDecimal(cartItem.getCount())));
        }
    }

    public Integer getTotalCount() {
        Integer totalCount = 0;
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalCount += entry.getValue().getCount();
        }
        return totalCount;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = new BigDecimal(0);
        for (Map.Entry<Integer, CartItem> entry : items.entrySet()) {
            totalPrice = totalPrice.add(entry.getValue().getTotalPrice());
        }
        return totalPrice;
    }

    public Map<Integer, CartItem> getItems() {
        return items;
    }

    public void setItems(Map<Integer, CartItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "totalCount=" + getTotalCount() +
                ", totalPrice=" + getTotalPrice() +
                ", items=" + items +
                '}';
    }
}