package com.example.council.data.hub;
import com.example.council.data.hub.model.ScrapedData;
import com.example.council.data.hub.repo.ScrapedDataRepo;
import com.example.council.data.hub.service.ScrapedDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scrape")
public class ScrapedDateController {

    private final ScrapedDataService scrapedDataService;
    private final ScrapedDataRepo scrapedDataRepo;


    // Constructor Injection
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




}
