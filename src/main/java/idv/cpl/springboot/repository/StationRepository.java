package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.Station;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StationRepository extends JpaRepository<Station, Long> {

}
