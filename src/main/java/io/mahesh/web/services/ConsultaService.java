package io.mahesh.web.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.mahesh.web.model.Cliente;
import io.mahesh.web.model.ClienteMovil;
import io.mahesh.web.model.Oferta;
import io.mahesh.web.model.OfertaMovil;
import io.mahesh.web.model.response.ClienteMovilOfertasResponse;
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

	public List<ClienteMovilOfertasResponse> GetClienteOferta(Date fechaIni, Date fechaFin) {
        List<ClienteMovilOfertasResponse> listResponse = new ArrayList<>();
		List<OfertaMovil> ofertasMovilesActivas = GetOfertasMovilActivas()
			.stream()
			.filter( x -> x.getOferta().getFechaFin().getTime() >= fechaIni.getTime() && x.getOferta().getFechaFin().getTime() <= fechaFin.getTime())
			.collect(Collectors.toList());
        for (OfertaMovil ofertaMovil : ofertasMovilesActivas) {
            ClienteMovilOfertasResponse aux = new ClienteMovilOfertasResponse();
            List<ClienteMovil> cliente = clienteMovilRepository.selectByIdLineaMovil(ofertaMovil.getLineaMovil().getIdLineaMovil());
            aux.setCliente(cliente.get(0).getCliente());
			aux.setLineaMovil(ofertaMovil.getLineaMovil());
			aux.setOferta(ofertaMovil.getOferta());
            listResponse.add(aux);
        }
        return listResponse;
    }

	public List<OfertaMovil> GetOfertasMovilActivas() {
        List<OfertaMovil> listResponse = new ArrayList<>();
		
        List<Cliente> clienteList = clienteRepository.findAll()
				.stream()
				.collect(Collectors.toList());
		for (Cliente cliente : clienteList) {
			List<ClienteMovil> listMoviles = clienteMovilRepository.selectByIdCliente(cliente.getIdCliente())
                .stream()
				.filter(x -> x.getLineaMovil().getEstado().getIdEstado() == 1)
                .collect(Collectors.toList());
			if(listMoviles.size() >= 3){
				for (ClienteMovil clienteMovil : listMoviles) {
					List<OfertaMovil> ofertaMoviles = ofertaMovilRepository.selectByIdLineaMovil(clienteMovil.getLineaMovil().getIdLineaMovil())
						.stream()
						.collect(Collectors.toList());

					ofertaMoviles.sort((d1, d2) -> d1.getOferta().getFechaFin().compareTo(d2.getOferta().getFechaFin()));
					listResponse.addAll(ofertaMoviles);
				}
			}
		}
        return listResponse;
    }
}
