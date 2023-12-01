package com.cg.projectmicroservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        description = "Project_Dto Model info"
)
public class ProjectDto {
    private Long projectId;
    @Schema(
            description = "Project Name"
    )
    private String projectName;
    @Schema(
            description = "Project Start Date"
    )
    private LocalDate startDate;
    @Schema(
            description = "Project End Date"
    )
    private LocalDate endDate;
    @Schema(
            description = "Mentor Name"
    )
    private String assignedMentor;
    @Schema(
            description = "Total Duration"
    )
    private float totalHours;
}
