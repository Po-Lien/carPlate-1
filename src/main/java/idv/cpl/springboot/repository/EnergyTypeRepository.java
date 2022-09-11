package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import idv.cpl.springboot.dto.EnergyTypeDTO;

@Repository
public interface EnergyTypeRepository extends JpaRepository<EnergyTypeDTO, Long> {

}
