package com.umanizales.list_se.service;

import com.umanizales.list_se.controller.dto.ResponseDTO;
import com.umanizales.list_se.model.Boy;
import com.umanizales.list_se.model.ListSE;
import org.springframework.core.StandardReflectionParameterNameDiscoverer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service

public class ListSeService {
    private ListSE listBoys;

    public ListSeService() {
        listBoys = new ListSE();
    }

    public ResponseEntity<ResponseDTO> addBoy(Boy boy)
    {
        listBoys.add(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoysFree()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.list(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listBoys()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> invertList()
    {
        listBoys.invert();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.getHead(), null), HttpStatus.OK);

    }

    public ResponseEntity<ResponseDTO> addBoyToStart(Boy boy)
    {
        listBoys.addToStart(boy);
        return new ResponseEntity<>(new ResponseDTO("Niño adicionado", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> getCount()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.getCount(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> count()
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.count(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> changeXtremes()
    {
        listBoys.changeXtremes();
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", true, null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listGender(String gender)
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.listGender(gender), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> delete(String identificate)
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.delete(identificate), null), HttpStatus.OK);
    }
    public ResponseEntity<ResponseDTO> listGenderFirst(String gender)
    {
        listBoys.listGenderFirst(gender);
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.getHead(), null), HttpStatus.OK);
    }

    public ResponseEntity<ResponseDTO> listIntervalsGender(String gender)
    {
        return new ResponseEntity<>(new ResponseDTO("Satisfactorio", listBoys.listIntervalsGender(gender), null ), HttpStatus.OK);
    }
}