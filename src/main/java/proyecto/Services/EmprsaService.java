package proyecto.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proyecto.Repository.EmpresaRepository;

@Service
public class EmprsaService {
    @Autowired
    private EmpresaRepository empresaRepository;
}
