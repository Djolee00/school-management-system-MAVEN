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
 * <p>
 * The available operations include:
 * </p>
 * <ul>
 * <li>{@link #LOGIN} - Operation for performing login.</li>
 * <li>{@link #GET_STUDENT_COURSES} - Operation for retrieving courses for a
 * student.</li>
 * <li>{@link #GET_STUDENT_UNSELECTED_COURSES} - Operation for retrieving
 * unselected courses for a student.</li>
 * <li>{@link #ENROLL_STUDENT_IN_COURSES} - Operation for enrolling a student in
 * courses.</li>
 * <li>{@link #GET_ALL_STUDENTS} - Operation for retrieving all students.</li>
 * <li>{@link #GET_ALL_COURSES} - Operation for retrieving all courses.</li>
 * <li>{@link #GET_ALL_LANGUAGES} - Operation for retrieving all languages.</li>
 * <li>{@link #UPDATE_STUDENT_PERSONAL_INFO} - Operation for updating student's
 * personal information.</li>
 * <li>{@link #ADD_NEW_STUDENT} - Operation for adding a new student.</li>
 * <li>{@link #UPDATE_COURSE} - Operation for updating a course.</li>
 * <li>{@link #DELETE_COURSE} - Operation for deleting a course.</li>
 * <li>{@link #ADD_COURSE} - Operation for adding a new course.</li>
 * <li>{@link #GET_COURSE_GROUPS} - Operation for retrieving course groups.</li>
 * <li>{@link #GET_LANGUAGE_TUTORS} - Operation for retrieving language
 * tutors.</li>
 * <li>{@link #GET_COURSE_STUDENTS} - Operation for retrieving students in a
 * course.</li>
 * <li>{@link #ADD_COURSE_GROUP} - Operation for adding a course group.</li>
 * <li>{@link #UPDATE_COURSE_GROUP} - Operation for updating a course
 * group.</li>
 * <li>{@link #LOG_OUT} - Operation for logging out.</li>
 * </ul>
 *
 * @see Serializable
 * @author Djordje Ivanovic
 */
public enum Operation implements Serializable {
	LOGIN, GET_STUDENT_COURSES, GET_STUDENT_UNSELECTED_COURSES, ENROLL_STUDENT_IN_COURSES, GET_ALL_STUDENTS,
	GET_ALL_COURSES, GET_ALL_LANGUAGES, UPDATE_STUDENT_PERSONAL_INFO, ADD_NEW_STUDENT, UPDATE_COURSE, DELETE_COURSE,
	ADD_COURSE, GET_COURSE_GROUPS, GET_LANGUAGE_TUTORS, GET_COURSE_STUDENTS, ADD_COURSE_GROUP, UPDATE_COURSE_GROUP,
	LOG_OUT
}
