package org.drdel.beca.prjfinal.micro.gestoras.controllers;

import org.drdel.beca.prjfinal.micro.gestoras.api.commons.AppController;
import org.drdel.beca.prjfinal.micro.gestoras.model.domain.DireccionGestoraDTO;
import org.drdel.beca.prjfinal.micro.gestoras.model.service.IDireccionGestoraService;
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
public class DireccionGestoraController extends AppController {

    private static final String MSG_RESPONSE_KEY_MENSAJE= "mensaje";
    private static final String MSG_RESPONSE_KEY_DIRECCION_GESTORA= "Dirección gestora";
    private static final String MSG_RESPONSE_KEY_ERRORES= "errors";

    private static final String NO_VALIDO="Direccion gestora no válido";
    private static final String ACTUALIZADO="Direccion gestora actualizado con éxito";

    @Autowired
    private IDireccionGestoraService direccionGestoraService;

    @GetMapping("/direccion-gestoras")
    public List<DireccionGestoraDTO> list(){
        return direccionGestoraService.obtenerTodosDireccionGestora();
    }

    @GetMapping("/direccion-gestoras/{id}")
    public ResponseEntity<Map<String, Object>> show(@PathVariable Long id){
        DireccionGestoraDTO direccionGestoraDto;
        try {
            direccionGestoraDto=direccionGestoraService.obtenerDireccionGestora(id);
        }catch (Exception e){
            return gestionarExceptionResponse(e);
        }
        if (direccionGestoraDto==null){
            return gestionarResponse(
                    "La dirección gestora ID: ".concat(id.toString()).concat(" no existe en la BD"),
                    direccionGestoraDto,HttpStatus.NOT_FOUND);
        }

        return gestionarResponse(
                "Direccion gestora obtenida con éxito",
                direccionGestoraDto,
                HttpStatus.OK);
    }

    @PostMapping(value={"/direccion-gestoras"})
    public ResponseEntity<Map<String, Object>> create(@Valid @RequestBody DireccionGestoraDTO direccionGestoraDto,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        Long id;
        DireccionGestoraDTO direccionGuardada;

        try {
            id = direccionGestoraService.crearDireccionGestora(direccionGestoraDto);
            direccionGuardada = direccionGestoraService.obtenerDireccionGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                "Direccion gestora creada con éxito",
                direccionGuardada,
                HttpStatus.CREATED);

    }


    @PutMapping("/direccion-gestoras/{id}")
    public ResponseEntity<Map<String, Object>> update(@PathVariable Long id,
                                                      @Valid @RequestBody DireccionGestoraDTO direccionGestoraDto,
                                                      BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        DireccionGestoraDTO direccionGestoraGuardada;

        try {
            direccionGestoraService.actualizarDireccionGestora(direccionGestoraDto);
            direccionGestoraGuardada = direccionGestoraService.obtenerDireccionGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                direccionGestoraGuardada,
                HttpStatus.CREATED);

    }


    @PatchMapping("/direccion-gestoras/operative/{id}")
    public ResponseEntity<Map<String, Object>> updateOperative(@PathVariable Long id,
                                                               @Valid @RequestBody DireccionGestoraDTO direccionGestoraDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        DireccionGestoraDTO direccionGestoraGuardada;

        try {
            direccionGestoraService.activarDireccionGestora(direccionGestoraDto);
            direccionGestoraGuardada = direccionGestoraService.obtenerDireccionGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                direccionGestoraGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/direccion-gestoras/canceled/{id}")
    public ResponseEntity<Map<String, Object>> updateCanceled(@PathVariable Long id,
                                                              @Valid @RequestBody DireccionGestoraDTO direccionGestoraDto,
                                                              BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        DireccionGestoraDTO direccionGestoraGuardada;

        try {
            direccionGestoraService.cancelarDireccionGestora(direccionGestoraDto);
            direccionGestoraGuardada = direccionGestoraService.obtenerDireccionGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                direccionGestoraGuardada,
                HttpStatus.CREATED);

    }

    @PatchMapping("/direccion-gestoras/suspended/{id}")
    public ResponseEntity<Map<String, Object>> updateSuspended(@PathVariable Long id,
                                                               @Valid @RequestBody DireccionGestoraDTO direccionGestoraDto,
                                                               BindingResult result) {

        if(result.hasErrors()) {
            return gestionarResponseNoValida(NO_VALIDO, result);
        }

        DireccionGestoraDTO direccionGestoraGuardada;

        try {
            direccionGestoraService.suspenderDireccionGestora(direccionGestoraDto);
            direccionGestoraGuardada = direccionGestoraService.obtenerDireccionGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        return gestionarResponse(
                ACTUALIZADO,
                direccionGestoraGuardada,
                HttpStatus.CREATED);

    }

    @DeleteMapping("/direccion-gestoras/{id}")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable Long id) {

        DireccionGestoraDTO direccionGestoraDto;

        try {
            direccionGestoraDto = direccionGestoraService.obtenerDireccionGestora(id);
            if (direccionGestoraDto != null)
                direccionGestoraService.borrarDireccionGestora(id);
        } catch (Exception e) {
            return gestionarExceptionResponse(e);
        }

        if (direccionGestoraDto != null)
            return gestionarResponse(
                    "Direccion gestora eliminada con éxito",
                    direccionGestoraDto,
                    HttpStatus.OK);
        else
            return gestionarResponse(
                    "Direccion gestora inexistente: ".concat(id.toString()),
                    direccionGestoraDto,
                    HttpStatus.NOT_FOUND);
    }



    private ResponseEntity<Map<String, Object>> gestionarResponse(String msg, DireccionGestoraDTO direccionGestoraDto, HttpStatus status) {

        Map<String, Object> mapResult = new HashMap<>();

        mapResult.put(MSG_RESPONSE_KEY_MENSAJE, msg);
        if(direccionGestoraDto != null)
            mapResult.put(MSG_RESPONSE_KEY_DIRECCION_GESTORA, direccionGestoraDto);

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
