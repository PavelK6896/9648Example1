package data1.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "categories")
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString(of = {"id", "title"} )
public class Category1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

//@JsonManagedReference is the forward part of reference – the one that gets serialized normally.
//это передняя часть ссылки – та, которая обычно сериализуется.
//@JsonBackReference is the back part of reference – it will be omitted from serialization.
//это задняя часть ссылки – она будет опущена из сериализации.

    @ManyToMany
    @JoinTable(name = "products_categories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    @JsonBackReference
    private List<Product1> products;

    public Category1(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
