package azericardramin.insurancecompany.service;


import azericardramin.insurancecompany.main_exception.ResourceNotFoundException;
import azericardramin.insurancecompany.model.Company;
import azericardramin.insurancecompany.repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CompanyService {
    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Company getOne(long id) throws ResourceNotFoundException {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.orElseThrow(() -> new ResourceNotFoundException("Company not found with id :" + id ));
    }


    public List<Company> getAllCompanies() throws ResourceNotFoundException {
        List<Company> companies = (List<Company>) companyRepository.findAll();
        if (companies.isEmpty()) {
            throw new ResourceNotFoundException("Company not found !");
        }
        return companies;
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }


    public Map<String, Boolean> deleteEmployee(Long companyId)
            throws ResourceNotFoundException {
        Company company = companyRepository.findById(companyId)
                .orElseThrow( () -> new ResourceNotFoundException("Company couldnt deleted : " + companyId));
        companyRepository.delete(company);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }


}
