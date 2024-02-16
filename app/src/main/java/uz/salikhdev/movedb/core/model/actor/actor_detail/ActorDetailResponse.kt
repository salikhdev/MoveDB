package uz.salikhdev.movedb.core.model.actor.actor_detail


import com.google.gson.annotations.SerializedName

data class ActorDetailResponse(
    @SerializedName("adult")
    val adult: Boolean, // false
    @SerializedName("also_known_as")
    val alsoKnownAs: List<String>,
    @SerializedName("biography")
    val biography: String, // Thomas Jeffrey Hanks (born July 9, 1956) is an American actor and filmmaker. Known for both his comedic and dramatic roles, Hanks is one of the most popular and recognizable film stars worldwide, and is widely regarded as an American cultural icon.Hanks made his breakthrough with leading roles in the comedies Splash (1984) and Big (1988). He won two consecutive Academy Awards for Best Actor for starring as a gay lawyer suffering from AIDS in Philadelphia (1993) and a young man with below-average IQ in Forrest Gump (1994). Hanks collaborated with film director Steven Spielberg on five films: Saving Private Ryan (1998), Catch Me If You Can (2002), The Terminal (2004), Bridge of Spies (2015), and The Post (2017), as well as the 2001 miniseries Band of Brothers, which launched him as a director, producer, and screenwriter.Hanks' other notable films include the romantic comedies Sleepless in Seattle (1993) and You've Got Mail (1998); the dramas Apollo 13 (1995), The Green Mile (1999), Cast Away (2000), Road to Perdition (2002), and Cloud Atlas (2012); and the biographical dramas Saving Mr. Banks (2013), Captain Phillips (2013), Sully (2016), and A Beautiful Day in the Neighborhood (2019). He has also appeared as the title character in the Robert Langdon film series, and has voiced Sheriff Woody in the Toy Story film series.Description above from the Wikipedia article Tom Hanks, licensed under CC-BY-SA, full list of contributors on Wikipedia.
    @SerializedName("birthday")
    val birthday: String, // 1956-07-09
    @SerializedName("deathday")
    val deathday: Any, // null
    @SerializedName("gender")
    val gender: Int, // 2
    @SerializedName("homepage")
    val homepage: Any, // null
    @SerializedName("id")
    val id: Int, // 31
    @SerializedName("imdb_id")
    val imdbId: String, // nm0000158
    @SerializedName("known_for_department")
    val knownForDepartment: String, // Acting
    @SerializedName("name")
    val name: String, // Tom Hanks
    @SerializedName("place_of_birth")
    val placeOfBirth: String, // Concord, California, USA
    @SerializedName("popularity")
    val popularity: Double, // 82.989
    @SerializedName("profile_path")
    val profilePath: String // /xndWFsBlClOJFRdhSt4NBwiPq2o.jpg
)