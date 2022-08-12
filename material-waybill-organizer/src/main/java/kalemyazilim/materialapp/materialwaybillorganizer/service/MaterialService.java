package kalemyazilim.materialapp.materialwaybillorganizer.service;

import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialBarcodeModel;
import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialModel;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.BrandRepo;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.MaterialBarcodeRepo;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.MaterialRepo;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.RayonRepo;
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
    @Autowired
    BrandRepo brandRepo;
    @Autowired
    RayonRepo rayonRepo;

    public List<MaterialModel> getAll() {
        return materialRepo.findAll();
    }

    public List<MaterialModel> getMaterialById(Long materialId) {
        return materialRepo.getMaterialById(materialId);
    }

    public MaterialModel saveMaterial(MaterialModel materialModel){
        if (materialRepo.countByCode(materialModel.getCode()) > 0) {
            throw new IllegalStateException("There is already a material with same code.");
        }
        materialModel.setBrand(brandRepo.getBrandById(materialModel.getBrand().getId()));
        materialModel.setRayon(rayonRepo.getRayonById(materialModel.getRayon().getId()));
        materialModel.setCreateDate(new Date());
        materialRepo.save(materialModel);
        for (MaterialBarcodeModel materialBarcode : materialModel.getMaterialBarcodes()) {
            materialBarcode.setMaterialModel(materialModel);
            materialBarcode.setCreateDate(new Date());
            materialBarcodeRepo.save(materialBarcode);
        }
        return materialModel;
    }

    public void deleteMaterial(Long materialId) {
        boolean isMaterialExists = materialRepo.existsById(materialId);
        if (!isMaterialExists) {
            throw new IllegalStateException("Material with id " + materialId + " does not exists.");
        }
        materialRepo.deleteById(materialId);
    }
    @Transactional
    public void updateMaterial(Long materialId, MaterialModel updatedMaterialModel) {
        MaterialModel materialModel = materialRepo.findById(materialId).orElseThrow(() -> new IllegalStateException("Material not found for this id: " + materialId));
        materialModel.setUpdateDate(new Date());
        materialModel.setBrand(brandRepo.getBrandById(updatedMaterialModel.getBrand().getId()));
        materialModel.setRayon(rayonRepo.getRayonById(updatedMaterialModel.getRayon().getId()));

//        Map<Long, Date> temp = new HashMap<Long, Date>();
//        for (MaterialBarcodeModel materialBarcode : materialModel.getMaterialBarcodes()) {
//            temp.put(materialBarcode.getId(), materialBarcode.getCreateDate());
//        }
//        for (MaterialBarcodeModel updatedMaterialBarcode : updatedMaterialModel.getMaterialBarcodes()) {
//            for (Map.Entry<Long, Date> i : temp.entrySet()) {
//                if(i.getKey()==updatedMaterialBarcode.getId()){
//                    updatedMaterialBarcode.setCreateDate(i.getValue());
//                }
//            }
//        }


        materialBarcodeRepo.deleteAll();
        materialModel.setMaterialBarcodes(updatedMaterialModel.getMaterialBarcodes());
        for (MaterialBarcodeModel materialBarcode : materialModel.getMaterialBarcodes()) {
            materialBarcode.setMaterialModel(materialModel);
            materialBarcode.setUpdateDate(new Date());
            materialBarcodeRepo.save(materialBarcode);
        }
        materialRepo.save(materialModel);
    }
}
