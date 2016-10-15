package br.com.stfturismo.facade;

import java.util.List;

import org.jboss.logging.Logger;

import br.com.stfturismo.dao.IBaseDAO;

public class BaseFacadeImpl<T extends BaseEntity> implements IBaseFacade<BaseEntity>{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger( BaseFacadeImpl.class.getSimpleName() );
	protected IBaseDAO<T> baseDAO;
	
	public BaseFacadeImpl() {
		super();
	}

	public BaseFacadeImpl(IBaseDAO<T> baseDAO) {
		super();
		this.baseDAO = baseDAO;
	}

	@Override
	public BaseEntity findById(Long id) {
		log.info( "Recuperando entidade pelo ID..." );
		if ( id == null ) {
			log.warn("O ID recebido para recuperar entidade pelo ID é nulo");
			throw new IllegalArgumentException("O ID recebido é nulo.");
		}
		BaseEntity entity = this.baseDAO.findById( id );
		if ( entity != null ) {
			log.info( "Entidade localizada: " + entity.toString() );
		} else {
			log.info( "Entidade não encontrada" );
		}
		return entity;
	}

	@Override
	public List<BaseEntity> findAll() {
		log.info( "Recuperando todas as entidades..." );
		List<BaseEntity> lista = this.baseDAO.findAll();
		if ( lista==null || lista.isEmpty()) {
			log.info( "Busca finalizada! Nenhuma entidade encontrada" );
		} else {
			log.info( "Busca finalizada! " + lista.size() + " entidades encontradas!" );
		}
		return lista;
	}

	@Override
	public BaseEntity save(BaseEntity entity) {
		log.info( "Persistindo entidade..." );
		this.validaEntidade( entity );
		entity = this.baseDAO.save( entity );
		log.info( "Entidade persistida com êxito..." );
		return entity;
	}

	@Override
	public BaseEntity update(BaseEntity entity) {
		log.info( "Atualizando entidade..." );
		this.validaEntidade( entity );		
		this.baseDAO.update( entity );		
		log.info( "Entidade atualizada com êxito..." );		
		return entity;
	}
	
	@Override
	public void delete(BaseEntity entity) {
		log.info( "Excluindo entidade..." );
		this.validaEntidade( entity );
		this.baseDAO.delete( entity );
		log.info( "Entidade excluída." );
	}

	@Override
	public void deleteById(Long entityId) {
		log.info( "Excluindo entidade pelo ID..." );
		if ( entityId != null ) {
			BaseEntity entity = this.findById( entityId );
			if ( entity == null ) {
				log.warn( "Entidade  com ID " + entityId + " não encontrada para poder ser excluída" );
			} else {
				this.baseDAO.delete( entity );
				log.info( "Exclusão por ID concluída." );
			}
		} else {
			log.warn( "A entidade a ser deletada pelo ID é nula.");
		}
	}
	
	private void validaEntidade(BaseEntity entity) {
		if ( entity == null ) {
			log.warn( "Impossível executar a operação com entidade nula" );
			throw new IllegalStateException("A entidade processada é nula.");
		}
	}

	@Override
	public BaseEntity merge(BaseEntity entity) {
		log.info( "Persistindo entidade..." );
		this.validaEntidade( entity );
		entity = this.baseDAO.merge( entity );
		log.info( "Entidade persistida com êxito..." );
		return entity;
	}
	
}
