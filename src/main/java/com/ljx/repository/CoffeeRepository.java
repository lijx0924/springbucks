package com.ljx.repository;

import com.ljx.model.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jerry
 */
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
