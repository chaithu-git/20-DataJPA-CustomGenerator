package in.chaithanya;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import in.chaithanya.entity.OrderDetailsEntity;
import in.chaithanya.repository.OrderDetailsRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
		OrderDetailsRepository orderDetailsRepository=context.getBean(OrderDetailsRepository.class);
		
		OrderDetailsEntity  ode=new OrderDetailsEntity();
		//ode.setOrderId(10);
		ode.setOrderBy("dress");
		ode.setOrderPlaceDate(new Date());
		orderDetailsRepository.save(ode);
		System.out.println(orderDetailsRepository);
	}

}
