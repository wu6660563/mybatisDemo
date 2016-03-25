package com.ycy.mybatis.dao.impl;

import com.ycy.mybatis.dao.UserMapper;
import com.ycy.mybatis.module.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * Created by Administrator on 2015/8/31 0031.
 */
public class UserMappermpl implements UserMapper {
    private  SqlSessionFactory sqlSessionFactory;
    public UserMappermpl(SqlSessionFactory sqlSessionFactory){
       this.sqlSessionFactory=sqlSessionFactory;
    }

    public void deleteUser(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user= sqlSession.selectOne("test.deleteUser", id);
        sqlSession.close();
    }

    public void updateUser(User user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        sqlSession.selectOne("test.updateUser", user);
        sqlSession.close();
    }

    public List<User> findUserResultMap(User user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        List<User> userList= sqlSession.selectList("com.ycy.mybatis.dao.UserMapper.findUserResultMap",user);
        sqlSession.close();
        return userList;
    }

    public User getUserById(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
       User user= sqlSession.selectOne("getUserById", id);
        sqlSession.close();
        return user;
    }

    public List<User> findUserByName(String name) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
       List<User> userList= sqlSession.selectList("test.findUserByName", name);
        sqlSession.close();
        return userList;
    }

    public void insertUser(User user) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        //2通过sqlsession操作数据库
        sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        sqlSession.close();
    }
}
