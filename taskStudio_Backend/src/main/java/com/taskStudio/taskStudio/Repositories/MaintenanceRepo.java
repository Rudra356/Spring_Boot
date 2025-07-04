package com.taskStudio.taskStudio.Repositories;


import com.taskStudio.taskStudio.Entities.MaintenanceEntity;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaintenanceRepo extends MongoRepository<MaintenanceEntity, String > {
//
//MaintenanceEntity findByUpcomingCheckUpKM(Long upcomingCheckUpKM);
//
}
