package com.company.GameStore.service;

import com.company.GameStore.models.Invoices;
import com.company.GameStore.models.ProcessingFees;
import com.company.GameStore.repositories.ProcessingFeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

//       need to calculate total with
@Service
public class ProcessingFeeAdd {

    ProcessingFeeRepository processingFeeRepository;

@Autowired
    public ProcessingFeeAdd(ProcessingFeeRepository processingFeeRepository) {
        processingFeeRepository.save(new ProcessingFees("Consoles", new BigDecimal(14.99)));
        processingFeeRepository.save(new ProcessingFees("T-Shirts", new BigDecimal(1.98)));
        processingFeeRepository.save(new ProcessingFees("Games", new BigDecimal(1.49)));

    }
}
