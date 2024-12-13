package com.taskStudio.taskStudio.Repositories;


import com.taskStudio.taskStudio.Entities.MaintenanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepo extends JpaRepository<MaintenanceEntity, Long > {

MaintenanceEntity findByUpcomingCheckUpKM(Long upcomingCheckUpKM);

}
