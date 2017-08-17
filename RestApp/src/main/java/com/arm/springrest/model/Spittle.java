package com.arm.springrest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;

@Entity
@Table(name="SPITTLE")
public class Spittle implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="spittle_id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Long spittle_id;

    @Column(name="message")
    String message;

    @Column(name="latitude")
    Double latitude;

    @Column(name="longitude")
    Double longitude;

    @Column(name="insert_date")
    @Temporal(TemporalType.TIMESTAMP)
    Calendar insert_date;

    @Column(name="last_update")
    @Temporal(TemporalType.TIMESTAMP)
    Calendar last_update;

    @ManyToOne
    @JoinColumn(name="spitter_id")
    private  Spitter spitter;

    public Long getSpittle_id() {
        return spittle_id;
    }

    public void setSpittle_id(Long spittle_id) {
        this.spittle_id = spittle_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Calendar getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Calendar insert_date) {
        this.insert_date = insert_date;
    }

    public Calendar getLast_update() {
        return last_update;
    }

    public void setLast_update(Calendar last_update) {
        this.last_update = last_update;
    }

    public Spitter getSpitter() {
        return spitter;
    }

    public void setSpitter(Spitter spitter) {
        this.spitter = spitter;
    }
}
