package com.ljx.repository;

import com.ljx.model.CoffeeOrder;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jerry
 */
public interface CoffeeOrderRepository extends JpaRepository<CoffeeOrder, Long> {
}
