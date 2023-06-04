package org.drdel.beca.prjfinal.micro.gestoras.controllers;

import org.drdel.beca.prjfinal.micro.gestoras.api.commons.AppController;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.PoliticaInversionDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.IPoliticaInversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PoliticaInversionController extends AppController {
    private static final String MSG_RESPONSE_KEY_MENSAJE= "mensaje";
    private static final String MSG_RESPONSE_KEY_CLIENTE= "Politica";
    private static final String MSG_RESPONSE_KEY_ERRORES= "errors";

    private static final String NO_VALIDO="Politica no válida";
    private static final String ACTUALIZADO="Politica actualizada con éxito";

    @Autowired
    private IPoliticaInversionService politicaService;

    @GetMapping("/politica")
    public List<PoliticaInversionDTO> list(){
        return politicaService.obtenerTodosPoliticaInversion();
    }

    @GetMapping("/politica/{cod}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable String cod){
        PoliticaInversionDTO politicaInversionDTO;
        try {
            politicaInversionDTO=politicaService.obtenerPoliticaInversion(cod);
        }catch (Exception e){
            return gestionarExceptionResponse(e);
        }
        if (politicaInversionDTO==null){
            return gestionarResponse(
                    "La Politica COD: ".concat(cod).concat(" no existe en la BD"),
                    politicaInversionDTO, HttpStatus.NOT_FOUND);
        }

        return gestionarResponse(
                "Politica obtenida con éxito",
                politicaInversionDTO,
                HttpStatus.OK);
    }

    @PostMapping(value={"/politica"})
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody PoliticaInversionDTO politicaInversionDTO,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        String cod;
        PoliticaInversionDTO politicaGuardada;

        try {
            cod = politicaService.crearPoliticaInversion(politicaInversionDTO);
            politicaGuardada = politicaService.obtenerPoliticaInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                "Politica de inversion creada con éxito",
                politicaGuardada,
                HttpStatus.CREATED);

    }


    @PutMapping("/politica/{cod}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String cod,
                                                      @Valid @RequestBody PoliticaInversionDTO politicaInversionDTO,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        PoliticaInversionDTO politicaGuardada;

        try {
            politicaService.actualizarPoliticaInversion(politicaInversionDTO);
            politicaGuardada = politicaService.obtenerPoliticaInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                politicaGuardada,
                HttpStatus.CREATED);

    }


    @PatchMapping("/politica/operative/{cod}")
    public ResponseEntity<Map<String, Object>> updateOperative(@PathVariable String cod,
                                                               @Valid @RequestBody PoliticaInversionDTO politicaInversionDTO,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        PoliticaInversionDTO politicaGuardada;

        try {
            politicaService.activarPoliticaInversion(politicaInversionDTO);
            politicaGuardada = politicaService.obtenerPoliticaInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                politicaGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/politica/canceled/{cod}")
    public ResponseEntity<Map<String, Object>> updateCanceled(@PathVariable String cod,
                                                              @Valid @RequestBody PoliticaInversionDTO politicaInversionDTO,
                                                              BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        PoliticaInversionDTO politicaGuardada;

        try {
            politicaService.cancelarPoliticaInversion(politicaInversionDTO);
            politicaGuardada = politicaService.obtenerPoliticaInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                politicaGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/politica/suspended/{cod}")
    public ResponseEntity<Map<String, Object>> updateSuspended(@PathVariable String cod,
                                                               @Valid @RequestBody PoliticaInversionDTO politicaInversionDTO,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        PoliticaInversionDTO politicaGuardada;

        try {
            politicaService.suspenderPoliticaInversion(politicaInversionDTO);
            politicaGuardada = politicaService.obtenerPoliticaInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                politicaGuardada,
                HttpStatus.CREATED);

    }

    @DeleteMapping("/politica/{cod}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String cod) {

        PoliticaInversionDTO politicaInversionDTO;

        try {
            politicaInversionDTO = politicaService.obtenerPoliticaInversion(cod);
            if (politicaInversionDTO != null)
                politicaService.borrarPoliticaInversion(cod);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        if (politicaInversionDTO != null)
            return gestionarResponse(
                    "Politica eliminada con éxito",
                    politicaInversionDTO,
                    HttpStatus.OK);
        else
            return gestionarResponse(
                    "Politica inexistente: ".concat(cod),
                    politicaInversionDTO,
                    HttpStatus.NOT_FOUND);
    }



    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, PoliticaInversionDTO politicaInversionDTO, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(politicaInversionDTO != null)
            mapResult.put(MSG_RESPONSE_KEY_CLIENTE, politicaInversionDTO);

        return new ResponseEntity<>(mapResult, status);

    }

    private ResponseEntity<Map<String, Object>> gestionarResponseNoValida(String msg, BindingResult result) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);

        List<String> errors = result.getFieldErrors()
                .stream()
                .map(err -> err.getField() + " - " + err.getDefaultMessage())
                .collect(Collectors.toList());

        mapResult.put(MSG_RESPONSE_KEY_ERRORES, errors);

        return new ResponseEntity<>(mapResult, HttpStatus.BAD_REQUEST);

    }
}
