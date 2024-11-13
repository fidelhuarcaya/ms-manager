package org.copper.manager.dto.response;

public record CourseResponse(
    Long id,
    String name,
    String description,
    String banner
) {
}
