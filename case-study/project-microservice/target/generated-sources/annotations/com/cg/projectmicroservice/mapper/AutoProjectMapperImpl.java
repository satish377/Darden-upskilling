package com.cg.projectmicroservice.mapper;

import com.cg.projectmicroservice.dto.ProjectDto;
import com.cg.projectmicroservice.entity.Project;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-30T13:56:21+0530",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
public class AutoProjectMapperImpl implements AutoProjectMapper {

    @Override
    public ProjectDto mapToProjectDto(Project project) {
        if ( project == null ) {
            return null;
        }

        ProjectDto projectDto = new ProjectDto();

        projectDto.setProjectId( project.getProjectId() );
        projectDto.setProjectName( project.getProjectName() );
        projectDto.setStartDate( project.getStartDate() );
        projectDto.setEndDate( project.getEndDate() );
        projectDto.setAssignedMentor( project.getAssignedMentor() );
        projectDto.setTotalHours( project.getTotalHours() );

        return projectDto;
    }

    @Override
    public Project mapToProject(ProjectDto projectDto) {
        if ( projectDto == null ) {
            return null;
        }

        Project project = new Project();

        project.setProjectId( projectDto.getProjectId() );
        project.setProjectName( projectDto.getProjectName() );
        project.setStartDate( projectDto.getStartDate() );
        project.setEndDate( projectDto.getEndDate() );
        project.setAssignedMentor( projectDto.getAssignedMentor() );
        project.setTotalHours( projectDto.getTotalHours() );

        return project;
    }
}
