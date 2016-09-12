package models;

/**
 * Created by amadou on 12/09/2016.
 */
 import javax.persistence.Column;
        import javax.persistence.Entity;
        import javax.persistence.Id;
        import javax.persistence.Table;

@Entity
@Table(name = "T_PRODUCTS")
public class Product extends Model {
    // Cette variable va nous permettre de passer des requÃªtes dans la base de donnÃ©es
    public static final Find<Long, Product> find = new Finder<>(Product.class);
    @Id
    @Column(name = "ID") // Definir le nom de la colonne dans la base de donnÃ©e.
    public Long id;
    @Column(name = "TITLE")
    @Constraints.Required
    public String title;
    // La definition de nom de colonne n'est pas obligatoire.
    // Le nom e l'attribut sera utilisÃ© par defaut.
    public String presentationImage;
}

