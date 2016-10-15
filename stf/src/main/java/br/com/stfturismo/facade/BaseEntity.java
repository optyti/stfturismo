package br.com.stfturismo.facade;

import java.io.Serializable;

public interface BaseEntity extends Serializable{

	Serializable getId();

	boolean isNovoRegistro();
	
}
