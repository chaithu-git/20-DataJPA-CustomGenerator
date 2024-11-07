package in.chaithanya.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import in.chaithanya.entity.OrderDetailsEntity;

public interface OrderDetailsRepository extends JpaRepository<OrderDetailsEntity, Serializable> {

}
