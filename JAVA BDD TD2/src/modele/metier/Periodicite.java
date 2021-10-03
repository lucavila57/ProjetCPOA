package modele.metier;


public class Periodicite {

		private int id;
		private String libelle;
		
		//Constructeur
		public Periodicite(int id, String libelle) {
			super();
			this.id = id;
			this.libelle = libelle;
		}

		// Getter and Setter
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getLibelle() {
			return libelle;
		}
		public void setLibelle(String libelle) {
			this.libelle = libelle;
		}
		//fin Getter Setter

		//toString
		@Override
		public String toString() {
			return "Periodicite [id=" + id + ", libelle=" + libelle + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id;
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
			Periodicite other = (Periodicite) obj;
			if (id != other.id)
				return false;
			return true;
		}
		
		
}
