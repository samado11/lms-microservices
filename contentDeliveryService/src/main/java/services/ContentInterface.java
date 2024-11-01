package services;

import org.springframework.web.multipart.MultipartFile;

public interface ContentInterface {

    public String upload(Long contentId, String pathType, MultipartFile file);
}
