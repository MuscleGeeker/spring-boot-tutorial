package me.musclegeeker.cloud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
public class FileUploadController {

    @PostMapping("/upload")
    public @ResponseBody
    String upload(@RequestParam("file") MultipartFile file) throws Exception {
        byte[] bytes = file.getBytes();
        File file2Save = new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes, file2Save);

        return file2Save.getAbsolutePath();
    }
}
