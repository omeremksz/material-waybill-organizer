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
    public List<MaterialModel>getMaterials(){
        return materialService.getAll();
    }

    @GetMapping(value = "/list/{materialId}")
    public List<MaterialModel> getMaterialById(@PathVariable("materialId") Long materialId){
        return materialService.getMaterialById(materialId);
    }

    @PostMapping(value = "/save")
    public MaterialModel saveMaterial(@RequestBody MaterialModel materialModel){
        return materialService.saveMaterial(materialModel);
    }

    @DeleteMapping(path = "/delete/{materialId}")
    public void deleteMaterial(@PathVariable("materialId") Long materialId) {
        materialService.deleteMaterial(materialId);
    }

    @PutMapping(path = "/update/{materialId}")
    public void updateMaterial(@PathVariable("materialId") Long materialId, @RequestBody MaterialModel materialModel){
        materialService.updateMaterial(materialId, materialModel);
    }
}
