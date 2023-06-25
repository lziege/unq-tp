package io.paketo.demo.webservice

import io.paketo.demo.webservice.mapper.*
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Controller
@CrossOrigin
@RequestMapping("/")
@RestController
class MainController {
    @GetMapping("/")
    fun default() : ResponseEntity<Any> {
        return ResponseEntity.status(200).body("Welcome to EPERS Online")
    }

}