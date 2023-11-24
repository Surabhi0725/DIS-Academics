package sgsits.cse.dis.academics.service;

import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.model.MemberDetails;
import sgsits.cse.dis.academics.model.MagazineDetails;
import sgsits.cse.dis.academics.request.AddMagazineForm;
import sgsits.cse.dis.academics.request.EditMagazineForm;
import sgsits.cse.dis.academics.request.MemberForm;
import sgsits.cse.dis.academics.response.MagazineResponse;
import sgsits.cse.dis.academics.response.MemberNamesAndDesignationsResponse;

import java.io.IOException;
import java.util.List;

public interface MagazineService {
	
	String addMember(MemberForm addMemberForm);

	String editMember(MemberForm editMemberForm);
	
	String addMagazine(AddMagazineForm addMagazineForm);
	
	List<MagazineResponse> getMagazineByStatus(String status);
	
	List<MagazineDetails> getAllMagazine();
	
	List<MemberDetails> getAllMember();
	
	MagazineDetails viewMagazineDetails(String magazineId);

	List<MemberNamesAndDesignationsResponse> getMemberNamesAndDesignations();

	MemberDetails findMember(String memberId);

	List<MagazineResponse> searchMagazine(String keyword, String status);

	String updateMagazineStatus(String magazineId, String newStatus) throws IOException;

    String deleteMember(String memberId);

    String editMagazine(String magazineId, EditMagazineForm editMagazineForm);

	String deleteMagazine(String magazineId);

	MagazineDetails downloadNotesheet(String magazineId);

	String updatePaymentStatusAndRemarks(String magazineId, String paymentStatus, String remarks);
}
