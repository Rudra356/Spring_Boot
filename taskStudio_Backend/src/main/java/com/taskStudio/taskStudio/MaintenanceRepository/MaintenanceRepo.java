package com.taskStudio.taskStudio.MaintenanceRepository;


import com.taskStudio.taskStudio.MaintenanceEntity.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepo extends JpaRepository<MaintenanceEntity, Long > {

MaintenanceEntity findByUpcomingCheckUpKM(Long upcomingCheckUpKM);

}
