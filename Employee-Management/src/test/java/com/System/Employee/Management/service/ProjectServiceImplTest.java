package com.System.Employee.Management.service;

import com.System.Employee.Management.entity.Project;
import com.System.Employee.Management.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ProjectServiceImplTest {
    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectServiceImpl projectService;

    private Project project1;
    private Project project2;

    @BeforeEach
    void setUp() {
        project1 = new Project();
        project1.setId(1L);
        project1.setProjectName("Project Alpha");

        project2 = new Project();
        project2.setId(2L);
        project2.setProjectName("Project Beta");
    }

    @Test
    void testCreateProject() {
        when(projectRepository.save(any(Project.class))).thenReturn(project1);

        Project createdProject = projectService.createProject(project1);

        assertNotNull(createdProject);
        assertEquals("Project Alpha", createdProject.getProjectName());
        verify(projectRepository, times(1)).save(any(Project.class));
    }

    @Test
    void testGetProjectById() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project1));

        Project foundProject = projectService.getProjectById(1L);

        assertNotNull(foundProject);
        assertEquals(1L, foundProject.getId());
        verify(projectRepository, times(1)).findById(1L);
    }

    @Test
    void testGetProjectById_NotFound() {
        when(projectRepository.findById(99L)).thenReturn(Optional.empty());

        Exception exception = assertThrows(RuntimeException.class, () -> projectService.getProjectById(99L));

        assertEquals("Project not found", exception.getMessage());
        verify(projectRepository, times(1)).findById(99L);
    }

    @Test
    void testGetAllProjects() {
        List<Project> projects = Arrays.asList(project1, project2);
        when(projectRepository.findAll()).thenReturn(projects);

        List<Project> result = projectService.getAllProjects();

        assertEquals(2, result.size());
        verify(projectRepository, times(1)).findAll();
    }

    @Test
    void testUpdateProject() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project1));
        when(projectRepository.save(any(Project.class))).thenReturn(project1);

        Project updatedProject = new Project();
        updatedProject.setProjectName("Updated Alpha");

        Project result = projectService.updateProject(1L, updatedProject);

        assertNotNull(result);
        assertEquals("Updated Alpha", result.getProjectName());
        verify(projectRepository, times(1)).save(any(Project.class));
    }

    @Test
    void testDeleteProject() {
        when(projectRepository.findById(1L)).thenReturn(Optional.of(project1));
        doNothing().when(projectRepository).deleteById(1L);

        projectService.deleteProject(1L);

        verify(projectRepository, times(1)).deleteById(1L);
    }
}