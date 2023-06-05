package org.drdel.beca.prjfinal.micro.gestoras.controllers;

import org.drdel.beca.prjfinal.micro.gestoras.api.commons.AppController;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.VariabilidadCapitalDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.IVariabilidadCapitalService;
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
public class VariabilidadCapitalController extends AppController {

    private static final String MSG_RESPONSE_KEY_MENSAJE= "Mensaje";
    private static final String MSG_RESPONSE_KEY_VARIABILIDAD_CAPITAL = "variabilidad capital";
    private static final String MSG_RESPONSE_KEY_ERRORES= "errors";

    private static final String NO_VALIDO="variabilidad capital no válido";
    private static final String ACTUALIZADO="variabilidad capital actualizada con éxito";

    @Autowired
    private IVariabilidadCapitalService variabilidadCapitalService;

    @GetMapping("/variabilidad-capital")
    public List<VariabilidadCapitalDTO> list(){
        return variabilidadCapitalService.obtenerTodosVariabilidadCapital();
    }

    @GetMapping("/variabilidad-capital/{code}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable String code){
        VariabilidadCapitalDTO variabilidadCapitalDto;
        try {
            variabilidadCapitalDto=variabilidadCapitalService.obtenerVariabilidadCapital(code);
        }catch (Exception e){
            return gestionarExceptionResponse(e);
        }
        if (variabilidadCapitalDto==null){
            return gestionarResponse(
                    "La variabilidad capital CODE: ".concat(code).concat(" no existe en la BD"),
                    variabilidadCapitalDto,HttpStatus.NOT_FOUND);
        }

        return gestionarResponse(
                "Variabilidad capital obtenida con éxito",
                variabilidadCapitalDto,
                HttpStatus.OK);
    }



    @PostMapping(value={"/variabilidad-capital"})
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody VariabilidadCapitalDTO variabilidadCapitalDto,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        String code;
        VariabilidadCapitalDTO variabilidadCapitalGuardada;

        try {
            code = variabilidadCapitalService.crearVariabilidadCapital(variabilidadCapitalDto);
            variabilidadCapitalGuardada = variabilidadCapitalService.obtenerVariabilidadCapital(code);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                "Variabilidad capital creada con éxito",
                variabilidadCapitalGuardada,
                HttpStatus.CREATED);

    }


    @PutMapping("/variabilidad-capital/{code}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable String code,
                                                      @Valid @RequestBody VariabilidadCapitalDTO variabilidadCapitalDto,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        VariabilidadCapitalDTO variabilidadCaptialGuardada;

        try {
            variabilidadCapitalService.actualizarVariabilidadCapital(variabilidadCapitalDto);
            variabilidadCaptialGuardada = variabilidadCapitalService.obtenerVariabilidadCapital(code);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                variabilidadCaptialGuardada,
                HttpStatus.CREATED);

    }


    @PatchMapping("/variabilidad-capital/operative/{code}")
    public ResponseEntity<Map<String, Object>> updateOperative(@PathVariable String code,
                                                               @Valid @RequestBody VariabilidadCapitalDTO variabilidadCapitalDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        VariabilidadCapitalDTO variabilidadCapitalGuardada;

        try {
            variabilidadCapitalService.activarVariabilidadCapital(variabilidadCapitalDto);
            variabilidadCapitalGuardada = variabilidadCapitalService.obtenerVariabilidadCapital(code);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                variabilidadCapitalGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/variabilidad-capital/canceled/{code}")
    public ResponseEntity<Map<String, Object>> updateCanceled(@PathVariable String code,
                                                              @Valid @RequestBody VariabilidadCapitalDTO variabilidadCapitalDto,
                                                              BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        VariabilidadCapitalDTO variabilidadCapitalGuardada;

        try {
            variabilidadCapitalService.cancelarVariabilidadCapital(variabilidadCapitalDto);
            variabilidadCapitalGuardada = variabilidadCapitalService.obtenerVariabilidadCapital(code);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                variabilidadCapitalGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/variabilidad-capital/suspended/{code}")
    public ResponseEntity<Map<String, Object>> updateSuspended(@PathVariable String code,
                                                               @Valid @RequestBody VariabilidadCapitalDTO variabilidadCapitalDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        VariabilidadCapitalDTO variabilidadCapitalGuardada;

        try {
            variabilidadCapitalService.suspenderVariabilidadCapital(variabilidadCapitalDto);
            variabilidadCapitalGuardada = variabilidadCapitalService.obtenerVariabilidadCapital(code);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                variabilidadCapitalGuardada,
                HttpStatus.CREATED);

    }

    @DeleteMapping("/variabilidad-capital/{code}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable String code) {

        VariabilidadCapitalDTO variabilidadCapitalDto;

        try {
            variabilidadCapitalDto = variabilidadCapitalService.obtenerVariabilidadCapital(code);
            if (variabilidadCapitalDto != null)
                variabilidadCapitalService.borrarVariabilidadCapital(code);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        if (variabilidadCapitalDto != null)
            return gestionarResponse(
                    "Variabilidad capital eliminada con éxito",
                    variabilidadCapitalDto,
                    HttpStatus.OK);
        else
            return gestionarResponse(
                    "Variabilidad capital inexistente: ".concat(code),
                    variabilidadCapitalDto,
                    HttpStatus.NOT_FOUND);
    }




    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, VariabilidadCapitalDTO variabilidadCapitalDto, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(variabilidadCapitalDto != null)
            mapResult.put(MSG_RESPONSE_KEY_VARIABILIDAD_CAPITAL, variabilidadCapitalDto);

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
