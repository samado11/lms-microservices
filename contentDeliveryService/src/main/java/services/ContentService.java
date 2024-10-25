package services;

import Repostry.ContentRepository;
import model.content;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.util.Optional;

@Service
public class ContentService {

     ContentRepository contentRepository;

    public String uploadFile(@RequestParam Long id, @RequestParam String PathType, @RequestParam("file") MultipartFile file){

        Optional<content> content = contentRepository.findById(id);

        if(!content.isPresent()){
            return "content Not Found";
        }
        if(file.isEmpty()){
            return "File is Empty";
        }
        return PathType;
    }
}
