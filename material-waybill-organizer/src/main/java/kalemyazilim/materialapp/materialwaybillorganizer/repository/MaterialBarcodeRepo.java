package kalemyazilim.materialapp.materialwaybillorganizer.repository;

import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialBarcodeModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialBarcodeRepo extends JpaRepository<MaterialBarcodeModel, Long> {
}
