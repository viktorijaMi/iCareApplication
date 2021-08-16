package mk.ukim.finki.icareapp.service.impl;

import mk.ukim.finki.icareapp.model.Activity_diary;
import mk.ukim.finki.icareapp.model.DiaryRecord;
import mk.ukim.finki.icareapp.model.Feelings_diary;
import mk.ukim.finki.icareapp.model.User;
import mk.ukim.finki.icareapp.repository.DiaryRecordJpaRepository;
import mk.ukim.finki.icareapp.service.DiaryRecordService;
import mk.ukim.finki.icareapp.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiaryRecordServiceImpl implements DiaryRecordService {

    private final DiaryRecordJpaRepository diaryRecordJpaRepository;
    private final UserService userService;

    public DiaryRecordServiceImpl(DiaryRecordJpaRepository diaryRecordJpaRepository, UserService userService) {
        this.diaryRecordJpaRepository = diaryRecordJpaRepository;
        this.userService = userService;
    }

    @Override
    public DiaryRecord saveRecord(String date, String feeling, String activity, String day_description, int water, int meals, int fresh_air, String meditation, String vitamins, String yoga, String good_sleep, String username) {
        User user = this.userService.findByUsername(username);
       return this.diaryRecordJpaRepository
               .save(
                       new DiaryRecord(user, LocalDate.now(), Feelings_diary.valueOf(feeling), Activity_diary.valueOf(activity), day_description, water, meals, fresh_air, vitamins.equals("Да"), meditation.equals("Да"), yoga.equals("Да"), good_sleep.equals("Да")));
    }

    @Override
    public List<DiaryRecord> findAllById(String username) {
        List<DiaryRecord> allDiaryRecords = this.diaryRecordJpaRepository.findAll()
                .stream()
                .filter(d -> d.getUser().getUsername().equals(username))
                .collect(Collectors.toList());
        return allDiaryRecords;
    }
}
