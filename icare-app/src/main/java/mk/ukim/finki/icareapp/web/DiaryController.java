package mk.ukim.finki.icareapp.web;

import mk.ukim.finki.icareapp.model.Activity_diary;
import mk.ukim.finki.icareapp.model.DiaryRecord;
import mk.ukim.finki.icareapp.model.Feelings_diary;
import mk.ukim.finki.icareapp.model.User;
import mk.ukim.finki.icareapp.service.DiaryRecordService;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/mental-health-diary")
public class DiaryController {

    private final DiaryRecordService diaryRecordService;

    public DiaryController(DiaryRecordService diaryRecordService) {
        this.diaryRecordService = diaryRecordService;
    }

    @GetMapping
    public String getDiaryPage(HttpServletRequest request,
                               Model model){
        User user = (User) request.getSession().getAttribute("user");
        List<Feelings_diary> feelings_diary = Arrays.asList(Feelings_diary.values());
        List<Activity_diary> activity_diary = Arrays.asList(Activity_diary.values());
        List<DiaryRecord> diaryRecordList = this.diaryRecordService.findAllById(user.getUsername());

        model.addAttribute("diaryRecordList", diaryRecordList);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("feelings", feelings_diary);
        model.addAttribute("activities", activity_diary);
        model.addAttribute("bodyContent", "diary");

        return "master-template";
    }

    @GetMapping("/add-record")
    public String getAddRecordPage(Model model,
                                   HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        List<Feelings_diary> feelings_diary = Arrays.asList(Feelings_diary.values());
        List<Activity_diary> activity_diary = Arrays.asList(Activity_diary.values());
        String todaydate = formatter.format(date).toString();
        model.addAttribute("feelings", feelings_diary);
        model.addAttribute("activities", activity_diary);
        model.addAttribute("today-date", todaydate);
        model.addAttribute("username", user.getUsername());
        model.addAttribute("bodyContent", "add-diary-record");

        return "master-template";
    }

    @PostMapping("/add-record")
    public String addDiaryRecord(@RequestParam String date,
                                 @RequestParam String feeling,
                                 @RequestParam String activity,
                                 @RequestParam String day_description,
                                 @RequestParam int water,
                                 @RequestParam int meals,
                                 @RequestParam int fresh_air,
                                 @RequestParam String meditation,
                                 @RequestParam String vitamins,
                                 @RequestParam String yoga,
                                 @RequestParam String good_sleep,
                                 HttpServletRequest request) {
        User user = (User) request.getSession().getAttribute("user");
        DiaryRecord diaryRecord = this.diaryRecordService.saveRecord(date, feeling, activity, day_description, water, meals, fresh_air, meditation, vitamins, yoga, good_sleep, user.getUsername());
        String day_desc = diaryRecord.getDay_description();
        return "redirect:/mental-health-diary";
    }
}
