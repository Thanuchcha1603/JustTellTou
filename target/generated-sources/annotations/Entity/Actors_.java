package Entity;

import Entity.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2563-11-16T15:32:59")
@StaticMetamodel(Actors.class)
public class Actors_ { 

    public static volatile SingularAttribute<Actors, String> actorFname;
    public static volatile SingularAttribute<Actors, Integer> actorID;
    public static volatile SingularAttribute<Actors, String> actorLname;
    public static volatile ListAttribute<Actors, Movie> movieList;

}