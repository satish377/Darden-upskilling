package com.cg.projectmicroservice.repository;

import com.cg.projectmicroservice.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    Project findByProjectId(Long projectId);

}
