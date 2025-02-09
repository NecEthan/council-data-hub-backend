package com.example.council.data.hub.repo;

import com.example.council.data.hub.model.ScrapedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;


public interface ScrapedDataRepo extends JpaRepository<ScrapedData, Long> {

    List<ScrapedData> findByWebsiteNameContaining(String websiteName);


    @Query("SELECT s FROM ScrapedData s WHERE s.websiteName = :websiteName AND s.date = :date")
    List<ScrapedData> findByWebsiteNameAndDate(@Param("websiteName") String name, @Param("date") LocalDate date);


}
