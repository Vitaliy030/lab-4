package com.springbootproject.resource;

import com.springbootproject.dto.SitesDTO;
import com.springbootproject.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SiteResource {

    @Autowired
    SiteService siteService;


    @GetMapping("/sites")
    public SitesDTO getSites() {
        return siteService.getSites();
    }
}
