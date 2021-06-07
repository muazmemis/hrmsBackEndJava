package software.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import software.hrms.entities.concretes.Candidate;


public interface CandidateDao  extends JpaRepository<Candidate, Integer>{

}
