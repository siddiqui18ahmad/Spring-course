package com.ahmad.userauth.dao.daoImpl;
import com.ahmad.userauth.dao.Dao;
import com.ahmad.userauth.model.User;
import com.microsoft.azure.cosmosdb.*;
import com.microsoft.azure.cosmosdb.rx.AsyncDocumentClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import rx.Observable;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class DaoImpl implements Dao {
    @Autowired
    private AsyncDocumentClient documentClient;
    @Autowired
    private FeedOptions feedOptions;
    @Value("${cosmos.database}")
    private String databaseName;
    @Value("${cosmos.database.collection}")
    private String collectionName;
    @Value("${cosmos.collectionLink}")
    private String collectionLink;
    @Value("${cosmos.documentLink}")
    private String documentLink;
    private List<User> users;
    private String query_for_allUser = "SELECT * FROM User";
    private String query_for_User = "SELECT * FROM User WHERE User.id=@id";
    private String s=null;

    public List<User> getAllUsers() {
        SqlQuerySpec query = new SqlQuerySpec(query_for_allUser);
        Observable<FeedResponse<Document>> queryResults = documentClient.queryDocuments(collectionLink, query, feedOptions);
        Observable<List<User>> userlist = queryResults.map(e -> (List) e.getResults().stream().map(s -> s.toObject(User.class)).collect(Collectors.toList()));
        return userlist.toBlocking().first();
    }


    public String register(User user) {
        if(user.getUsername().length()==0 || user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getPassword().length()==0)
            s= "Invalid Username Please Enter a Valid Username";
        else {

            Observable<ResourceResponse<Document>> response = documentClient.createDocument(collectionLink, user, new RequestOptions(), true);
            System.out.println(response.map(e -> e.getResource().toObject(User.class)).toBlocking().first().toString());
            s= "Hello " +user.getUsername() + ", You are Successfully Registered";
        }
        return s;
    }

    public String login(User user) {
        if(user.getUsername().length()==0 || user.getUsername().isEmpty() || user.getPassword().isEmpty() || user.getPassword().length()==0)
            s= "Invalid Username Please Enter a Valid Username";
        else {
            List<User> users = getAllUsers();
            int c=0;
            for(User u: users)
            {
                if(user.getUsername().equals(u.getUsername())&& user.getPassword().equals(u.getPassword()))
                {
                    c++;
                    s= "Hello " + user.getUsername() + ", You Are Successfully LoggedIn";
                }
            }
            if (c != 1)
                s= user.getUsername() + ", You are not Registered";
        }
        return s;
    }

}

