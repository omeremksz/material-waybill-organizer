package kalemyazilim.materialapp.materialwaybillorganizer.repository;

import kalemyazilim.materialapp.materialwaybillorganizer.model.BrandModel;
import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepo extends JpaRepository<BrandModel, Long> {
    @Query("SELECT b FROM BrandModel b WHERE b.Id = ?1")
    List<BrandModel> getBrandsById(Long brandId);

    @Query("SELECT b FROM BrandModel b WHERE b.Id = ?1")
    BrandModel getBrandById(Long brandId);

    Integer countByCode(String code);
}
