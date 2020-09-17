package lab4;

class Material {	
	private int m_id;
	private String name;
	private String producer;
	private int t_id;
	
	public int getM_Id() {
		return m_id;
	}
	public void setM_Id(int id) {
		this.m_id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	
	public int getT_Id() {
		return t_id;
	}
	public void setT_Id(int t_id) {
		this.t_id = t_id;
	}
	
	@Override
	public String toString() {
		return "Material [ID=" + m_id + ", Name=" + name + ", Producer=" + producer + "Type_ID=" + t_id +"]";
	}
}
