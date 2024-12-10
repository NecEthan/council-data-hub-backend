package com.example.council.data.hub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

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
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @Column(nullable = false, updatable = false)
    private LocalDateTime scrapedAt;

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

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public LocalDateTime getScrapedAt() {
        return scrapedAt;
    }

    public void setScrapedAt(LocalDateTime scrapedAt) {
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
