package sgsits.cse.dis.academics.constants;

public class RestAPI {

	public static final String GET_SEM_TIME_TABLE_SETTINGS = "/getSemTimeTableSettings";
	public static final String SAVE_SEM_TIME_TABLE_SETTINGS = "/saveSemTimeTableSettings";
	public static final String GET_FACULTY_NAME_LIST = "/getFacultyNameList";
	public static final String GET_COURSE_NAME_BY_COURSE_ID = "getCourseNameByCourseId/{courseId}";
	public static final String GET_COURSE_ID_BY_COURSE_NAME = "getCourseIdByCourseName/{courseName}";
	public static final String GET_COURSE_LIST = "/getCourseList";
	public static final String GET_SUBJECT_CODES_LIST_BY_YEAR_AND_SEMESTER = "getSubjectCodesListByYearAndSemsterAndCourse/{year}/{sem}/{course}";
	public static final String GET_INFRASTRUCTURE_BY_TYPE = "/getInfrastructureByType/{type}";
	public static final String ADD_SEMESTER_TIME_TABLE = "/addSemTimeTable";
	public static final String GET_SUBJECT_CODES_BY_FACULTY_ID_AND_SESSION = "/getSubjectCodesByFacultyIdAndSession/{facultyId}/{session}";
	public static final String GET_TIMETABLE_BY_FACULTY_ID_SESSION_AND_SUBJECT_CODE = "/getTimeTableByFacultyIdSessionAndSubjectCode/{facultyId}/{session}/{subjectCode}";
	public static final String ADD_EXPERT = "/addExpert";
	public static final String ADD_EXPERT_LECTURE = "/addExpertLecture";
	public static final String GET_EXPERT_LECTURES_BY_STATUS = "/getExpertLecturesByStatus/{status}";
	public static final String VIEW_EXPERT_LECTURE_DETAILS = "/viewExpertLectureDetails/{expertLectureId}";
	public static final String EDIT_EXPERT_LECTURE = "/editExpertLecture/{expertLectureId}";
	public static final String DELETE_EXPERT_LECTURE = "/deleteExpertLecture/{expertLectureId}";
	public static final String GET_EXPERT_NAMES_AND_DESIGNATIONS = "/getExpertNamesAndDesignations";
	public static final String GET_ALL_EXPERTS = "/getAllExperts";
	public static final String GET_ALL_EXPERT_LECTURES = "/getAllExpertLectures";
	public static final String EDIT_EXPERT = "/editExpert";
	public static final String FIND_EXPERT = "/findExpert";
	public static final String SEARCH_EXPERT_LECTURES = "/searchExpertLectures";
	public static final String UPDATE_EXPERT_LECTURE_STATUS = "/updateExpertLectureStatus/{expertLectureId}";
	public static final String DELETE_EXPERT = "/deleteExpert/{expertId}";
	public static final String FETCH_ME_STUDENTS_WITHOUT_SCHOLARSHIP = "/fetchMEStudentsWithoutScholarship/{year}";
	public static final String APPROVE_STUDENTS_FOR_SCHOLARSHIP = "/approveScholarship";
	public static final String FETCH_ME_STUDENTS_WITH_SCHOLARSHIP = "/fetchMEStudentsWithScholarship/{year}";
	public static final String CANCEL_SCHOLARSHIP = "/cancelScholarship";
	public static final String ADD_INDUSTRY_VISIT = "/addIndustryVisit";
	public static final String GET_INDUSTRY_VISITS = "/getIndustryVisits/{status}";
	public static final String VIEW_INDUSTRY_VISIT_DETAILS = "/viewIndustryVisitDetails/{industryVisitId}";
	public static final String SEARCH_INDUSTRY_VISITS = "/searchIndustryVisits";
	public static final String UPDATE_INDUSTRY_VISIT_STATUS = "/updateIndustryVisitStatus/{industryVisitId}";
	public static final String EDIT_INDUSTRY_VISIT = "/editIndustryVisit/{industryVisitId}";
	public static final String DELETE_INDUSTRY_VISIT = "/deleteIndustryVisit/{industryVisitId}";
    public static final String SEARCH_STUDENTS_WITHOUT_SCHOLARSHIP = "/searchStudentsWithoutScholarship";
	public static final String SEARCH_STUDENTS_WITH_SCHOLARSHIP = "/searchStudentsWithScholarship";
	public static final String UPDATE_PAYMENT_STATUS_AND_REMARKS = "/updatePaymentStatusAndRemarks/{expertLectureId}";
	public static final String UPDATE_REMARKS = "/updateRemarks/{industryVisitId}";
    public static final String UPLOAD_IMAGES = "/uploadImages/{id}";
	public static final String IMAGES = "/images";
	public static final String UPLOAD = "/upload";
	public static final String DOWNLOAD = "/download";
	public static final String GET_ALL_MEMBER = "/getAllMember";
	public static final String GET_ALL_MAGAZINE = "/getAllMagazine";
	public static final String ADD_MEMBER = "/addMember";
	public static final String ADD_MAGAZINE = "/addMagazine";
	public static final String GET_MAGAZINE_BY_STATUS = "/getMagazineByStatus/{status}";
	public static final String VIEW_MAGAZINE_DETAILS = "/viewMagazineDetails/{magazineId}";
	public static final String EDIT_MAGAZINE = "/editMagazine/{magazineId}";
	public static final String DELETE_MAGAZINE = "/deleteMagazine/{magazineId}";
	public static final String GET_MEMBER = "/getMembers";
	public static final String EDIT_MEMBER = "/editMember";
	public static final String FIND_MEMBER = "/findMember";
	public static final String SEARCH_MAGAZINE = "/searchMagazine";
	public static final String UPDATE_MAGAZINE_STATUS = "/updateMagazineStatus/{magazineId}/{newStatus}";
	public static final String DELETE_MEMBER = "/deleteMember/{memberId}";
}
