package net.tsolval.config.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.tsolval.config.data.Property;

@Repository
public interface PropertyRepository extends JpaRepository<Property, Long> {
	public List<Property> findByContext(String context);
}
