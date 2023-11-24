package sgsits.cse.dis.academics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sgsits.cse.dis.academics.model.MagazineDetails;
import sgsits.cse.dis.academics.model.MemberNamesAndDesignations;

import java.util.List;

public interface MagazineRepository extends JpaRepository <MagazineDetails, Long> {

	List<MagazineDetails> findByStatusIgnoreCase(String status);

	MagazineDetails findByMagazineId(String magazineId);
	
	@Query(value = "SELECT name, designation FROM member_details", nativeQuery = true)
	List<MemberNamesAndDesignations> fetchMember();

	List<MagazineDetails> findByTitleContainingIgnoreCaseAndStatus(String keyword, String status);

}
