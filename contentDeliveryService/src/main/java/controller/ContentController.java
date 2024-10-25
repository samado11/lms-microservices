package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import services.ContentService;

@RestController
@RequestMapping ( "/file")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam Long id, @RequestParam String PathType, @RequestParam("file") MultipartFile file) {

        return contentService.uploadFile(id, PathType, file);
    }

}
