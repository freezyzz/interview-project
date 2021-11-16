package interviewProject.controllers;

import interviewProject.services.DownloadImagesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("images")
@RequiredArgsConstructor
public class ImageController {
    private final DownloadImagesService downloadImageService;

    @PostMapping("/add")
    public ResponseEntity<String> saveImage(@RequestBody String url) {
        return ResponseEntity.ok(downloadImageService.saveImage(url));
    }


}
