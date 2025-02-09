package com.example.council.data.hub.service;

import com.example.council.data.hub.model.ScrapedData;
import com.example.council.data.hub.repo.ScrapedDataRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ScrapedDataService {

    private final ScrapedDataRepo scrapedDataRepo;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ScrapedDataService(ScrapedDataRepo scrapedDataRepo, JdbcTemplate jdbcTemplate) {
        this.scrapedDataRepo = scrapedDataRepo;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<ScrapedData> getAllData() {
        return scrapedDataRepo.findAll();
    }

    public List<ScrapedData> getWebsitesDataByName(String websiteName) {
        return scrapedDataRepo.findByWebsiteNameContaining(websiteName);
    }

    @Transactional
    public void deleteAllData() {
        scrapedDataRepo.deleteAll();
        jdbcTemplate.execute("ALTER SEQUENCE scraped_data_id_seq RESTART WITH 1;");
    }

    @Transactional
    public void deleteDataByWebsite(String websiteName) {
        List<ScrapedData> websiteData = scrapedDataRepo.findByWebsiteNameContaining(websiteName);
        scrapedDataRepo.deleteAll(websiteData);
    }

    public List<ScrapedData> getDataByWebsiteAndDate(String websiteName, LocalDate date) {
        List<ScrapedData> websiteData = scrapedDataRepo.findByWebsiteNameAndDate(websiteName, date);
        return websiteData;
    }

    @Transactional
    public void deleteDataByWebsiteAndDate(String websiteName, LocalDate date) {
        List<ScrapedData> websiteData = scrapedDataRepo.findByWebsiteNameAndDate(websiteName, date);
        scrapedDataRepo.deleteAll(websiteData);
    }


}
