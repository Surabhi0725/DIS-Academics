package sgsits.cse.dis.academics.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import sgsits.cse.dis.academics.model.MemberDetails;
import sgsits.cse.dis.academics.model.MagazineDetails;
import sgsits.cse.dis.academics.model.MemberNamesAndDesignations;
import sgsits.cse.dis.academics.repo.MagazineRepository;
import sgsits.cse.dis.academics.repo.MemberRepository;
import sgsits.cse.dis.academics.request.AddMagazineForm;
import sgsits.cse.dis.academics.request.EditMagazineForm;
import sgsits.cse.dis.academics.request.MemberForm;
import sgsits.cse.dis.academics.response.MagazineResponse;
import sgsits.cse.dis.academics.response.MemberNamesAndDesignationsResponse;
import sgsits.cse.dis.academics.service.MagazineService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MagazineRepository magazineRepository;
	
	//EXPERT SERVICES
	
	@Override
	public String addMember(MemberForm addMemberForm) {
		
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		MemberDetails memberDetails = new MemberDetails();
		memberDetails.setName(addMemberForm.getName());
		memberDetails.setDesignation(addMemberForm.getDesignation());
		memberDetails.setEmail(addMemberForm.getEmail());
		memberDetails.setMobileNo(addMemberForm.getMobileNo());
		
		MemberDetails test = memberRepository.save(memberDetails);
		
		if(test!=null)
			return test.getName()+" successfully added to member.";
		else
			return null;
	}
	
	@Override
	public MemberDetails findMember(String memberId) {
		return memberRepository.findByMemberId(memberId);
	}
	
	@Override
	public List<MagazineDetails> getAllMagazine(){
		return magazineRepository.findAll();
	}
	
	@Override
	public List<MemberDetails> getAllMember(){
		return memberRepository.findAll();
	}
	
	@Override
	public String editMember(MemberForm editMemberForm) 
	{
		MemberDetails member = memberRepository.findByMemberId(editMemberForm.getMemberId());
		member.setDesignation(editMemberForm.getDesignation());
		member.setName(editMemberForm.getName());
		member.setMobileNo(editMemberForm.getMobileNo());
		member.setEmail(editMemberForm.getEmail());
		member.setMobileNo(editMemberForm.getMobileNo());
		
		MemberDetails test = memberRepository.save(member);
		
		if(test!=null)
			return "Member details updated successfully.";
		else
			return "Error updating member details, please try again.";
		
	}

	@Override
	public String deleteMember(String memberId) {
		MemberDetails member = memberRepository.findByMemberId(memberId);
		memberRepository.delete(member);
		return "Member deleted successfully from the records.";
	}


	@Override
	public List<MemberNamesAndDesignationsResponse> getMemberNamesAndDesignations()
	{
		List<MemberNamesAndDesignations> fetch = magazineRepository.fetchMember();
//		System.out.println(fetch);
		List<MemberNamesAndDesignationsResponse> output = new ArrayList<MemberNamesAndDesignationsResponse>();
		for(MemberNamesAndDesignations data : fetch)
		{
			MemberNamesAndDesignationsResponse record = new MemberNamesAndDesignationsResponse();
			record.setMemberName(data.getName());
			record.setMemberDesignation(data.getDesignation());
			output.add(record);
		}
		return output;
	}
	
	//MAGAZINE SERVICES
	
	@Override
	public String addMagazine(AddMagazineForm addMagazineForm)
	{
		MagazineDetails magazineDetails = new MagazineDetails();
		magazineDetails.setTopic(addMagazineForm.getTopic());

		magazineDetails.setMemberName(addMagazineForm.getMemberName());
		magazineDetails.setMemberDesignation(addMagazineForm.getMemberDesignation());
		magazineDetails.setSubmittedByDesignation(addMagazineForm.getSubmittedByDesignation());
		magazineDetails.setSubmittedByName(addMagazineForm.getSubmittedByName());
		magazineDetails.setMemberDesignation(addMagazineForm.getMemberDesignation());
		magazineDetails.setTopic(addMagazineForm.getTopic());
		magazineDetails.setTitle(addMagazineForm.getTitle());
		magazineDetails.setArticle(addMagazineForm.getArticle());
		magazineDetails.setDate(addMagazineForm.getDate());
		magazineDetails.setStatus("Pending");
		System.out.println(magazineDetails);
		MagazineDetails test = magazineRepository.save(magazineDetails);
		
		if(test!=null)
			return "Member lecture on the topic '"+test.getTopic()+"' on Date: "+test.getDate();
		else
			return null;
	}
	
	@Override
	public List<MagazineResponse> getMagazineByStatus (String status)
	{
		System.out.println(status);
		List<MagazineDetails> magazines = magazineRepository.findByStatusIgnoreCase(status);
		List<MagazineResponse> output = new ArrayList<MagazineResponse>();
		for(MagazineDetails data : magazines)
		{
			MagazineResponse test = new MagazineResponse();
			test.setMagazineId(data.getMagazineId());
			test.setTopic(data.getTopic());
			test.setStatus(data.getStatus());
			test.setArticle(data.getArticle());
			test.setSubmittedByDesignation(data.getSubmittedByDesignation());
			test.setSubmittedByName(data.getSubmittedByName());
			test.setDate(data.getDate());
			test.setTitle(data.getTitle());
			test.setStatus(data.getStatus());
			test.setMemberName(data.getMemberName());
			output.add(test);
		}
		return output;
	}
	
	@Override
	public MagazineDetails viewMagazineDetails (String magazineId)
	{
		return magazineRepository.findByMagazineId(magazineId);
	}
	@Override
	public List<MagazineResponse> searchMagazine(String keyword, String status) {
		List<MagazineDetails> magazines = magazineRepository.findByTitleContainingIgnoreCaseAndStatus(keyword, status);
		System.out.println("-===="+" "+magazineRepository);
//		magazines=magazineRepository.findAll();
		System.out.println("-===="+" "+magazines);
		System.out.println("-===="+" "+keyword);
		System.out.println("-===="+" "+status);
		List<MagazineResponse> output = new ArrayList<MagazineResponse>();
		for(MagazineDetails data : magazines)
		{
			System.out.println(data.getStatus());
			System.out.println(data.getTitle());

			MagazineResponse test = new MagazineResponse();
			test.setTopic(data.getTopic());
			test.setTitle(data.getTitle());
			test.setDate(data.getDate());
			test.setSubmittedByName(data.getSubmittedByName());
			test.setSubmittedByDesignation(data.getSubmittedByDesignation());
			test.setMemberName(data.getMemberName());
			test.setArticle(data.getArticle());
			output.add(test);
		}
		return output;
	}

	@Override
	public String updateMagazineStatus(String magazineId, String newStatus) throws IOException
	{
		MagazineDetails magazine = magazineRepository.findByMagazineId(magazineId);
		magazine.setStatus(newStatus);
		MagazineDetails test = magazineRepository.save(magazine);
		return "Status Updated to "+newStatus;
	}

	@Override
	public String editMagazine(String magazineId, EditMagazineForm editMagazineForm) {
		MagazineDetails magazineDetails = magazineRepository.findByMagazineId(magazineId);
		if(magazineDetails.getStatus().equals("Completed"))
			return "Cannot edit details of a completed member lecture.";

		magazineDetails.setArticle(editMagazineForm.getArticle());
		magazineDetails.setMemberName(editMagazineForm.getMemberName());
		magazineDetails.setTitle(editMagazineForm.getTitle());
		magazineDetails.setTopic(editMagazineForm.getTopic());

		MagazineDetails test = magazineRepository.save(magazineDetails);
		if(test!=null)
			return "Member lecture details updated successfully.";
		else
			return "Could not update details, please try again.";
	}

	@Override
	public String deleteMagazine(String magazineId) {
		MagazineDetails magazineDetails = magazineRepository.findByMagazineId(magazineId);
		if(magazineDetails.getStatus().equals("Completed"))
			return "Cannot delete a completed member lecture.";
		magazineRepository.delete(magazineDetails);
		return "Member lecture deleted successfully from the records.";

	}

	@Override
	public MagazineDetails downloadNotesheet(String magazineId) {
		return magazineRepository.findByMagazineId(magazineId);
	}

	@Override
	public String updatePaymentStatusAndRemarks(String magazineId, String paymentStatus, String remarks) {
		return null;
	}

//	@Override
//	public MagazineDetails downloadAttendance(String magazineId) {
//		return magazineRepository.findByMagazineId(magazineId);
//	}

//	@Override
//	public String updatePaymentStatusAndRemarks(String magazineId, String paymentStatus, String remarks) {
//		MagazineDetails magazineDetails = magazineRepository.findByMagazineId(magazineId);
////		if(magazineDetails.getPaymentStatus().equals("Completed"))
////			return "Payment already completed, cannot update payment status.";
////		magazineDetails.setPaymentStatus(paymentStatus);
//		magazineDetails.setRemarks(remarks);
//
//		MagazineDetails test = magazineRepository.save(magazineDetails);
//		if(test!=null)
//			return "Details updated successfully.";
//		else
//			return "Could not update details, please try again.";
//	}

}
