package services;

import Repostry.Repointerface;
import model.Content;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Service
public class ContentService implements ContentInterface {

    Repointerface contentRepository;
    @Override
    public String upload(@RequestParam Long contentId, @RequestParam String pathType, @RequestParam MultipartFile file){
        Optional<Content> contentOptional = contentRepository.findById(contentId);

        if (contentOptional.isPresent()){
            return null;
        }
        if (file.isEmpty()){
            return null;
        }
        return pathType + file.getOriginalFilename();

    }
}
