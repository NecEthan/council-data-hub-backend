package com.example.council.data.hub.model;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table( name = "scraped_data" )
public class ScrapedData{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String websiteName;
    private String name;
    private String address;
    @JsonFormat(pattern = "MM/dd/yy")
    private LocalDate startDate;
    @JsonFormat(pattern = "MM/dd/yy")
    private LocalDate endDate;
    @Column(nullable = false, updatable = false)
    @JsonFormat(pattern = "MM/dd/yy")
    private LocalDate scrapedAt;

    public ScrapedData() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWebsiteName() {
        return websiteName;
    }

    public void setWebsiteName(String websiteName) {
        this.websiteName = websiteName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getScrapedAt() {
        return scrapedAt;
    }

    public void setScrapedAt(LocalDate scrapedAt) {
        this.scrapedAt = scrapedAt;
    }

    @Override
    public String toString() {
        return "ScrapedData{" +
                "id=" + id +
                ", websiteName='" + websiteName + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", scrapedAt=" + scrapedAt +
                '}';
    }
}
