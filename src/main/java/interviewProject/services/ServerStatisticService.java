package interviewProject.services;

import interviewProject.dao.UserRepository;
import interviewProject.model.ServerStatisticData;
import interviewProject.model.entities.User;
import interviewProject.model.enums.UserStatus;

import java.sql.Timestamp;
import java.util.List;

public interface ServerStatisticService {
    List<ServerStatisticData> findAllUsersByUserStatus(UserStatus userStatus);
    List<ServerStatisticData> findChangedStatus(List<ServerStatisticData> serverStatisticData);
}
