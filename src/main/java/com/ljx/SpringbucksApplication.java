package com.ljx;

import com.ljx.model.Coffee;
import com.ljx.model.CoffeeOrder;
import com.ljx.model.OrderState;
import com.ljx.repository.CoffeeRepository;
import com.ljx.service.CoffeeOrderService;
import com.ljx.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Optional;

/**
 * @author jerry
 */
@Slf4j
@EnableTransactionManagement
@SpringBootApplication
@EnableJpaRepositories
public class SpringbucksApplication implements ApplicationRunner {
  @Autowired
  private CoffeeRepository coffeeRepository;
  @Autowired
  private CoffeeService coffeeService;
  @Autowired
  private CoffeeOrderService orderService;
  public static void main(String[] args) {
    SpringApplication.run(SpringbucksApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    log.info("All Coffee: {}", coffeeRepository.findAll());

    Optional<Coffee> latte = coffeeService.findOneCoffee("Latte");
    if (latte.isPresent()) {
      CoffeeOrder order = orderService.createOrder("Li Lei", latte.get());
      log.info("Update INIT to PAID: {}", orderService.updateState(order, OrderState.PAID));
      log.info("Update PAID to INIT: {}", orderService.updateState(order, OrderState.INIT));
    }
  }
}
