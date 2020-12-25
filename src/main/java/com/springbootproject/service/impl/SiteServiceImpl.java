package com.springbootproject.service.impl;

import com.springbootproject.dto.SitesDTO;
import com.springbootproject.mapper.SitesToSitesDTOMapper;
import com.springbootproject.repository.StackExchangeRepository;
import com.springbootproject.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SiteServiceImpl implements SiteService {

    @Autowired
    private StackExchangeRepository stackExchangeRepository;

    @Autowired
    private SitesToSitesDTOMapper sitesMapper;


    @Override
    public SitesDTO getSites() {
        return sitesMapper.toDTO(stackExchangeRepository.getSites());
    }
}
