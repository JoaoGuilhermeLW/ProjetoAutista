package br.com.ufpi.api;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Task {

    private Long id;
    private Date start;
    private Date end;
    private Integer touches;
    private Integer hits;
    private Integer faults;
    private Boolean finished;
    private Long lesson_id;

    public Task(){
        this.start = new Date();
        this.touches = 0;
        this.hits = 0;
        this.faults = 0;
        this.finished = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public Integer getTouches() {
        return touches;
    }

    public void setTouches(Integer touches) {
        this.touches = touches;
    }

    public Integer getHits() {
        return hits;
    }

    public void setHits(Integer hits) {
        this.hits = hits;
    }

    public Integer getFaults() {
        return faults;
    }

    public void setFaults(Integer faults) {
        this.faults = faults;
    }

    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
    }

    public Long getDuration(){
        return (end.getTime() - start.getTime()) / 1000l;
    }

    public Long getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Long lesson_id) {
        this.lesson_id = lesson_id;
    }

    public String getDate(){
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
        return format.format(start);
    }

    public void addHit(){
        this.hits++;
    }

    public void addFault(){
        this.faults++;
    }

    @Override
    public String toString() {
        return this.getDate();
    }
}
