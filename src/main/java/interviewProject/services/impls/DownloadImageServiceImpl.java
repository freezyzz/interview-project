package interviewProject.services.impls;

import interviewProject.exceptions.IncorrectURIException;
import interviewProject.exceptions.InputOutputException;
import interviewProject.services.DownloadImagesService;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

@Service
public class DownloadImageServiceImpl implements DownloadImagesService {

    @Override
    public String saveImage(String uriStr) {
        try {
            URI uri = new URI(uriStr);
            BufferedImage inputImage = ImageIO.read(uri.toURL());
            File outputImage = new File("src/main/resources/images/" + Paths.get(uri.getPath()).getFileName().toString());
            ImageIO.write(inputImage, "JPG", outputImage);
            return outputImage.getAbsolutePath();
        } catch (IOException e) {
            throw new InputOutputException();
        } catch (URISyntaxException e) {
            throw new IncorrectURIException();
        }
    }
}
