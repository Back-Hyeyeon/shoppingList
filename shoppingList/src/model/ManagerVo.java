package model;

import java.util.Objects;

public class ManagerVo {
	private String m_id;
	private String m_pw;

	public ManagerVo() {
		super();
	}

	public ManagerVo(String m_id, String m_pw) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.m_id, this.m_pw);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ManagerVo)) {return false;}
		ManagerVo mgvo = (ManagerVo) obj;
		return mgvo.m_id.equals(this.m_id) && mgvo.m_pw.equals(this.m_pw);
	}

}
