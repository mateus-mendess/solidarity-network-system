package model.entities;

import enums.*;

import java.io.FileReader;

public class Volunteer extends Person {
    private DayOfWeek dayOfWeek;
    private AvailabilityPeriod availabilityPeriod;
    private Frequency frequency;
    private EducationLevel educationLevel;
    private SpecificSkill specificSkill;
    private VolunteerExperience volunteerExperience;
    private InterestArea interestArea;
    private Address address;

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public AvailabilityPeriod getAvailabilityPeriod() {
        return availabilityPeriod;
    }

    public void setAvailabilityPeriod(AvailabilityPeriod availabilityPeriod) {
        this.availabilityPeriod = availabilityPeriod;
    }

    public Frequency getFrequency() {
        return frequency;
    }

    public void setFrequency(Frequency frequency) {
        this.frequency = frequency;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public SpecificSkill getSpecificSkill() {
        return specificSkill;
    }

    public void setSpecificSkill(SpecificSkill specificSkill) {
        this.specificSkill = specificSkill;
    }

    public VolunteerExperience getVolunteerExperience() {
        return volunteerExperience;
    }

    public void setVolunteerExperience(VolunteerExperience volunteerExperience) {
        this.volunteerExperience = volunteerExperience;
    }

    public InterestArea getInterestArea() {
        return interestArea;
    }

    public void setInterestArea(InterestArea interestArea) {
        this.interestArea = interestArea;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
