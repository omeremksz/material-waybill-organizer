package kalemyazilim.materialapp.materialwaybillorganizer.controller;

import kalemyazilim.materialapp.materialwaybillorganizer.model.RayonModel;
import kalemyazilim.materialapp.materialwaybillorganizer.service.RayonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/rayon")
public class RayonController {
    @Autowired
    RayonService rayonService;

    @GetMapping(value = "/list")
    public List<RayonModel> getRayons(){
        return rayonService.getAll();
    }

    @GetMapping(value = "/list/{rayonId}")
    public List<RayonModel> getRayonById(@PathVariable("rayonId") Long rayonId){
        return rayonService.getRayonById(rayonId);
    }

    @PostMapping(value = "/save")
    public RayonModel saveRayon(@RequestBody RayonModel rayonModel){
        return rayonService.saveRayon(rayonModel);
    }

    @DeleteMapping(path = "/delete/{rayonId}")
    public void deleteRayon(@PathVariable("rayonId") Long rayonId) {
        rayonService.deleteRayon(rayonId);
    }

    @PutMapping(path = "/update/{rayonId}")
    public void updateRayon(@PathVariable("rayonId") Long rayonId, @RequestBody RayonModel rayonModel){
        rayonService.updateRayon(rayonId, rayonModel);
    }
}
