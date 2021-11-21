package interviewProject.controllers;

import interviewProject.exceptions.ConvertToTimestapException;
import interviewProject.model.ServerStatisticData;
import interviewProject.model.enums.UserStatus;
import interviewProject.services.ServerStatisticService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/statistic")
public class ServerStatisticController {
    private final ServerStatisticService serverStatisticService;
    private Map<Timestamp, List<ServerStatisticData>> timestampListMap = new HashMap<>();

    //http://localhost:8080/statistic/users-by-status/OFFLINE?timestampStr=2021-11-21 23:10:26.249
    @GetMapping("/users-by-status/{userStatus}")
    public ResponseEntity<Map> findAllUsersByUserStatus(@PathVariable("userStatus") UserStatus userStatus, @RequestParam(required = false) String timestampStr) {
        Timestamp newTimestamp = new Timestamp(System.currentTimeMillis());
        System.out.println();
        if (timestampStr == null) {
            timestampListMap.put(newTimestamp, serverStatisticService.findAllUsersByUserStatus(userStatus));
            return ResponseEntity.ok(Map.of(newTimestamp, timestampListMap.get(newTimestamp)));
        } else {
            try {

                return ResponseEntity.ok(Map.of(newTimestamp, serverStatisticService.findChangedStatus(timestampListMap.get(Timestamp.valueOf(timestampStr)))));
            } catch (ConvertToTimestapException e) {
                throw new ConvertToTimestapException();
            }
        }
    }
}
