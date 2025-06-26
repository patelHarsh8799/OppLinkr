package com.zidio.Opplinkr.dto;

import java.time.LocalDate;

public class JobRequest {
    public String title;
    public String description;
    public String location;
    public String type; // JOB or INTERNSHIP
    public boolean remote;
    public LocalDate startDate;
    public int durationWeeks;
    public double stipend;
    public String companyName;
    public String skill;
}
