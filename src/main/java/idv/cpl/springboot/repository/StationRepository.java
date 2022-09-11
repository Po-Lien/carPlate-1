package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.StationDTO;

@Repository
public interface StationRepository extends JpaRepository<StationDTO, Long> {

}
