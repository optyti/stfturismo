package br.com.stfturismo.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;

import org.jboss.logging.Logger;

@MappedSuperclass
public class EntidadeBase  {
	
	protected static final Logger log = Logger.getLogger(EntidadeBase.class);

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "ID_GENERATOR")
	@TableGenerator(name = "ID_GENERATOR", pkColumnName = "SEQUENCE_NAME", table = "SEQUENCE_TABLE", allocationSize = 1, valueColumnName = "NEXT_VAL")
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntidadeBase other = (EntidadeBase) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean isNovoRegistro() {
		return getId() == null;
	}

	@Override
	protected EntidadeBase clone() {
		// TODO Auto-generated method stub
		try {
			return (EntidadeBase) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
