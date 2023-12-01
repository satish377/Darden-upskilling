package com.cg.projectmicroservice.mapper;

import com.cg.projectmicroservice.dto.ProjectDto;
import com.cg.projectmicroservice.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AutoProjectMapper {

    AutoProjectMapper MAPPER = Mappers.getMapper(AutoProjectMapper.class);

    ProjectDto mapToProjectDto(Project project);

    Project mapToProject(ProjectDto projectDto);
}
