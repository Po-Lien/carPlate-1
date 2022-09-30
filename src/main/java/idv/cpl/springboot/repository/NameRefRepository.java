package idv.cpl.springboot.repository;

import org.springframework.stereotype.Repository;

import idv.cpl.springboot.entity.NameRef;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface NameRefRepository extends JpaRepository<NameRef, Long> {

}
