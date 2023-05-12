package dalmin.infra;

import dalmin.domain.*;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "myOrders", path = "myOrders")
public interface MyOrderRepository
    extends PagingAndSortingRepository<MyOrder, Long> {}
