package sgsits.cse.dis.academics.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import sgsits.cse.dis.academics.constants.RestAPI;
import sgsits.cse.dis.academics.jwt.JwtResolver;
import sgsits.cse.dis.academics.model.MemberDetails;
import sgsits.cse.dis.academics.model.MagazineDetails;
import sgsits.cse.dis.academics.model.FileInfo;
import sgsits.cse.dis.academics.repo.MagazineRepository;
import sgsits.cse.dis.academics.request.AddMagazineForm;
import sgsits.cse.dis.academics.request.EditMagazineForm;
import sgsits.cse.dis.academics.request.MemberForm;
import sgsits.cse.dis.academics.response.MagazineResponse;
import sgsits.cse.dis.academics.response.MemberNamesAndDesignationsResponse;
import sgsits.cse.dis.academics.response.ResponseMessage;
import sgsits.cse.dis.academics.service.MagazineService;
import sgsits.cse.dis.academics.service.FileStorageService;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "/magazine")
@Api(value = "Magazine")
public class MagazineController {

	@Autowired
	private MagazineService magazineService;

	@Autowired
	private MagazineRepository magazineRepository;

	@Autowired
	private FileStorageService fileStorageService;

	private JwtResolver jwtResolver = new JwtResolver();

	@ApiOperation(value = "Add member", response = ResponseMessage.class, httpMethod = "POST", produces = "application/json")
	@PostMapping(path = RestAPI.ADD_MEMBER, produces = "application/json")
	public ResponseEntity<?> addMember(HttpServletRequest request, @RequestBody MemberForm addMemberForm)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(magazineService.addMember(addMemberForm)), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Find member", response = MemberDetails.class, httpMethod = "GET", produces = "Application/json")
	@GetMapping(path = RestAPI.FIND_MEMBER, produces = "Application/json")
	public ResponseEntity<?> findMember(HttpServletRequest request, @RequestParam(value = "memberId", required = true) String memberId)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<MemberDetails>(magazineService.findMember(memberId), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Edit member", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.EDIT_MEMBER, produces = "application/json")
	public ResponseEntity<?> editMember(HttpServletRequest request, @RequestBody MemberForm editMemberForm)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(magazineService.editMember(editMemberForm)), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value="Get Members", response = MemberNamesAndDesignationsResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_MEMBER, produces = "application/json")
	public ResponseEntity<?> getMemberNamesAndDesignations(HttpServletRequest request)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<List<MemberDetails>> (magazineService.getAllMember(), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value="Add Member Lecture", response=ResponseMessage.class, httpMethod="POST", produces="application/json")
	@PostMapping(path=RestAPI.ADD_MAGAZINE, produces="application/json")
	public ResponseEntity<?> addMagazine(HttpServletRequest request, @RequestBody AddMagazineForm addMagazineForm)
	{
		System.out.println("Add Magazine Form");
		System.out.println(addMagazineForm);
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(magazineService.addMagazine(addMagazineForm)), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value = "Edit Member Lecture", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PutMapping(path = RestAPI.EDIT_MAGAZINE, produces = "application/json")
	public ResponseEntity<?> editMagazine(HttpServletRequest request, @PathVariable("magazineId") String magazineId, @RequestBody EditMagazineForm editMagazineForm)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(magazineService.editMagazine(magazineId, editMagazineForm)), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);

	}

	@ApiOperation(value="Get Member Lectures by status", response=MagazineResponse.class, httpMethod="GET", produces="application/json")
	@GetMapping(path=RestAPI.GET_MAGAZINE_BY_STATUS, produces="application/json")
	public ResponseEntity<?> getMagazineByStatus(HttpServletRequest request, @PathVariable("status") String status)
	{
		return new ResponseEntity<List<MagazineResponse>> (magazineService.getMagazineByStatus(status), HttpStatus.OK);
	}

	@ApiOperation(value="View Member Lecture Details", response=MagazineDetails.class, httpMethod = "GET", produces="application/json")
	@GetMapping(path=RestAPI.VIEW_MAGAZINE_DETAILS, produces="application/json")
	public ResponseEntity<?> viewMagazineDetails(HttpServletRequest request, @PathVariable("magazineId") String magazineId)
	{
		return new ResponseEntity<MagazineDetails>(magazineService.viewMagazineDetails(magazineId), HttpStatus.OK);
	}

	@ApiOperation(value = "Search member lectures", response = MagazineResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.SEARCH_MAGAZINE, produces = "application/json")
	public ResponseEntity<?> searchMagazine(HttpServletRequest request, @RequestParam(value = "keyword", required = true) String keyword, @RequestParam(value = "status", required = true) String status)
	{
		return new ResponseEntity<List<MagazineResponse>>(magazineService.searchMagazine(keyword, status), HttpStatus.OK);
	}

	@ApiOperation(value = "Get all member lectures", response = MagazineResponse.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ALL_MAGAZINE, produces = "application/json")
	public ResponseEntity<?> getAllMagazine(HttpServletRequest request){
		return new ResponseEntity<List<MagazineDetails>>(magazineService.getAllMagazine(), HttpStatus.OK);
	}

	@ApiOperation(value = "Get all members", response = MemberDetails.class, httpMethod = "GET", produces = "application/json")
	@GetMapping(path=RestAPI.GET_ALL_MEMBER, produces = "application/json")
	public ResponseEntity<?> getAllMembers(HttpServletRequest request){
		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
			return new ResponseEntity<List<MemberDetails>>(magazineService.getAllMember(), HttpStatus.OK);
		else
			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
	}


	@ApiOperation(value = "Update member lecture status", response = ResponseMessage.class, httpMethod = "PUT", produces = "application/json")
	@PostMapping(path = RestAPI.UPDATE_MAGAZINE_STATUS, produces = "application/json")
	public ResponseEntity<?> updateMagazineStatus(HttpServletRequest request, @PathVariable("magazineId") String magazineId, @PathVariable("newStatus") String newStatus)
	{
		System.out.println(magazineId+" "+newStatus);
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		{
			try
			{
				return new ResponseEntity<ResponseMessage>(new ResponseMessage(magazineService.updateMagazineStatus(magazineId, newStatus)), HttpStatus.OK);
			}
			catch(Exception e)
			{
				return new ResponseEntity<ResponseMessage>(new ResponseMessage("Could not upload file; file invalid or size too large. Please try again."), HttpStatus.EXPECTATION_FAILED);
			}
		}
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Delete Member", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_MEMBER, produces = "application/json")
	public ResponseEntity<?> deleteMember(HttpServletRequest request, @PathVariable("memberId") String memberId)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(magazineService.deleteMember(memberId)), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
	}

	@ApiOperation(value = "Delete member lecture", response = ResponseMessage.class, httpMethod = "DELETE", produces = "application/json")
	@DeleteMapping(path = RestAPI.DELETE_MAGAZINE, produces = "application/json")
	public ResponseEntity<?> deleteMagazine(HttpServletRequest request, @PathVariable("magazineId") String magazineId)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		return new ResponseEntity<ResponseMessage>(new ResponseMessage(magazineService.deleteMagazine(magazineId)), HttpStatus.OK);
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);
	}


	@PostMapping(path = RestAPI.UPLOAD_IMAGES)
	public ResponseEntity<?> uploadImages(HttpServletRequest request,
										  @PathVariable("id") String magazineId,
										  @RequestParam("photos") MultipartFile[] photos)
	{
//		if (!jwtResolver.getUserTypeFromJwtToken(request.getHeader("Authorization")).equals("student"))
		{
			String message = "";
			int size = photos.length;
			try {

				Arrays.asList(photos).stream().forEach(photo -> {
					fileStorageService.saveMagazine(magazineId, photo, size);
				});

				message = "Uploaded the photos successfully.";
				return new ResponseEntity<ResponseMessage>(new ResponseMessage(message), HttpStatus.OK);
			}
			catch (Exception e)
			{
				message = "Failed to upload photos.";
				return new ResponseEntity<ResponseMessage>(new ResponseMessage(message), HttpStatus.EXPECTATION_FAILED);
			}
		}
//		else
//			return new ResponseEntity<ResponseMessage>(new ResponseMessage("Sorry, you are not allowed to use this service."), HttpStatus.BAD_REQUEST);

	}

	@GetMapping(path = RestAPI.IMAGES)
	public ResponseEntity<?> getListFiles(@RequestParam(value = "member_lecture_id") String magazineId)
	{
		List<FileInfo> fileInfos = fileStorageService.loadAll().map(path -> {
			String filename = path.getFileName().toString();
			String url = MvcUriComponentsBuilder
					.fromMethodName(MagazineController.class, "getFile", path.getFileName().toString()).build().toString();

			return new FileInfo(filename, url);
		}).collect(Collectors.toList());

		fileInfos = fileStorageService.filterImagesMagazine(magazineId, fileInfos);

		return ResponseEntity.status(HttpStatus.OK).body(fileInfos);
	}

	@GetMapping("/images/{filename:.+}")
	public ResponseEntity<Resource> getFile(@PathVariable String filename) {
		Resource file = fileStorageService.load(filename);
		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
	}
}
