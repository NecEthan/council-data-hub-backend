package com.example.council.data.hub;
import com.example.council.data.hub.model.ScrapedData;
import com.example.council.data.hub.repo.ScrapedDataRepo;
import com.example.council.data.hub.service.ScrapedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/scrape")
public class ScrapedDateController {

    private final ScrapedDataService scrapedDataService;
    private final ScrapedDataRepo scrapedDataRepo;


    @Autowired
    public ScrapedDateController(ScrapedDataService scrapedDataService, ScrapedDataRepo scrapedDataRepo) {
        this.scrapedDataService = scrapedDataService;
        this.scrapedDataRepo = scrapedDataRepo;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ScrapedData>> getAllScrapedData() {
        List<ScrapedData> data = scrapedDataService.getAllData();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @GetMapping("/get/{websiteName}/{date}")
    public ResponseEntity<List<ScrapedData>> getDataByWebsiteAndDate(
            @PathVariable("websiteName") String websiteName,
            @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date
    ) {
        List<ScrapedData> data = scrapedDataService.getDataByWebsiteAndDate(websiteName, date);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @PostMapping("/save")
    public ResponseEntity<String> saveData(@RequestBody List<ScrapedData> dataList) {
        scrapedDataRepo.saveAll(dataList);
        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("/{websiteName}")
    public ResponseEntity<List<ScrapedData>> getDataByWebsiteName(@PathVariable("websiteName") String websiteName) {
        List<ScrapedData> data = scrapedDataService.getWebsitesDataByName(websiteName);
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteData() {
        scrapedDataService.deleteAllData();
        return ResponseEntity.ok("data deleted");
    }

    @DeleteMapping("/delete/{websiteName}")
    public ResponseEntity<?> deleteDataByWebsiteName(@PathVariable("websiteName") String websiteName) {
        scrapedDataService.deleteDataByWebsite(websiteName);
        return ResponseEntity.ok("data deleted");
    }

    @DeleteMapping("/delete/{websiteName}/{year}/{month}")
    public ResponseEntity<?> deleteDataByWebsiteAndMonth(
            @PathVariable("websiteName") String websiteName,
            @PathVariable("year") int year,
            @PathVariable("month") int month
    ) {
        scrapedDataService.deleteDataByWebsiteAndMonth(websiteName, year, month);
        return ResponseEntity.ok("Data successfully deleted");
    }



}
