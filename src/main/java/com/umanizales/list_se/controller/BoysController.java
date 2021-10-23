package com.umanizales.list_se.controller;

import com.umanizales.list_se.controller.dto.ResponseDTO;
import com.umanizales.list_se.model.Boy;
import com.umanizales.list_se.service.ListSeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "boys")

public class BoysController {

    @Autowired
    private ListSeService listSeService;

    @PostMapping
    public ResponseEntity<ResponseDTO> addBoy(@RequestBody Boy boy)
    {
        return listSeService.addBoy(boy);
    }

    @GetMapping
    public ResponseEntity<ResponseDTO> getBoys()
    {
        return listSeService.listBoys();
    }



    @GetMapping(path = "free")
    public ResponseEntity<ResponseDTO> listBoysFree()
    {
        return listSeService.listBoysFree();
    }

    @GetMapping(path = "invert")
    public ResponseEntity<ResponseDTO> invertList()
    {
        return listSeService.invertList();
    }

    @PostMapping(path = "addtostart")
    public ResponseEntity<ResponseDTO> addBoyToStar(@RequestBody Boy boy)
    {
        return listSeService.addBoyToStart(boy);
    }

    @PostMapping(path = "addboys")
    public ResponseEntity<ResponseDTO> addBoys(@RequestBody List<Boy> boys)
    {
        for (Boy boy:boys)
        {
            listSeService.addBoy(boy);
        }
        return new ResponseEntity<ResponseDTO>(new ResponseDTO("Satisfactorio", listSeService.listBoys(), null), HttpStatus.OK);
    }

    @GetMapping(path = "getcount")
    public ResponseEntity<ResponseDTO> getCount()
    {
        return listSeService.getCount();
    }

    @GetMapping(path = "count")
    public ResponseEntity<ResponseDTO> count()
    {
        return listSeService.count();
    }

    @GetMapping(path = "changextremes")
    public ResponseEntity<ResponseDTO> changeXtremes()
    {
        return listSeService.changeXtremes();
    }

    @GetMapping(path = "gender/{gender}")
    public ResponseEntity<ResponseDTO> listGender(@PathVariable String gender)
    {
        return listSeService.listGender(gender);
    }

    @GetMapping(path = "delete/{identification}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable String identification)
    {
        return listSeService.delete(identification);
    }

    @GetMapping(path = "first/{gender}")
    public ResponseEntity<ResponseDTO> listGenderFirst(@PathVariable String gender)
    {
        return listSeService.listGenderFirst(gender);
    }

    @GetMapping(path = "intervalsgender/{gender}")
    public ResponseEntity<ResponseDTO> listIntervalsGender(@PathVariable String gender)
    {
        return listSeService.listIntervalsGender(gender);
    }
}
