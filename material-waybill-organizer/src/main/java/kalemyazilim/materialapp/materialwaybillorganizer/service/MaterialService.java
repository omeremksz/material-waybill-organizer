package kalemyazilim.materialapp.materialwaybillorganizer.service;

import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialBarcodeModel;
import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialModel;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.MaterialBarcodeRepo;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.MaterialRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialRepo materialRepo;

    @Autowired
    MaterialBarcodeRepo materialBarcodeRepo;

    public List<MaterialModel> getAll() {
        return materialRepo.findAll();
    }

    public List<MaterialModel> getMaterialByMaterialId(Long materialId) {
        return materialRepo.getMaterialsById(materialId);
    }

    public MaterialModel saveMaterialModel(MaterialModel materialModel){
        materialModel.setCreateDate(new Date());
        materialRepo.save(materialModel);
        for (MaterialBarcodeModel materialBarcode : materialModel.getMaterialBarcodes()) {
            materialBarcode.setMaterialModel(materialModel);
            materialBarcodeRepo.save(materialBarcode);
        }
        return materialModel;
    }

    public void deleteFile(Long materialId) {
        boolean isMaterialExists = materialRepo.existsById(materialId);
        if (!isMaterialExists) {
            throw new IllegalStateException("File with id " + materialId + " does not exists.");
        }
        materialRepo.deleteById(materialId);
    }
    @Transactional
    public void updateMaterialModel(Long materialId, MaterialModel updatedMaterialModel) {
        MaterialModel materialModel = materialRepo.findById(materialId).orElseThrow(() -> new IllegalStateException("Material not found for this id :: " + materialId));
        //BeanUtils.copyProperties(updatedMaterialModel, materialModel);
        materialModel.setUpdateDate(new Date());
        materialModel.setCode(updatedMaterialModel.getCode());
        materialModel.setDescription(updatedMaterialModel.getDescription());
        materialModel.setBrand(updatedMaterialModel.getBrand());
        materialModel.setRayon(updatedMaterialModel.getRayon());
        materialModel.setMaterialBarcodes(updatedMaterialModel.getMaterialBarcodes());
        materialRepo.save(materialModel);
    }
}
