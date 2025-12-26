package com.example.demo.handler;

import com.example.demo.dto.FileDTO;
import com.example.demo.repository.FileRepository;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@EnableScheduling
@RequiredArgsConstructor
@Component
public class FileSweeper {
    // 매일 정해진 시간에 스케줄러 실행
    // 매일 해당날짜의 경로에 폴더 경로에 파일(DB)과 폴더안의 파일이 일치하는지 비교
    // DB == 폴더의 파일이 일치하는지 확인
    // 일치하는 파일(DB == file)만 남기고,
    // 일치하지 않는 파일(DB != file)은 삭제 (폴더에서 삭제)

    private final BoardService boardService;
    private final String BASE_PATH = "/home/zxcvne/web_0826_nhs/_myProject/_java/_fileUpload/";

    // cron 방식 = 초 분 시 일 월 요일 년도(생략가능)
    @Scheduled(cron = "30 1 17 * * *")
    public void fileSweeper() {
        log.info(">>> fileSweeper Start >> {}", LocalDateTime.now());

        // DB에 등록된 파일 리스트 가져오기
        // save_dir 정보필요.
        LocalDate now = LocalDate.now();
        String today = now.toString().replace("-", File.separator);

        // select * from file where save_dir = today
        List<FileDTO> dbFileList = boardService.getTodayFileList(today);
        log.info(">>> dbFileList >> {}", dbFileList);

        log.info(">>> fileSweeper End >> {}", LocalDateTime.now());
    }
}
