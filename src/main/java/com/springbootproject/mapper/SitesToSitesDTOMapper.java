package com.springbootproject.mapper;

import com.springbootproject.dto.SiteDTO;
import com.springbootproject.dto.SitesDTO;
import com.springbootproject.entity.Site;
import com.springbootproject.entity.Sites;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SitesToSitesDTOMapper {

    @Autowired
    private SiteToSiteDTOMapper siteToSiteDTOMapper;


    public Sites toEntity(final SitesDTO sitesDTO) {
        final Sites sites = new Sites();

        final List<Site> siteList = new ArrayList<>();
        for (final SiteDTO siteDTO : sitesDTO.getItems()) {
            siteList.add(siteToSiteDTOMapper.toEntity(siteDTO));
        }
        sites.setItems(siteList);

        return sites;
    }

    public SitesDTO toDTO(final Sites sites) {
        final SitesDTO sitesDTO = new SitesDTO();

        final List<SiteDTO> siteDTOList = new ArrayList<>();
        for (final Site site : sites.getItems()) {
            siteDTOList.add(siteToSiteDTOMapper.toDTO(site));
        }
        sitesDTO.setItems(siteDTOList);

        return sitesDTO;
    }
}
