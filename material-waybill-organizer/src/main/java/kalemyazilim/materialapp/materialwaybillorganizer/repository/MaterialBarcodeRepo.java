package kalemyazilim.materialapp.materialwaybillorganizer.repository;

import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialBarcodeModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialBarcodeRepo extends JpaRepository<MaterialBarcodeModel, Long> {
}
