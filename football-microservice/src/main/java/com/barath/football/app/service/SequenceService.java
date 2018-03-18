package com.barath.football.app.service;

import com.barath.football.app.repository.SequenceRepository;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by barath on 18/03/18.
 */
public abstract class SequenceService implements SequenceRepository{


    protected MongoOperations mongoOperations;

    @Override
    public Long getNextSequenceId(String key) {

        Query query = new Query(Criteria.where("_id").is(key));

        Update update = new Update();
        update.inc("seq", 1);

        FindAndModifyOptions options = new FindAndModifyOptions();
        options.returnNew(true);


        mongoOperations.findAndModify(query, update, options, Object.class);

        return null;
    }
}
