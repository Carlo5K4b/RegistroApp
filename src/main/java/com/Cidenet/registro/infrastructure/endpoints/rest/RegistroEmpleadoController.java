package com.Cidenet.registro.infrastructure.endpoints.rest;

import com.Cidenet.registro.app.dto.request.RegistroEmpleadoRequest;
import com.Cidenet.registro.app.dto.response.RegistroEmpleadoResponse;
import com.Cidenet.registro.app.dto.response.SaveRegistroEmpleadoResponse;
import com.Cidenet.registro.app.services.RegistroEmpleadoService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@OpenAPIDefinition(
        info = @Info(
                title = "Empleados",
                version = "1.0",
                description = "Esta API se encarga de gestionar los empleados."
        )
)
@RestController
@RequestMapping("/api/v1/registro-empleado")
@CrossOrigin(origins = "*")
public class RegistroEmpleadoController {
    private final RegistroEmpleadoService registroEService;

    public RegistroEmpleadoController(RegistroEmpleadoService registroEService) {
        this.registroEService = registroEService;
    }

    @PostMapping()
        @Operation(summary = "Save registro empleado")
    public ResponseEntity<SaveRegistroEmpleadoResponse> save(@Valid @RequestBody RegistroEmpleadoRequest registroERequest) {
        return new ResponseEntity<>(registroEService.save(registroERequest), HttpStatus.CREATED);
    }
    @Operation(summary = "List empleados")
    @GetMapping("/list")
    public ResponseEntity<Page<RegistroEmpleadoResponse>> getAllCategories(
            @RequestParam  Integer page,
            @RequestParam  Integer size,
            @RequestParam  boolean orderAsc) {
        return ResponseEntity.ok(registroEService.getRegistrosE(page, size, orderAsc));
    }
}
