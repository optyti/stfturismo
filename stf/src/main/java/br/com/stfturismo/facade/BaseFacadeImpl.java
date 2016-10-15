package br.com.stfturismo.facade;

import java.util.List;
import java.util.logging.Logger;

public class BaseFacadeImpl<T extends BaseEntity> implements IBaseFacade<BaseEntity>{

	
	private static final Logger log = Logger.getLogger( BaseFacadeImpl.class.getSimpleName() );

	@Override
	public BaseEntity findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BaseEntity> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseEntity save(BaseEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BaseEntity update(BaseEntity entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(BaseEntity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long entityId) {
		// TODO Auto-generated method stub
		
	}
	
}
