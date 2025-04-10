package service;

import dto.VolunteerDTO;
import enums.*;
import model.entities.Volunteer;
import model.repository.VolunteerRepository;

public class VolunteerService {

    public void registerVolunteer(VolunteerDTO volunteerDTO) {
        try {
            this.volunteerValidate(volunteerDTO);
            Volunteer volunteer = this.convertDtoToEntities(volunteerDTO);
            this.saveVolunteer(volunteer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Boolean volunteerValidate(VolunteerDTO volunteerDTO) throws Exception {
        PersonService.cpfValidate(volunteerDTO.getCpf());
        PersonService.nameValidate(volunteerDTO.getName());
        PersonService.surnameValidate(volunteerDTO.getSurname());
        PersonService.ageValidate(volunteerDTO.getAge());
        PersonService.ganderValidate(volunteerDTO.getGander());
        PersonService.emailValidate(volunteerDTO.getEmail());
        PersonService.phoneValidate(volunteerDTO.getPhone());

        return true;
    }

    private Volunteer convertDtoToEntities(VolunteerDTO volunteerDTO) {
        Volunteer volunteer = new Volunteer();
        try {
            volunteer.setCpf(volunteerDTO.getCpf());
            volunteer.setName(volunteerDTO.getName());
            volunteer.setSurname(volunteerDTO.getSurname());
            volunteer.setAge(Integer.parseInt(volunteerDTO.getAge()));
            volunteer.setGander(Gander.valueOf(volunteerDTO.getGander()));
            volunteer.setEmail(volunteerDTO.getEmail());
            volunteer.setPhone(volunteerDTO.getPhone());
            volunteer.setDayOfWeek(DayOfWeek.valueOf(volunteerDTO.getDayOfWeek()));
            volunteer.setAvailabilityPeriod(AvailabilityPeriod.valueOf(volunteerDTO.getAvailabilityPeriod()));
            volunteer.setFrequency(Frequency.valueOf(volunteerDTO.getFrequency()));
            volunteer.setEducationLevel(EducationLevel.valueOf(volunteerDTO.getEducationLevel()));
            volunteer.setSpecificSkill(SpecificSkill.valueOf(volunteerDTO.getSpecificSkill()));
            volunteer.setVolunteerExperience(VolunteerExperience.valueOf(volunteerDTO.getVolunteerExperience()));
            volunteer.setInterestArea(InterestArea.valueOf(volunteerDTO.getInterestArea()));

            return volunteer;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void saveVolunteer(Volunteer volunteer) {
        VolunteerRepository volunteerRepository = new VolunteerRepository();

        volunteerRepository.insertVolunteer(volunteer);
    }
}
