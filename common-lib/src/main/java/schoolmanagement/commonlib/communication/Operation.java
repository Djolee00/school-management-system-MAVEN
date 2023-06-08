package schoolmanagement.commonlib.communication;

import java.io.Serializable;

/**
 * Enumeration of operations supported by the system.
 *
 * <p>
 * This enumeration represents various operations that can be performed within
 * the system.
 * </p>
 *
 * @see Serializable
 * @author Djordje Ivanovic
 */
public enum Operation implements Serializable {

	/**
	 * Operation for performing login.
	 */
	LOGIN,

	/**
	 * Operation for retrieving courses for a student.
	 */
	GET_STUDENT_COURSES,

	/**
	 * Operation for retrieving unselected courses for a student.
	 */
	GET_STUDENT_UNSELECTED_COURSES,

	/**
	 * Operation for enrolling a student in courses.
	 */
	ENROLL_STUDENT_IN_COURSES,

	/**
	 * Operation for retrieving all students.
	 */
	GET_ALL_STUDENTS,

	/**
	 * Operation for retrieving all courses.
	 */
	GET_ALL_COURSES,

	/**
	 * Operation for retrieving all languages.
	 */
	GET_ALL_LANGUAGES,

	/**
	 * Operation for updating student's personal information.
	 */
	UPDATE_STUDENT_PERSONAL_INFO,

	/**
	 * Operation for adding a new student.
	 */
	ADD_NEW_STUDENT,

	/**
	 * Operation for updating a course.
	 */
	UPDATE_COURSE,

	/**
	 * Operation for deleting a course.
	 */
	DELETE_COURSE,

	/**
	 * Operation for adding a new course.
	 */
	ADD_COURSE,

	/**
	 * Operation for retrieving course groups.
	 */
	GET_COURSE_GROUPS,

	/**
	 * Operation for retrieving language tutors.
	 */
	GET_LANGUAGE_TUTORS,

	/**
	 * Operation for retrieving students in a course.
	 */
	GET_COURSE_STUDENTS,

	/**
	 * Operation for adding a course group.
	 */
	ADD_COURSE_GROUP,

	/**
	 * Operation for updating a course group.
	 */
	UPDATE_COURSE_GROUP,

	/**
	 * Operation for logging out.
	 */
	LOG_OUT
}
