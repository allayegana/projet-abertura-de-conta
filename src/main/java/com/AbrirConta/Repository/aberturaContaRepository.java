package com.AbrirConta.Repository;

import com.AbrirConta.models.Abertura_conta;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface aberturaContaRepository extends JpaRepository<Abertura_conta, ID> {

    Abertura_conta findById(Long id);

}
