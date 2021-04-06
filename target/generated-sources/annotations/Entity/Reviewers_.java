package Entity;

import Entity.Movie;
import Entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2564-04-06T16:21:33")
@StaticMetamodel(Reviewers.class)
public class Reviewers_ { 

    public static volatile SingularAttribute<Reviewers, Integer> reviewerID;
    public static volatile SingularAttribute<Reviewers, String> reviewerLname;
    public static volatile ListAttribute<Reviewers, Movie> movieList;
    public static volatile SingularAttribute<Reviewers, String> reviewerFname;
    public static volatile SingularAttribute<Reviewers, Users> users;

}