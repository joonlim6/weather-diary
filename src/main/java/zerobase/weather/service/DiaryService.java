package zerobase.weather.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zerobase.weather.repository.DiaryRepository;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class DiaryService {
    private final DiaryRepository diaryRepository;

    @Value("{openweathermap.key}")
    private String apiKey;

    @Transactional
    public void createDiary(LocalDate date, String text) {
    }

    private String getWeatherString() {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=seoul&appid=" + apiKey;
        System.out.println(apiUrl);
        return "";
    }
}
