/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gr.codelearn.core.showcase.oop.model;

import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author iracl
 */
public class ImmutableProduct extends Object{
    private final String serial;
    private final String name;
    private final BigDecimal price;
    private final int inventoryQuantity;
    private final Coupon coupon;

    public ImmutableProduct(String serial, String name, BigDecimal price, int inventoryQuantity, Coupon coupon) {
        this.serial = serial;
        this.name = name;
        this.price = price;
        this.inventoryQuantity = inventoryQuantity;
        this.coupon = coupon;
    }

    @Override
    public String toString() {
        return "ImmutableProduct{" + "serial=" + serial + ", name=" + name + ", price=" + price + ", inventoryQuantity=" + inventoryQuantity + ", coupon=" + coupon + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.serial);
        hash = 53 * hash + Objects.hashCode(this.name);
        hash = 53 * hash + Objects.hashCode(this.price);
        hash = 53 * hash + this.inventoryQuantity;
        hash = 53 * hash + Objects.hashCode(this.coupon);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ImmutableProduct other = (ImmutableProduct) obj;
        if (this.inventoryQuantity != other.inventoryQuantity) {
            return false;
        }
        if (!Objects.equals(this.serial, other.serial)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        if (!Objects.equals(this.coupon, other.coupon)) {
            return false;
        }
        return true;
    }

    
}
