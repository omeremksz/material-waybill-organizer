package kalemyazilim.materialapp.materialwaybillorganizer.service;

import kalemyazilim.materialapp.materialwaybillorganizer.model.BrandModel;
import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialModel;
import kalemyazilim.materialapp.materialwaybillorganizer.repository.BrandRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
public class BrandService {
    @Autowired
    BrandRepo brandRepo;

    public List<BrandModel> getAll() {
        return brandRepo.findAll();
    }

    public List<BrandModel> getBrandById(Long brandId) {
        return brandRepo.getBrandsById(brandId);
    }

    public BrandModel saveBrand(BrandModel brandModel) {
        brandModel.setCreateDate(new Date());
        return brandRepo.save(brandModel);
    }

    public void deleteBrand(Long brandId) {
        boolean isBrandExists = brandRepo.existsById(brandId);
        if (!isBrandExists) {
            throw new IllegalStateException("Brand with id " + brandId + " does not exists.");
        }
        brandRepo.deleteById(brandId);
    }
    @Transactional
    public void updateBrand(Long brandId, BrandModel updatedBrandModel) {
        BrandModel brandModel = brandRepo.findById(brandId).orElseThrow(() -> new IllegalStateException("Brand not found for this id: " + brandId));
        brandModel.setUpdateDate(new Date());
        brandModel.setCode(updatedBrandModel.getCode());
        brandModel.setDescription(updatedBrandModel.getDescription());
    }
}
