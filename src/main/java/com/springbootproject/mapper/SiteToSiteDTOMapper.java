package com.springbootproject.mapper;

import com.springbootproject.dto.SiteDTO;
import com.springbootproject.entity.Site;
import org.springframework.stereotype.Component;

@Component
public class SiteToSiteDTOMapper {
    public Site toEntity(final SiteDTO siteDTO) {
        final Site site = new Site();

        site.setSite_url(siteDTO.getSite_url());
        site.setName(siteDTO.getName());

        return site;
    }

    public SiteDTO toDTO(final Site site) {
        final SiteDTO siteDTO = new SiteDTO();

        siteDTO.setSite_url(site.getSite_url());
        siteDTO.setName(site.getName());

        return siteDTO;
    }
}
