package Entity;

import Entity.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2564-04-06T16:21:33")
@StaticMetamodel(Categories.class)
public class Categories_ { 

    public static volatile SingularAttribute<Categories, Integer> catID;
    public static volatile SingularAttribute<Categories, String> catName;
    public static volatile ListAttribute<Categories, Movie> movieList;

}