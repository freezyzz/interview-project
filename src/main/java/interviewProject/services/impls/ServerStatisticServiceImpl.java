package interviewProject.services.impls;

import interviewProject.dao.UserRepository;
import interviewProject.exceptions.UserNotFoundException;
import interviewProject.model.ServerStatisticData;
import interviewProject.model.entities.User;
import interviewProject.model.enums.UserStatus;
import interviewProject.services.ServerStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ServerStatisticServiceImpl implements ServerStatisticService {
    private final UserRepository userRepository;

    @Override
    public List<ServerStatisticData> findAllUsersByUserStatus(UserStatus userStatus) {
        List<User> users = userRepository.findAllByUserStatus(userStatus).orElseThrow(UserNotFoundException::new);
        List<ServerStatisticData> serverStatisticData = new ArrayList<>();
        for (User user : users) {
            serverStatisticData.add(new ServerStatisticData(user.getId(), user.getImageURI(), user.getUserStatus()));
        }
        return serverStatisticData;
    }

    @Override
    public List<ServerStatisticData> findChangedStatus(List<ServerStatisticData> serverStatisticData) {
        List<ServerStatisticData> usersChangedStatus = new ArrayList<>();

        for (ServerStatisticData serverStatisticElement : serverStatisticData) {
            User user = userRepository.findById(serverStatisticElement.getId()).orElseThrow(UserNotFoundException::new);

            if (!serverStatisticElement.getUserStatus().equals(user.getUserStatus())) {
                usersChangedStatus.add(new ServerStatisticData(user.getId(), user.getImageURI(), user.getUserStatus()));
            }
            user = null;
        }
        return usersChangedStatus;
    }


}
