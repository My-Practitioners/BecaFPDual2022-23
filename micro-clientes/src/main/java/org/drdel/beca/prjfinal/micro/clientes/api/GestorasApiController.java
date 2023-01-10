package org.drdel.beca.prjfinal.micro.clientes.api;

import org.drdel.beca.prjfinal.micro.clientes.model.ArrayGestoraRequest;
import org.drdel.beca.prjfinal.micro.clientes.model.SaveGestoraRequest;
import org.drdel.beca.prjfinal.micro.clientes.model.service.IGestoraService;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-12-21T12:19:29.084Z[GMT]")
@RestController
public class GestorasApiController implements GestorasApi {

    @Autowired
    private IGestoraService gestoraService;


    private static final Logger log = LoggerFactory.getLogger(GestorasApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public GestorasApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<ArrayGestoraRequest> gestorasGet() {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                /*gestoraService.obtenerTodasGestoras();*/
                return new ResponseEntity<ArrayGestoraRequest>(objectMapper.readValue("[ {\n  \"id_gestora\" : 1,\n  \"nombre\" : \"gestora1\"\n}, {\n  \"id_gestora\" : 2,\n  \"nombre\" : \"gestora2\"\n} ]", ArrayGestoraRequest.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<ArrayGestoraRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<ArrayGestoraRequest>(HttpStatus.OK);
    }

    public ResponseEntity<SaveGestoraRequest> gestorasIdGestoraGet(@Parameter(in = ParameterIn.PATH, description = "", required=true, schema=@Schema()) @PathVariable("id_gestora") Integer idGestora) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<SaveGestoraRequest>(objectMapper.readValue("{\n  \"entity\" : {\n    \"id_gestora\" : 1,\n    \"nombre\" : \"gestora 12\",\n  \"AUD_CREA_DATE\" : \"2000-01-23\",\n    \"AUD_MOD_DATE\" : \"2000-01-23\",\n   \"AUD_CREA_PROC\" : \"AUD_CREA_PROC\",\n    \"AUD_MOD_PROC\" : \"MIGRACION\",\n    \"AUD_CREA_USU\" : \"SCRIPT_USER\",\n    \"AUD_MOD_USU\" : \"SCRIPT_USER\"\n    }\n}", SaveGestoraRequest.class), HttpStatus.OK);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<SaveGestoraRequest>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<SaveGestoraRequest>(HttpStatus.OK);
    }

    public ResponseEntity<String> gestorasPost(@Parameter(in = ParameterIn.DEFAULT, description = "the data to insert", required=true, schema=@Schema()) @Valid @RequestBody SaveGestoraRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<String>(objectMapper.readValue("\"Creación exitosa\"", String.class), HttpStatus.CREATED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}
