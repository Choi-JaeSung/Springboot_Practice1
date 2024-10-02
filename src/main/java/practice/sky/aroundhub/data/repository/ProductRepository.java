package practice.sky.aroundhub.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import practice.sky.aroundhub.data.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, String>
{

}

/*
- JpaRepository<Entity_name, Entity_PK_Type> : 해당 Type 을 PK 로 하는 Entity 를 사용할 JpaRepository 로 생성
 */