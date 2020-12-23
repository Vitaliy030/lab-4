package com.springbootproject.dto;

import java.util.List;

public class SitesDTO {
    private List<SiteDTO> items;


    public List<SiteDTO> getItems() {
        return items;
    }

    public void setItems(final List<SiteDTO> items) {
        this.items = items;
    }
}
