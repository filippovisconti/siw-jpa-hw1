package it.uniroma3.siw.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	private Date startDate;
	
	@Column(nullable = false)
	private Integer courseLengthInMonths;
	
	@ManyToOne
	@Column(nullable = false)
	private Teacher lecturer;
	
	@ManyToMany(mappedBy="attendedCourses")
	@Column(nullable = false)
	private List<Student> attendingStudents;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Integer getCourseLengthInMonths() {
		return courseLengthInMonths;
	}

	public void setCourseLengthInMonths(Integer courseLengthInMonths) {
		this.courseLengthInMonths = courseLengthInMonths;
	}

	public Teacher getLecturer() {
		return lecturer;
	}

	public void setLecturer(Teacher lecturer) {
		this.lecturer = lecturer;
	}

	public List<Student> getAttendingStudents() {
		return attendingStudents;
	}

	public void setAttendingStudents(List<Student> attendingStudents) {
		this.attendingStudents = attendingStudents;
	}

}
