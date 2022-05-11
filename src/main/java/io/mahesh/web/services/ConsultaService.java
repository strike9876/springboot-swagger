package io.mahesh.web.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.Cliente;
import io.mahesh.web.model.ClienteMovil;
import io.mahesh.web.model.Oferta;
import io.mahesh.web.model.OfertaMovil;
import io.mahesh.web.model.response.MovilOfertasResponse;
import io.mahesh.web.repository.ClienteMovilRepository;
import io.mahesh.web.repository.ClienteRepository;
import io.mahesh.web.repository.OfertaMovilRepository;


@Service
@Transactional(readOnly=true)
public class ConsultaService {
	@Autowired
	private ClienteRepository clienteRepository;
    @Autowired
	private ClienteMovilRepository clienteMovilRepository;
    @Autowired
	private OfertaMovilRepository ofertaMovilRepository;
	
	public List<MovilOfertasResponse> GetOfertasPorCadaLineaDeCliente(Integer nroDocumento, Integer idTipoDocumento) {
        List<MovilOfertasResponse> listResponse = new ArrayList<>();
        List<Cliente> cliente = clienteRepository.findByNroDocumentoIdTipoDocumento(nroDocumento, idTipoDocumento)
				.stream()
				.collect(Collectors.toList());
        List<ClienteMovil> listMoviles = clienteMovilRepository.selectByIdCliente(cliente.get(0).getIdCliente())
                .stream()
                .collect(Collectors.toList());
        for (ClienteMovil clienteMovil : listMoviles) {
            MovilOfertasResponse aux = new MovilOfertasResponse();
            aux.setLineaMovil(clienteMovil.getLineaMovil());
            List<OfertaMovil> listOfertasMovil = ofertaMovilRepository.selectByIdLineaMovil(clienteMovil.getLineaMovil().getIdLineaMovil())
                .stream()
                .collect(Collectors.toList());
            List<Oferta> listOfertas = new ArrayList<>();
            for (OfertaMovil ofertaMovil : listOfertasMovil) {
                listOfertas.add(ofertaMovil.getOferta());
            }
            aux.setListOferta(listOfertas);
            listResponse.add(aux);
        }
        return listResponse;
    }
}
