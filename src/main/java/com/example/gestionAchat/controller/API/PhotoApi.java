package com.example.gestionAchat.controller.API;
import static com.example.gestionAchat.util.constant.APP_ROOT;
import com.flickr4java.flickr.FlickrException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@CrossOrigin(origins = "*")
@RequestMapping(value = APP_ROOT + "/photo",consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
public interface PhotoApi {
    @PostMapping("/{photo}/{id}/{title}/{context}")
    Object savePhoto(String context, Integer id, @RequestPart MultipartFile photo, String title) throws IOException, FlickrException;
}
