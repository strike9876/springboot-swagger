package io.mahesh.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.mahesh.web.model.Plan;
import io.mahesh.web.services.PlanService;
import io.swagger.annotations.*;

@RestController
@RequestMapping("/plan")
@Api(value = "plan", produces = "application/json", tags = { "Controlador Plan" })
public class PlanController {
    @Autowired
    PlanService planService;

    @GetMapping("/")
    @ApiOperation(value = "Listar registros", tags = { "Controlador Plan" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Plan.class) })
    public List<Plan> GetPlans() {
        return planService.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Listar un registro", tags = { "Controlador Plan" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Plan.class) })
    public Plan GetPlan(@PathVariable Integer id) {
            return planService.findById(id);
    }
    @PostMapping("/")
    @ApiOperation(value = "Servicio para registrar", tags = { "Controlador Plan" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Plan.class) })
    public Plan PostPlan(@RequestBody Plan plan) {
        return planService.registrar(plan);
    }
    @PutMapping("/")
    @ApiOperation(value = "Modificar un registro", tags = { "Controlador Plan" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Plan.class) })
    public Plan PutPlan(@RequestBody Plan plan) {
        return planService.update(plan);
    }
    @DeleteMapping("/{id}")
    @ApiOperation(value = "Eliminar un registro", tags = { "Controlador Plan" })
	@ApiResponses(value = { @ApiResponse(code = 200, message = "OK", response = Plan.class) })
    public Integer DeletePlan(@PathVariable Integer id) {
        planService.deleteById(id);
        return id;
    }
}