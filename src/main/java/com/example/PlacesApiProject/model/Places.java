package com.example.PlacesApiProject.model;

import javax.persistence.*;

@Entity
@Table
public class Places {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_generator")
    @SequenceGenerator(name = "id_generator", sequenceName = "place_seq", initialValue = 1, allocationSize = 1)
    private Long id;

    private String url;

    private String html_attributions;

    @Lob
    @Column
    private String results;

    private String status;

    public Places() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml_attributions() {
        return html_attributions;
    }

    public void setHtml_attributions(String html_attributions) {
        this.html_attributions = html_attributions;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
