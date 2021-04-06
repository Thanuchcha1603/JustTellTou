package Entity;

import Entity.Actors;
import Entity.Categories;
import Entity.Directors;
import Entity.Reviewers;
import Entity.Users;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2564-04-06T16:21:33")
@StaticMetamodel(Movie.class)
public class Movie_ { 

    public static volatile ListAttribute<Movie, Users> usersList;
    public static volatile SingularAttribute<Movie, String> datails;
    public static volatile SingularAttribute<Movie, String> linkYouTube;
    public static volatile ListAttribute<Movie, Directors> directorsList;
    public static volatile ListAttribute<Movie, Reviewers> reviewersList;
    public static volatile ListAttribute<Movie, Categories> categoriesList;
    public static volatile SingularAttribute<Movie, Integer> movieID;
    public static volatile ListAttribute<Movie, Actors> actorsList;
    public static volatile SingularAttribute<Movie, String> movieName;

}