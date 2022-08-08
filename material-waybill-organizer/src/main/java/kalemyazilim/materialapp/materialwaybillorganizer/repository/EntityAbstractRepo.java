package kalemyazilim.materialapp.materialwaybillorganizer.repository;

import kalemyazilim.materialapp.materialwaybillorganizer.base.EntityAbstractClass;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface EntityAbstractRepo extends CrudRepository<EntityAbstractClass,Long> {
}
