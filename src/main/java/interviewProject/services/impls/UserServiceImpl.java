package interviewProject.services.impls;

import interviewProject.dao.UserRepository;
import interviewProject.exceptions.UserNotFoundException;
import interviewProject.model.UserStatusData;
import interviewProject.model.entities.User;
import interviewProject.model.enums.UserStatus;
import interviewProject.services.DownloadImagesService;
import interviewProject.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final DownloadImagesService downloadImagesService;

    @Override
    public Long createUser(User user) {
        user.setImageURI(downloadImagesService.saveImage(user.getImageURI()));
        userRepository.save(user);
        return user.getId();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public UserStatusData updateStatus(Long id, UserStatus newStatus) {
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException("Ожидайте");
        }
        User user = userRepository.findById(id).orElseThrow(UserNotFoundException::new);
        UserStatus oldStatus = user.getUserStatus();
        user.setUserStatus(newStatus);
        userRepository.save(user);
        return new UserStatusData(user.getId(), oldStatus, newStatus);
    }
}
