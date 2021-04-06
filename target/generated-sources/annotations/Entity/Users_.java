package Entity;

import Entity.Movie;
import Entity.Reviewers;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2564-04-06T16:21:33")
@StaticMetamodel(Users.class)
public class Users_ { 

    public static volatile SingularAttribute<Users, String> fname;
    public static volatile SingularAttribute<Users, String> password;
    public static volatile SingularAttribute<Users, String> lname;
    public static volatile ListAttribute<Users, Reviewers> reviewersList;
    public static volatile ListAttribute<Users, Movie> movieList;
    public static volatile SingularAttribute<Users, String> userName;
    public static volatile SingularAttribute<Users, String> email;

}