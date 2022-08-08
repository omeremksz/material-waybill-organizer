package kalemyazilim.materialapp.materialwaybillorganizer.controller;

import kalemyazilim.materialapp.materialwaybillorganizer.model.MaterialModel;
import kalemyazilim.materialapp.materialwaybillorganizer.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/material")
public class MaterialController {
    @Autowired
    MaterialService materialService;

    @GetMapping(value = "/list")
    public List<MaterialModel>getMaterialModel(){
        return materialService.getAll();
    }

    @GetMapping(value = "/list/{materialId}")
    public List<MaterialModel> getMaterialByMaterialId(@PathVariable("materialId") Long materialId){
        return materialService.getMaterialByMaterialId(materialId);
    }

    @PostMapping(value = "/save")
    public MaterialModel saveMaterialModel(@RequestBody MaterialModel materialModel){
        return materialService.saveMaterialModel(materialModel);
    }

    @DeleteMapping(path = "/delete/{materialId}")
    public void deleteMaterial(@PathVariable("materialId") Long materialId) {
        materialService.deleteFile(materialId);
    }

    @PutMapping(path = "/update/{materialId}")
    public void updateMaterial(@PathVariable("materialId") Long materialId, @RequestBody MaterialModel updatedMaterialModel){
        materialService.updateMaterialModel(materialId, updatedMaterialModel);
    }
}
