package com.cg.projectmicroservice.service;

import com.cg.projectmicroservice.dto.ProjectDto;
import com.cg.projectmicroservice.entity.Project;

import java.util.List;

public interface ProjectService {

    ProjectDto saveProject(ProjectDto projectDto);

    ProjectDto getProjectById(Long projectId);

    List<ProjectDto> getAllProjects();

    ProjectDto updateProject(Long projectId , ProjectDto projectDto);

    void deleteProject(Long projectId);


}
