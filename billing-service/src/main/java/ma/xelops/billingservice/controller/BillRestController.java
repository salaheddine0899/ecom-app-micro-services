package ma.xelops.billingservice.controller;

import lombok.RequiredArgsConstructor;
import ma.xelops.billingservice.dto.BillDto;
import ma.xelops.billingservice.service.BillService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bills")
@RequiredArgsConstructor
public class BillRestController {
    private final BillService billService;

    @GetMapping("/{id}")
    public BillDto getBillById(@PathVariable Integer id) {
        return billService.getBillById(id);
    }
}
