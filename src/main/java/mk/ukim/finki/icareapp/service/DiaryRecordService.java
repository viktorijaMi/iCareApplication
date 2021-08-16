package mk.ukim.finki.icareapp.service;

import mk.ukim.finki.icareapp.model.DiaryRecord;
import mk.ukim.finki.icareapp.model.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DiaryRecordService {
    DiaryRecord saveRecord(String date,
                           String feeling,
                           String activity,
                           String day_description,
                           int water,
                           int meals,
                           int fresh_air,
                           String meditation,
                           String vitamins,
                           String yoga,
                           String good_sleep,
                           String username);

    List<DiaryRecord> findAllById(String username);
}
