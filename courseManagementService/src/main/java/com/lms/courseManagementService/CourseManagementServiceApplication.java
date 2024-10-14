package com.lms.courseManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class CourseManagementServiceApplication {

	@Autowired
	private Leo_Repo repo;

		@GetMapping("/{id}")
		public lesson getlessons(@PathVariable("id") long id) {
			return repo.findById(id).orElse(null);
		}

		@PostMapping("/lessons")
		public lesson createlessons(@RequestBody lesson lesson) {
			return repo.save(lesson);
		}

		@PutMapping("/{lessonid}")
		public lesson updatelessons(@PathVariable("lessonid") long lessonId, @RequestBody lesson lesson) {
		if (!repo.existsById(lessonId)) {
			throw new ResourceNotFoundException("Lesson not found with id: " + lessonId);
		}
		lesson.setId(lessonId);
		return repo.save(lesson);
		}

		@DeleteMapping("/{id}")
		public void delete_lessons(@PathVariable("id") long id) {
			repo.deleteById(id);
		}

	}






