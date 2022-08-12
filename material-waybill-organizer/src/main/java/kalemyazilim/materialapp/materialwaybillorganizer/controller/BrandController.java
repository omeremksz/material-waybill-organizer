package kalemyazilim.materialapp.materialwaybillorganizer.controller;

import kalemyazilim.materialapp.materialwaybillorganizer.model.BrandModel;
import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialModel;
import kalemyazilim.materialapp.materialwaybillorganizer.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/brand")
public class BrandController {
    @Autowired
    BrandService brandService;

    @GetMapping(value = "/list")
    public List<BrandModel> getBrandModel(){
        return brandService.getAll();
    }

    @GetMapping(value = "/list/{brandId}")
    public List<BrandModel> getBrandById(@PathVariable("brandId") Long brandId){
        return brandService.getBrandById(brandId);
    }

    @PostMapping(value = "/save")
    public BrandModel saveBrand(@RequestBody BrandModel brandModel){
        return brandService.saveBrand(brandModel);
    }

    @DeleteMapping(path = "/delete/{brandId}")
    public void deleteBrand(@PathVariable("brandId") Long brandId) {
        brandService.deleteBrand(brandId);
    }

    @PutMapping(path = "/update/{brandId}")
    public void updateBrand(@PathVariable("brandId") Long brandId, @RequestBody BrandModel brandModel){
        brandService.updateBrand(brandId, brandModel);
    }
}
