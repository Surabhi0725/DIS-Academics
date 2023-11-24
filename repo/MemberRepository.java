package sgsits.cse.dis.academics.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import sgsits.cse.dis.academics.model.MemberDetails;

public interface MemberRepository extends JpaRepository<MemberDetails, Long> {

	MemberDetails findByNameAndDesignation(String name, String designation);

    MemberDetails findByMemberId(String memberId);
}
