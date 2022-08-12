package kalemyazilim.materialapp.materialwaybillorganizer.repository;

import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaterialRepo extends JpaRepository<MaterialModel, Long> {
    @Query("SELECT m FROM MaterialModel m WHERE m.Id = ?1")
    List<MaterialModel> getMaterialById(Long materialId);

    Integer countByCode(String code);
}
