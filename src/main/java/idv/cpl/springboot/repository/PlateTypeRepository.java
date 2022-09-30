package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.PlateType;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface PlateTypeRepository extends JpaRepository<PlateType, Long> {

}
