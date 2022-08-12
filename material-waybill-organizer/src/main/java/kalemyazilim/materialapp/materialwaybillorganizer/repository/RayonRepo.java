package kalemyazilim.materialapp.materialwaybillorganizer.repository;

import kalemyazilim.materialapp.materialwaybillorganizer.model.RayonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RayonRepo extends JpaRepository<RayonModel, Long> {
    @Query("SELECT r FROM RayonModel r WHERE r.Id = ?1")
    List<RayonModel> getRayonsById(Long rayonId);

    @Query("SELECT r FROM RayonModel r WHERE r.Id = ?1")
    RayonModel getRayonById(Long rayonId);

    Integer countByCode(String code);
}
