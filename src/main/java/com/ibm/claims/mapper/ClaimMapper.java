package com.ibm.claims.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

@Mapper(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL, componentModel = "spring")
public abstract class ClaimMapper {
/*
	public OverAllCourseProgress createCourseProgress(ProgressRequest progressRequest) {

		List<CourseContentstatus> courseContentStatusList = getCourseContentStatusList(progressRequest);
		CourseProgress courseProgress = getCourseProgress(progressRequest, courseContentStatusList);
		List<CourseProgress> courseProgressList = new ArrayList<>();
		courseProgressList.add(courseProgress);
		return mapCourseProgress(progressRequest, courseProgressList);
	}

	private List<CourseContentstatus> getCourseContentStatusList(ProgressRequest progressRequest) {

		ArrayList<CourseContentstatus> courseContentStatusList = new ArrayList<>();
		CourseContentstatus contentStatus = mapCourseContentstatus(progressRequest);
		courseContentStatusList.add(contentStatus);
		return courseContentStatusList;
	}

	@Mapping(source = "progressRequest.coursecontentId", target = "contentId")
	@Mapping(constant = "", target = "contentTitle")
	@Mapping(source = "progressRequest.status", target = "status")
	@Mapping(source = "progressRequest.completionDate", target = "date")
	public abstract CourseContentstatus mapCourseContentstatus(ProgressRequest progressRequest);

	@Mapping(source = "progressRequest.userId", target = "userId")
	@Mapping(source = "progressRequest.courseId", target = "courseId")
	@Mapping(constant = "courseProgress", target = "entityType")
	@Mapping(constant = "0", target = "rank")
	@Mapping(source = "progressRequest.overAllStatus", target = "overAllStatus")
	@Mapping(source = "courseProgressList", target = "courseProgress")
	
	abstract OverAllCourseProgress mapCourseProgress(ProgressRequest progressRequest,
			List<CourseProgress> courseProgressList);

	@Mapping(source = "progressRequest.coursemoduleId", target = "courseModuleId")
	@Mapping(source = "courseContentStatus", target = "courseContentStatus")
	@Mapping(source = "progressRequest.quizAnswerCount", target = "quizAnswerCount")
	abstract CourseProgress getCourseProgress(ProgressRequest progressRequest,
			List<CourseContentstatus> courseContentStatus);

	public StatusAndRank getStatusAndRank(ProgressRequest progressRequest) {
		List<Userstatus> userStatus = new ArrayList<>();
		Userstatus us = mapUserStatus(progressRequest);
		userStatus.add(us);
		return mapStatusAndRank(progressRequest, userStatus);
	}

	@Mapping(source = "progressRequest.userId", target = "userId")
	@Mapping(source = "progressRequest.overAllStatus", target = "overAllStatus")
	@Mapping(constant = "1", target = "rank")
	public abstract Userstatus mapUserStatus(ProgressRequest progressRequest);

	@Mapping(source = "progressRequest.courseId", target = "courseId")
	@Mapping(constant = "StatusAndRank", target = "entityType")
	@Mapping(source = "userStatus", target = "userStatus")
	abstract StatusAndRank mapStatusAndRank(ProgressRequest progressRequest, List<Userstatus> userStatus);
*/
}
