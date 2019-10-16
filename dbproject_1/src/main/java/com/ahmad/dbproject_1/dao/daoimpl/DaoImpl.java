package com.ahmad.dbproject_1.dao.daoimpl;

import com.ahmad.dbproject_1.dao.Dao;
import com.ahmad.dbproject_1.model.User;
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

    public Observable<List<User>> getAllUsers() {
        SqlQuerySpec query = new SqlQuerySpec(query_for_allUser);
        return getQueryResult(query);
    }

    public Observable<User> getUser(String id) {
        SqlParameterCollection params = new SqlParameterCollection(new SqlParameter("@id", id));
        SqlQuerySpec query = new SqlQuerySpec(query_for_User, params);
        return getQueryResult(query).flatMapIterable(x -> x);
    }


    public Observable<List<User>> getQueryResult(SqlQuerySpec query) {
        Observable<FeedResponse<Document>> queryResults = documentClient.queryDocuments(collectionLink, query, feedOptions);
        Observable<List<User>> userlist = queryResults.map(e -> (List) e.getResults().stream().map(s -> s.toObject(User.class)).collect(Collectors.toList()));
        return userlist;
    }


    public void addUser(User user) {
        Observable<ResourceResponse<Document>> response = documentClient.createDocument(collectionLink, user, new RequestOptions(), true);
        response.subscribe().unsubscribe();
//        /*return response.map(e -> e.getResource().toObject(User.class));*/
    }

    public void updateUser(User user, String id) {
        String docLink = String.format(documentLink, id);
        Observable<ResourceResponse<Document>> response = documentClient.replaceDocument(docLink, user, null);
        response.subscribe().unsubscribe();
//        return response.map(e -> e.getResource().toObject(User.class));
    }

    public void deleteUser(String id) {
       String docLink = String.format(documentLink, id);
       RequestOptions ro = new RequestOptions();
       ro.setPartitionKey(new PartitionKey(id));
       Observable<ResourceResponse<Document>> response = documentClient.deleteDocument(docLink, ro);
       response.subscribe().unsubscribe();

    }
}