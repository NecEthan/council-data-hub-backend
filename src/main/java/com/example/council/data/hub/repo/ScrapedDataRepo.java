package com.example.council.data.hub.repo;

import com.example.council.data.hub.model.ScrapedData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ScrapedDataRepo extends JpaRepository<ScrapedData, Long> {

    List<ScrapedData> findByWebsiteNameContaining(String websiteName);

}
