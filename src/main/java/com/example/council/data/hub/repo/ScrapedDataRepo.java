package com.example.council.data.hub.repo;

import com.example.council.data.hub.model.ScrapedData;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScrapedDataRepo extends JpaRepository<ScrapedData, Long> {

    ScrapedData findByWebsiteName(String websiteName);

}
