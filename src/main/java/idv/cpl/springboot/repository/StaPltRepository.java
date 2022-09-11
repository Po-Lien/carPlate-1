package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.StaPltDTO;

@Repository
public interface StaPltRepository extends JpaRepository<StaPltDTO, Long> {

}
