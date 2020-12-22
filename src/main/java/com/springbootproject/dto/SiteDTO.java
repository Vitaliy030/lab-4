package com.springbootproject.dto;

public class SiteDTO {
    private String site_url;
    private String name;


    public String getSite_url() {
        return site_url;
    }

    public void setSite_url(final String site_url) {
        this.site_url = site_url;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "SiteDTO{" +
                "site_url='" + site_url + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
