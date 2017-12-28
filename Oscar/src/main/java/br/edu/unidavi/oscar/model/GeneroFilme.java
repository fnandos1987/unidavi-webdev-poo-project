package br.edu.unidavi.oscar.model;

public enum GeneroFilme {

    ACAO(1, "Ação"),
    DRAMA(2, "Drama"),
    COMEDIA(3, "Comédia"),
    ROMANCE(4, "Romance"),
    FANTASIA(5, "Fantasia"),
    SCIFI(6, "Sci-Fi"),
    SUSPENSE(7, "Suspense"),
    MUSICAL(8, "Musical"),
    UNKNOWN(0, "Desconhecido");

    private final Integer id;
    private final String descricao;

    GeneroFilme(Integer cod, String desc) {
        this.id = cod;
        this.descricao = desc;
    }

    public static GeneroFilme getById(Integer id) {
        for (GeneroFilme e : values()) {
            if (e.id.equals(id)) {
                return e;
            }
        }
        return UNKNOWN;
    }

    public Integer getId() {
        return id;
    }

    public String getDescricao() {
        return descricao;
    }
}
