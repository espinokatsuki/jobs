package io.maya.jobs.model;

import java.util.Date;

public class Vacant {

    private Integer id;
    private String name;
    private String description;
    private Double salary;
    private Boolean active;
    private Date publicationDate;
    private Integer highlighted;
    private String image = "no-image.png";
    private String status;
    private String details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Integer getHighlighted() {
        return highlighted;
    }

    public void setHighlighted(Integer highlighted) {
        this.highlighted = highlighted;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "Vacant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", salary=" + salary +
                ", active=" + active +
                ", publicationDate=" + publicationDate +
                ", highlighted=" + highlighted +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
