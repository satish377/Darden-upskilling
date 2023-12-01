package com.cg.projectmicroservice.controller;

import com.cg.projectmicroservice.dto.ProjectDto;
import com.cg.projectmicroservice.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("api/projects")
@AllArgsConstructor
@Tag(
        name = "Project_Controller",
        description = "Project_controller Exposes REST API"
)
public class ProjectController {
    private ProjectService projectService;

    @Operation(
            summary = "Create Project REST API",
            description = "Create Project REST API is used to save project in a database"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status 201 CREATED"
    )
    // build create User REST API
    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto project) {
        ProjectDto savedProject = projectService.saveProject(project);
        return new ResponseEntity<>(savedProject, HttpStatus.CREATED);
    }


    @Operation(
            summary = "Get Project REST API",
            description = "Get is used to get Project"
    )
    @ApiResponse(
            responseCode = "20",
            description = "OK"
    )
// Build Get project by Code REST API
    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProjectById(@PathVariable Long projectId){
        ProjectDto projectDto = projectService.getProjectById(projectId);
        return new ResponseEntity<>(projectDto, HttpStatus.OK);
    }


    @Operation(
            summary = "Get all Projects REST API",
            description = "Get is used to get all Projects"
    )
    @ApiResponse(
            responseCode = "20",
            description = "OK"
    )
    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects() {
        List<ProjectDto> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @Operation(
            summary = "Update Project REST API",
            description = "Update Project REST API is used to update a particular project in the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Update Project REST API
    @PutMapping("/{projectId}")
    public ResponseEntity<ProjectDto> updateProject(@PathVariable Long projectId, @RequestBody ProjectDto projectDto) {
        ProjectDto updatedProject = projectService.updateProject(projectId, projectDto);
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }
    @Operation(
            summary = "Delete Project REST API",
            description = "Delete Project REST API is used to delete a particular project from the database"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 SUCCESS"
    )
    // Build Delete Project REST API
    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Long projectId) {
        projectService.deleteProject(projectId);
        return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
    }

}
