package com.example.dio.controller;

import com.example.dio.dto.request.TableRequest;
import com.example.dio.dto.response.TableResponse;
import com.example.dio.service.TableService;
import com.example.dio.util.ResponseBuilder;
import com.example.dio.util.ResponseStructure;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("${app.base-url}")
//@Tag(name = "Table Controller", description = "Collection of Tables")
public class TableController {

    private final TableService tableService;

    @PostMapping("/tables/restaurant/{id}")
    public ResponseEntity<ResponseStructure<TableResponse>> addTable(@PathVariable long id, @RequestBody TableRequest tableRequest){

        TableResponse tableResponse = tableService.addTable(id,tableRequest);

        return ResponseBuilder.created(tableResponse,"Table created");
    }
}
