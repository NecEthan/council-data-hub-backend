package com.example.council.data.hub.service;

import com.example.council.data.hub.model.ScrapedData;
import com.example.council.data.hub.repo.ScrapedDataRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScrapedDataService {

    private final ScrapedDataRepo scrapedDataRepo;

    @Autowired
    public ScrapedDataService(ScrapedDataRepo scrapedDataRepo) {
        this.scrapedDataRepo = scrapedDataRepo;
    }

    public List<ScrapedData> getAllData() {
        return scrapedDataRepo.findAll();
    }

    public List<ScrapedData> getWebsitesDataByName(String websiteName) {
        return scrapedDataRepo.findByWebsiteNameContaining(websiteName);
    }

    public void deleteAllData() {
        scrapedDataRepo.deleteAll();
    }

    public void deleteDataByWebsite(String websiteName) {
        List<ScrapedData> websiteData = scrapedDataRepo.findByWebsiteNameContaining(websiteName);
        scrapedDataRepo.deleteAll(websiteData);
    }

}
