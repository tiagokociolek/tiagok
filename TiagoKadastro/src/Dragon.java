// Tiago Kociolek
// 4�Sian
public class Dragon {

	private String nome;
	private String tipo;
	private String especie;
	private float forca;
	
	public Dragon()	{}
			
	public Dragon(String nome, String tipo, String especie, float forca) {
		this.nome = nome;
		this.tipo = tipo;
		this.especie = especie;
		this.forca = forca;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getEspecie() {
		return especie;
	}
	public void setEspecie(String especie) {
		this.especie = especie;
	}
	public void setForca(float forca) {
		this.forca = forca;
	}
	public float getForca() {
		return forca;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dragon other = (Dragon) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Dragon [Nome: " + nome + ", Tipo: " + tipo + ", Especie: " + especie + ", For�a: "+ forca + "]";
	}
			
}