package Entity;

import Entity.Movie;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2563-11-16T15:32:59")
@StaticMetamodel(ReviewMovie.class)
public class ReviewMovie_ { 

    public static volatile SingularAttribute<ReviewMovie, Integer> reviewerID;
    public static volatile SingularAttribute<ReviewMovie, Double> rating;
    public static volatile SingularAttribute<ReviewMovie, Movie> movieID;
    public static volatile SingularAttribute<ReviewMovie, Integer> reviewID;
    public static volatile SingularAttribute<ReviewMovie, String> reviewText;

}