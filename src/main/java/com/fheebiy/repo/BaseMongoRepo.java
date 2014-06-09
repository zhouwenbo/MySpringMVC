package com.fheebiy.repo;
import java.util.HashMap;
import java.util.List;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;


public abstract class BaseMongoRepo<T> {

    /**
     * spring mongodb　集成操作类　
     */
    protected MongoTemplate mongoTemplate;


    /**
     * 通过条件查询实体(集合)
     *
     * @param query
     */
    public List<T> find(Query query){
        return mongoTemplate.find(query, this.getEntityClass());

    }

    /**
     * 通过一定的条件查询一个实体
     *
     * @param query
     * @return
     */
    public T findOne(Query query) {
        return mongoTemplate.findOne(query, this.getEntityClass());
    }

    /**
     * 通过条件查询更新数据
     *
     * @param query
     * @param update
     * @return
     */
    public void update(Query query, Update update) {
        mongoTemplate.upsert(query, update, this.getEntityClass());
    }

    /**
     * 保存一个对象到mongodb
     *
     * @param entity
     * @return
     */
    public T save(T entity) {
        mongoTemplate.save(entity);
        return entity;
    }

    /**
     * 通过ID获取记录
     *
     * @param id
     * @return
     */
    public T findById(String id){
        return mongoTemplate.findById(id, this.getEntityClass());
    }

    /**
     * 通过ID获取记录,并且指定了集合名(表的意思)
     *
     * @param id
     * @param collectionName
     *            集合名
     * @return
     */
    public T findById(String id, String collectionName) {
        return mongoTemplate.findById(id, this.getEntityClass(), collectionName);
    }

    /**
     * 分页查询
     * @param jsp
     * @param query
     * @return
     */
    //public Page<T> findPage(Page<T> jsp,Query query);

    /**
     * 求数据总和
     * @param query
     * @return
     */
    public long count(Query query){
        return mongoTemplate.count(query,getEntityClass());
    }

    public void delete(Query query){
        mongoTemplate.remove(query, getEntityClass());
    }

    /**
     * 注入mongodbTemplate
     *
     * @param mongoTemplate
     */
    protected abstract void setMongoTemplate(MongoTemplate mongoTemplate);

    /**
     * 获取需要操作的实体类class
     *
     * @return
     */
    protected abstract  Class<T> getEntityClass();


}
