package com.cg.projectmicroservice.service.impl;

import com.cg.projectmicroservice.dto.ProjectDto;
import com.cg.projectmicroservice.entity.Project;
import com.cg.projectmicroservice.mapper.AutoProjectMapper;
import com.cg.projectmicroservice.repository.ProjectRepository;
import com.cg.projectmicroservice.service.ProjectService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private ProjectRepository projectRepository;


    @Override
    public ProjectDto saveProject(ProjectDto projectDto) {
        Project project = AutoProjectMapper.MAPPER.mapToProject(projectDto);
        Project savedProject = projectRepository.save(project);
        ProjectDto savedProjectDto = AutoProjectMapper.MAPPER.mapToProjectDto(savedProject);
        return savedProjectDto;
    }

    @Override
    public ProjectDto getProjectById(Long projectId) {
        Project project = projectRepository.findByProjectId(projectId);
        return AutoProjectMapper.MAPPER.mapToProjectDto(project);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        List<Project> projects = projectRepository.findAll();
        return projects.stream().map((project) -> AutoProjectMapper.MAPPER.mapToProjectDto(project))
                .collect(Collectors.toList());
    }

    @Override
    public ProjectDto updateProject(Long projectId, ProjectDto projectDto) {
        Optional<Project> optionalProject = projectRepository.findById(projectId);

        if (optionalProject.isPresent()) {
            Project existingProject = optionalProject.get();
            // Update the fields as needed
            existingProject.setProjectName(projectDto.getProjectName());
            existingProject.setStartDate(projectDto.getStartDate());
            existingProject.setEndDate(projectDto.getEndDate());
            existingProject.setAssignedMentor(projectDto.getAssignedMentor());
            existingProject.setTotalHours(projectDto.getTotalHours());

            Project updatedProject = projectRepository.save(existingProject);
            return  AutoProjectMapper.MAPPER.mapToProjectDto(updatedProject);
        }
        else {
            throw new EntityNotFoundException("Project with ID " + projectId + " not found");
        }

    }

    @Override
    public void deleteProject(Long projectId) {
        if (projectRepository.existsById(projectId)) {
            projectRepository.deleteById(projectId);
        } else {
            throw new EntityNotFoundException("Project with ID " + projectId + " not found");
        }
    }

}
