package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.EnergyType;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EnergyTypeRepository extends JpaRepository<EnergyType, Long> {

}
