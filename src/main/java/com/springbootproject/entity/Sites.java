package com.springbootproject.entity;

import java.util.List;

public class Sites {
    private List<Site> items;


    public List<Site> getItems() {
        return items;
    }

    public void setItems(final List<Site> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Sites{" +
                "items=" + items +
                '}';
    }
}
